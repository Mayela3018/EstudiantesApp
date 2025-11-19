🌟 EstudiantesApp – CRUD con Room + Jetpack Compose

Aplicación móvil desarrollada en Android Studio, utilizando Kotlin, Jetpack Compose y Room.
Permite gestionar estudiantes mediante un CRUD completo: crear, leer, actualizar y eliminar, con validaciones y una interfaz moderna pastel.

Proyecto realizado como parte del Examen Práctico – Programación Móvil (TECSUP).

✨ Características Principales

✔ CRUD completo (Crear, Leer, Actualizar, Eliminar)
✔ Persistencia local con Room
✔ Diseño pastel elegante (rosa, lila y celeste)
✔ Interfaz moderna 100% Jetpack Compose (sin XML)
✔ Búsqueda en tiempo real por nombre o carrera
✔ Validación de DNI único (8 dígitos exactos)
✔ Validación de promedio 0–20
✔ Manejo de estado con ViewModel + StateFlow
✔ Arquitectura limpia: DAO + Repository + ViewModel
✔ Navegación simple entre pantallas
✔ Mensajes de error y confirmación con Toast

🧮 Modelo de Datos – Estudiante
La tabla Estudiantes contiene los siguientes campos:
| Campo        | Tipo   | Descripción                                  |
| ------------ | ------ | -------------------------------------------- |
| idEstudiante | Int    | Auto-generado (Primary Key)                  |
| apellido     | String | Apellido del estudiante                      |
| nombre       | String | Nombre del estudiante                        |
| dni          | String | DNI **único** de 8 dígitos                   |
| carrera      | String | Carrera profesional                          |
| promedio     | Double | Promedio validado (0 – 20)                   |
| fechaIngreso | String | Fecha de ingreso (dd/MM/yyyy o texto simple) |

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

🟣 Kotlin
🌸 Jetpack Compose (UI moderna)
🏛 Room (base de datos local)
🔄 Coroutines + StateFlow
🎯 ViewModel – Arquitectura MVVM
🎨 Material Design 3

⚙️ Instalación y Ejecución
1️⃣ Clonar el repositorio
git clone https://github.com/usuario/EstudiantesApp.git
2️⃣ Abrir en Android Studio
File → Open → Selecciona el proyecto
3️⃣ Verificar dependencias
Incluye:
Room
ViewModel
Lifecycle
Coroutines
Compose BOM
Material3
(Todo ya listo en build.gradle.kts)
4️⃣ Ejecutar la app
Selecciona un emulador o dispositivo
Haz clic en Run ▶

🧪 Validaciones Implementadas

✔ DNI con 8 dígitos
✔ No permite DNI duplicados
✔ Promedio válido entre 0 y 20
✔ Campos obligatorios
✔ Toast de éxito/error
✔ Modo editar y modo registrar


💡 Conclusión
Este proyecto demuestra el uso correcto de:
Room + DAO
MVVM con ViewModel
Jetpack Compose
Navegación simple sin XML
Persistencia local
Manejo de estados reactivos (StateFlow)
Validaciones avanzadas en formularios

👨‍💻 Desarrollado por
✨ Maye
2025 💚✨
