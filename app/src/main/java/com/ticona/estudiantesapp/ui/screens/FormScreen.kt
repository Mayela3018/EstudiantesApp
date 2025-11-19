package com.ticona.estudiantesapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ticona.estudiantesapp.ui.EstudianteViewModel
import com.ticona.estudiantesapp.ui.components.SimpleInputField
import com.ticona.estudiantesapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    viewModel: EstudianteViewModel,
    onVolver: () -> Unit
) {
    val context = LocalContext.current
    val estudianteEdit by viewModel.estudianteEdit.collectAsState()

    var apellido by remember { mutableStateOf(estudianteEdit?.apellido ?: "") }
    var nombre by remember { mutableStateOf(estudianteEdit?.nombre ?: "") }
    var dni by remember { mutableStateOf(estudianteEdit?.dni ?: "") }
    var carrera by remember { mutableStateOf(estudianteEdit?.carrera ?: "") }
    var promedio by remember { mutableStateOf(estudianteEdit?.promedio?.toString() ?: "") }
    var fechaIngreso by remember { mutableStateOf(estudianteEdit?.fechaIngreso ?: "") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        if (estudianteEdit == null) "Nuevo Estudiante" else "Editar Estudiante",
                        color = PastelPurpleText
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PastelPink
                )
            )
        },
        containerColor = PastelPink
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            @Composable
            fun pastelField(label: String, value: String, onChange: (String) -> Unit) {
                OutlinedTextField(
                    value = value,
                    onValueChange = onChange,
                    label = { Text(label) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PastelPurpleText,
                        cursorColor = PastelPurpleText
                    )
                )
                Spacer(Modifier.height(12.dp))
            }

            pastelField("Apellido", apellido) { apellido = it }
            pastelField("Nombre", nombre) { nombre = it }
            pastelField("DNI (8 dígitos)", dni) { dni = it }
            pastelField("Carrera", carrera) { carrera = it }
            pastelField("Promedio (0-20)", promedio) { promedio = it }
            pastelField("Fecha Ingreso", fechaIngreso) { fechaIngreso = it }

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = {
                    viewModel.guardarEstudiante(
                        idEstudiante = estudianteEdit?.idEstudiante,
                        apellido = apellido,
                        nombre = nombre,
                        dni = dni,
                        carrera = carrera,
                        promedio = promedio,
                        fechaIngreso = fechaIngreso
                    ) { ok, msg ->
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                        if (ok) onVolver()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PastelCeleste,
                    contentColor = PastelPurpleText
                )
            ) {
                Text("Guardar")
            }
        }
    }
}
