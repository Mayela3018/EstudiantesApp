🌟 EstudiantesApp – CRUD con Room + Jetpack Compose

Aplicación móvil desarrollada en Android Studio, utilizando Kotlin, Jetpack Compose y Room, que permite gestionar una lista de estudiantes mediante un CRUD completo: crear, leer, actualizar y eliminar.

Este proyecto fue desarrollado como parte del Examen Práctico de Programación Móvil – TECSUP.

📌 Características Principales

✔ CRUD completo de estudiantes
✔ Persistencia local con Room
✔ Interfaz moderna con Jetpack Compose
✔ Lista con búsqueda por nombre o carrera
✔ Validación de DNI único (8 dígitos)
✔ Validación del promedio (0 a 20)
✔ Manejo de estado con ViewModel + StateFlow
✔ Arquitectura limpia (DAO, Repository, ViewModel)
✔ Navegación simple entre pantallas
✔ Mensajes de error y confirmación con Toast

🧮 Modelo de Datos – Estudiante

La base de datos contiene una tabla Estudiante con los siguientes campos:

Campo	Tipo	Descripción
idEstudiante	Int	Autogenerado (Primary Key)
apellido	String	Apellido del estudiante
nombre	String	Nombre del estudiante
dni	String	DNI único de 8 dígitos
carrera	String	Carrera profesional
promedio	Double	Decimal (0 – 20), con validación
fechaIngreso	String	Fecha de ingreso (texto o formato dd/MM/yyyy)
📂 Estructura del Proyecto
app/
 └── java/com.ticona.estudiantesapp/
       ├── data/
       │    └── local/
       │           ├── Estudiante.kt
       │           ├── EstudianteDao.kt
       │           └── AppDatabase.kt
       │
       ├── repository/
       │       └── EstudianteRepository.kt
       │
       ├── ui/
       │   ├── EstudianteViewModel.kt
       │   ├── screens/
       │   │       ├── ListScreen.kt
       │   │       └── FormScreen.kt
       │   └── components/
       │           └── InputFields.kt
       │
       └── MainActivity.kt

🏗️ Tecnologías Utilizadas

Kotlin

Jetpack Compose

Room (persistencia local)

Coroutines + StateFlow

ViewModel

Material 3

⚙️ Instalación y Configuración
1. Clonar o descargar el proyecto
git clone https://github.com/usuario/EstudiantesApp.git

2. Abrir en Android Studio

File → Open → Seleccionar carpeta del proyecto

3. Actualizar dependencias

En build.gradle.kts están incluidas:
(Room, ViewModel, Lifecycle, Compose BOM, Coroutines…)

4. Ejecutar la app

Selecciona un emulador o dispositivo físico
👉 Clic en Run ▶

🖼️ Capturas de Pantalla

(Aquí pegas tus imágenes cuando las tomes)

📋 Lista principal

(imagen)

➕ Formulario – Registrar estudiante

(imagen)

✏️ Formulario – Editar estudiante

(imagen)

❌ Eliminación

(imagen)

🧪 Validaciones Implementadas

✔ DNI debe tener exactamente 8 dígitos
✔ DNI debe ser único en la base de datos
✔ Promedio debe estar entre 0 y 20
✔ Todos los campos obligatorios
✔ Se muestran mensajes de error y confirmación

🧠 Arquitectura (Resumen Técnico)
🏛️ Capa de Datos (Room)

Entidad: Estudiante.kt

DAO: consultas CRUD + búsquedas

Base de datos: AppDatabase.kt

📚 Repository

Intermediario entre DAO y ViewModel

Lógica de acceso a datos + validaciones de existencia

🎯 ViewModel

Manejo de estados con StateFlow

Corrutinas para operaciones Room

Lógica de validación

🎨 Jetpack Compose

Pantalla Lista

Pantalla Formulario

Componentes reutilizables

💡 Conclusión del Proyecto

Esta aplicación demuestra el uso correcto de:

Room

Arquitectura MVVM

Jetpack Compose

Navegación simple sin XML

Stateful UI con StateFlow

Validaciones avanzadas

Cumple completamente con la rúbrica del examen y representa un proyecto sólido, escalable y moderno.

👨‍💻 Desarrollado por:

Maye
Estudiante de Desarrollo de Software
