package com.ticona.estudiantesapp.repository

import com.ticona.estudiantesapp.data.local.Estudiante
import com.ticona.estudiantesapp.data.local.EstudianteDao
import kotlinx.coroutines.flow.Flow

class EstudianteRepository(private val dao: EstudianteDao) {

    fun getEstudiantes(): Flow<List<Estudiante>> = dao.getEstudiantes()

    fun searchEstudiantes(query: String): Flow<List<Estudiante>> =
        if (query.isBlank()) dao.getEstudiantes() else dao.searchEstudiantes(query)

    suspend fun getByDni(dni: String) = dao.getByDni(dni)

    suspend fun insert(estudiante: Estudiante) = dao.insert(estudiante)

    suspend fun update(estudiante: Estudiante) = dao.update(estudiante)

    suspend fun delete(estudiante: Estudiante) = dao.delete(estudiante)
}
