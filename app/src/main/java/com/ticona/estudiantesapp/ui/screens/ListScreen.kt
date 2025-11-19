package com.ticona.estudiantesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import com.ticona.estudiantesapp.data.local.Estudiante
import com.ticona.estudiantesapp.ui.EstudianteViewModel
import com.ticona.estudiantesapp.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    viewModel: EstudianteViewModel,
    onAgregarClick: () -> Unit,
    onEditarClick: (Estudiante) -> Unit,
    onEliminarClick: (Estudiante) -> Unit
) {
    val estudiantes by viewModel.estudiantes.collectAsState()
    val search by viewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Estudiantes",
                        style = MaterialTheme.typography.headlineSmall,
                        color = PastelPurpleText
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PastelPink
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAgregarClick,
                containerColor = PastelCeleste
            ) {
                Text("+", color = PastelPurpleText)
            }
        },
        containerColor = PastelPink
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                value = search,
                onValueChange = { viewModel.setSearchQuery(it) },
                label = { Text("Buscar por nombre o carrera") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PastelPurpleText,
                    cursorColor = PastelPurpleText
                )
            )

            Spacer(Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(estudiantes) { est ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(4.dp, RoundedCornerShape(20.dp))
                            .clickable { onEditarClick(est) },
                        colors = CardDefaults.cardColors(containerColor = PastelCard),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {
                            Text(
                                "${est.apellido}, ${est.nombre}",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = PastelPurpleText
                                )
                            )
                            Spacer(Modifier.height(4.dp))
                            Text("DNI: ${est.dni}", color = SoftGray)
                            Text("Carrera: ${est.carrera}", color = SoftGray)
                            Text("Promedio: ${est.promedio}", color = SoftGray)
                            Text("Ingreso: ${est.fechaIngreso}", color = SoftGray)

                            Spacer(Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                TextButton(onClick = { onEditarClick(est) }) {
                                    Text("Editar", color = PastelPinkText)
                                }
                                TextButton(onClick = { onEliminarClick(est) }) {
                                    Text("Eliminar", color = PastelPinkText)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
