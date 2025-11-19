package com.ticona.estudiantesapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index

@Entity(
    tableName = "estudiantes",
    indices = [Index(value = ["dni"], unique = true)] // DNI único
)
data class Estudiante(
    @PrimaryKey(autoGenerate = true)
    val idEstudiante: Int = 0,
    val apellido: String,
    val nombre: String,
    val dni: String,
    val carrera: String,
    val promedio: Double,
    val fechaIngreso: String
)
