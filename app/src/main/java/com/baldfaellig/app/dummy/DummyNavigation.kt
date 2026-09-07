package com.baldfaellig.app.dummy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

@Serializable
sealed interface DummyNavKey : NavKey

@Serializable
data object DummyFirstPage : DummyNavKey

@Serializable
data object DummySecondPage: DummyNavKey

@Composable
fun DummyNavigation(db: DummyDatabase) {

    val backStack = rememberNavBackStack(DummyFirstPage)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<DummyFirstPage> {
                DummyFirstScreen(
                    onClick = {
                        backStack.add(DummySecondPage)
                    }
                )
            }

            entry<DummySecondPage> {
                DummySecondScreen(
                    db = db,
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}

@Composable
fun DummyFirstScreen(
    viewModel: DummyViewModel = viewModel(),
    onClick: () -> Unit
    ) {
    val count by viewModel.counter.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.increment() }) {
            Text("Clicked $count times")
        }
        Button(
            onClick = onClick
        ) {
            Text("next page")
        }
    }
}

@Composable
fun DummySecondScreen(
    db: DummyDatabase,
    onBack: () -> Unit
) {

    val viewModel: DummySecondViewModel = viewModel(factory = DummySecondViewModelFactory(db))
    val name by viewModel.name.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadName()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Your name is: ${name?: "still getting info from db..."}")
        Button(
            onClick = onBack
        ) {
            Text("back")
        }
    }
}