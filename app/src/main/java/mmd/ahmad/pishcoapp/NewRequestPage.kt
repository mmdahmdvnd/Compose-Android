package mmd.ahmad.pishcoapp

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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun NewRequestPage(
    navController: NavController,
//   onBack: () -> Unit,
   requests: MutableList<String>
) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

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
                runBlocking {
                    try {
                        submitRequest()
                        requests.add("درخواست جدید")
                        navController.navigate(Screen.CollectionRequestPage.route) {
                            // تنظیم popUpTo برای بازگشت به CollectionRequestPage
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(Screen.CollectionRequestPage.route) {
                                saveState = true
                            }
                        }
                    } catch (e: Exception) {
                        // مدیریت خطاها
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

suspend fun submitRequest(){
    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-url-address/test/") // آدرس پایه سرویس وب
        .addConverterFactory(GsonConverterFactory.create()) // مبدل داده به و از JSON
        .build()

    val apiService = retrofit.create(ApiService::class.java)

    try {
        val response : MyResponseModel = apiService.getData()
        if(response.status){
            println("response ok")
        }else{
            println("ارتباط با سرور برقرار نشد")
        }

    } catch (e: Exception) {
        // خطای ارتباط با سرور یا خطا در پارس کردن پاسخ
    }
}