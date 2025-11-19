package com.ticona.estudiantesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.ticona.estudiantesapp.data.local.Estudiante
import com.ticona.estudiantesapp.ui.EstudianteViewModel
import com.ticona.estudiantesapp.ui.screens.FormScreen
import com.ticona.estudiantesapp.ui.screens.ListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val viewModel: EstudianteViewModel = viewModel()
            val context = LocalContext.current

            var currentScreen by remember { mutableStateOf("list") }

            when (currentScreen) {

                "list" -> ListScreen(
                    viewModel = viewModel,

                    onAgregarClick = {
                        viewModel.setEstudianteEdit(null)
                        currentScreen = "form"
                    },

                    onEditarClick = { est: Estudiante ->
                        viewModel.setEstudianteEdit(est)
                        currentScreen = "form"
                    },

                    onEliminarClick = { est ->
                        viewModel.eliminarEstudiante(est) { _, msg ->
                            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                        }
                    }
                )

                "form" -> FormScreen(
                    viewModel = viewModel,
                    onVolver = { currentScreen = "list" }
                )
            }
        }
    }
}
