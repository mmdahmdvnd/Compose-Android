package mmd.ahmad.pishcoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mmd.ahmad.pishcoapp.apiService.ApiServiceInterface
import mmd.ahmad.pishcoapp.model.MyResponseModel

class ApiServiceViewModel : ViewModel() {

    // به عنوان مثال، یک LiveData یا MutableState را نیز می‌توانید در اینجا تعریف کنید

    fun submitRequest(apiService: ApiServiceInterface, onSuccess: (MyResponseModel) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response: MyResponseModel = apiService.getData()
                onSuccess(response)
            } catch (e: Exception) {
                // مدیریت خطاها
                onError("Error: ${e.message}")
            }
        }
    }
}