package com.baldfaellig.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.baldfaellig.app.ui.screen.subscription.AddSubscriptionScreen
import com.baldfaellig.app.ui.screen.subscription.SubscriptionListScreen
import kotlinx.serialization.Serializable

@Serializable
sealed interface SubscriptionNavKey: NavKey

@Serializable
data object SubscriptionListPage: SubscriptionNavKey

@Serializable
data object AddSubscriptionPage: SubscriptionNavKey

@Composable
fun SubscriptionNavigation(modifier: Modifier = Modifier) {

    val backStack = rememberNavBackStack(SubscriptionListPage)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<SubscriptionListPage> {
                SubscriptionListScreen(
                    onClick = {
                        backStack.add(AddSubscriptionPage)
                    }
                )
            }

            entry<AddSubscriptionPage> {
                AddSubscriptionScreen(
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        },
        modifier = modifier
    )

}