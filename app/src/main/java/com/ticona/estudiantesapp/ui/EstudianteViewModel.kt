package com.ticona.estudiantesapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ticona.estudiantesapp.data.local.AppDatabase
import com.ticona.estudiantesapp.data.local.Estudiante
import com.ticona.estudiantesapp.repository.EstudianteRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class EstudianteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EstudianteRepository

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _estudiantes = MutableStateFlow<List<Estudiante>>(emptyList())
    val estudiantes: StateFlow<List<Estudiante>> = _estudiantes

    private val _estudianteEdit = MutableStateFlow<Estudiante?>(null)
    val estudianteEdit: StateFlow<Estudiante?> = _estudianteEdit

    init {
        val dao = AppDatabase.getInstance(application).estudianteDao()
        repository = EstudianteRepository(dao)

        viewModelScope.launch {
            searchQuery
                .flatMapLatest { q -> repository.searchEstudiantes(q) }
                .collect { list -> _estudiantes.value = list }
        }
    }

    fun setSearchQuery(q: String) {
        _searchQuery.value = q
    }

    fun setEstudianteEdit(estudiante: Estudiante?) {
        _estudianteEdit.value = estudiante
    }

    fun guardarEstudiante(
        idEstudiante: Int?,
        apellido: String,
        nombre: String,
        dni: String,
        carrera: String,
        promedio: String,
        fechaIngreso: String,
        onResult: (Boolean, String) -> Unit
    ) {
        if (apellido.isBlank() || nombre.isBlank() || dni.isBlank()
            || carrera.isBlank() || promedio.isBlank() || fechaIngreso.isBlank()
        ) {
            onResult(false, "Completa todos los campos")
            return
        }

        if (dni.length != 8 || dni.any { !it.isDigit() }) {
            onResult(false, "El DNI debe tener 8 dígitos")
            return
        }

        val promedioDouble = promedio.replace(",", ".").toDoubleOrNull()
        if (promedioDouble == null || promedioDouble < 0.0 || promedioDouble > 20.0) {
            onResult(false, "El promedio debe estar entre 0 y 20")
            return
        }

        viewModelScope.launch {
            val existente = repository.getByDni(dni)
            if (existente != null && existente.idEstudiante != (idEstudiante ?: 0)) {
                onResult(false, "El DNI ya está registrado")
                return@launch
            }

            val estudiante = Estudiante(
                idEstudiante = idEstudiante ?: 0,
                apellido = apellido,
                nombre = nombre,
                dni = dni,
                carrera = carrera,
                promedio = promedioDouble,
                fechaIngreso = fechaIngreso
            )

            if (idEstudiante == null) {
                repository.insert(estudiante)
                onResult(true, "Estudiante registrado")
            } else {
                repository.update(estudiante)
                onResult(true, "Estudiante actualizado")
            }

            _estudianteEdit.value = null
        }
    }

    fun eliminarEstudiante(estudiante: Estudiante, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            repository.delete(estudiante)
            onResult(true, "Estudiante eliminado")
        }
    }
}
