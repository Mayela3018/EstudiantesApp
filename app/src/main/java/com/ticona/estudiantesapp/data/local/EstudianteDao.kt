package com.ticona.estudiantesapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EstudianteDao {

    @Query("SELECT * FROM estudiantes ORDER BY apellido")
    fun getEstudiantes(): Flow<List<Estudiante>>

    @Query("""
        SELECT * FROM estudiantes
        WHERE nombre LIKE '%' || :query || '%'
           OR carrera LIKE '%' || :query || '%'
        ORDER BY apellido
    """)
    fun searchEstudiantes(query: String): Flow<List<Estudiante>>

    @Query("SELECT * FROM estudiantes WHERE dni = :dni LIMIT 1")
    suspend fun getByDni(dni: String): Estudiante?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(estudiante: Estudiante)

    @Update
    suspend fun update(estudiante: Estudiante)

    @Delete
    suspend fun delete(estudiante: Estudiante)
}
