package mmd.ahmad.pishcoapp.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import mmd.ahmad.pishcoapp.Screen
import mmd.ahmad.pishcoapp.viewModel.MainViewModel

@Composable
fun CollectionRequestPage(navController: NavController, viewModel: MainViewModel) {
//    val requests = viewModel.requests.value ?: emptyList()
    val requests = viewModel.requests

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            // نمایش لیست درخواست‌ها
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp)
            ) {
                items(requests) { request ->
                    Text(text = request, modifier = Modifier.padding(8.dp))
                }
            }

            // افزودن فلاتین اکشن باتن
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.NewRequestPage.route) {
                        // ارسال لیست به صفحه جدید
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(Screen.CollectionRequestPage.route) {
                            saveState = true
                        }
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "افزودن")
            }
        }
    }
}