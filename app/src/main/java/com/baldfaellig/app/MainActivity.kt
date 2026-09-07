package com.baldfaellig.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.room3.Room
import com.baldfaellig.app.dummy.DummyDatabase
import com.baldfaellig.app.dummy.DummyItem
import com.baldfaellig.app.navigation.SubscriptionNavigation
import com.baldfaellig.app.ui.theme.BaldFälligTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    // TODO delete dummy database
    private lateinit var db: DummyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            DummyDatabase::class.java,
            "dummy-db"
        ).build()

        lifecycleScope.launch {
            val dummyItem = DummyItem(uid = 1, name = "test")
            db.dummyDao().insertAll(dummyItem)

            val allItems = db.dummyDao().getAll()
            Log.d("DummyDatabase", "Items in DB: $allItems")
        }

        enableEdgeToEdge()
        setContent {
            BaldFälligTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SubscriptionNavigation(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaldFälligTheme {
    }
}