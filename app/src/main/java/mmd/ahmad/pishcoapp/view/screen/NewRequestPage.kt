package mmd.ahmad.pishcoapp.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mmd.ahmad.pishcoapp.Screen
import mmd.ahmad.pishcoapp.apiService.ApiService
import mmd.ahmad.pishcoapp.viewModel.ApiServiceViewModel
import mmd.ahmad.pishcoapp.viewModel.MainViewModel

@Composable
fun NewRequestPage(navController: NavController, viewModel: MainViewModel) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    val apiServiceViewModel: ApiServiceViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("نام و نام خانوادگی") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        TextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("شماره تلفن") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("آدرس") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick = {
                apiServiceViewModel.submitRequest(
                    apiService = ApiService.apiService,
                    onSuccess = { response ->
                        // پردازش نتیجه
                    },
                    onError = { errorMessage ->
                        // مدیریت خطا
                    }
                )
                viewModel.addRequest("درخواست جدید")
                navController.navigate(Screen.CollectionRequestPage.route) {
                    // تنظیم popUpTo برای بازگشت به CollectionRequestPage
                    launchSingleTop = true
                    restoreState = true
                    popUpTo(Screen.CollectionRequestPage.route) {
                        saveState = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "ثبت درخواست")
        }
    }
}




