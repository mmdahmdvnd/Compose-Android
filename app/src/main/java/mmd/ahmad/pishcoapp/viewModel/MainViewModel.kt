package mmd.ahmad.pishcoapp.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mmd.ahmad.pishcoapp.apiService.ApiServiceInterface

class MainViewModel : ViewModel() {
//    private val _requests = mutableStateListOf("درخواست 1", "درخواست 2", "درخواست 3")
//    val requests: List<String> get() = _requests.toList()

//    private val _requests = MutableLiveData<List<String>>()
//    val requests: LiveData<List<String>> get() = _requests
private var _requests = mutableStateListOf<String>("درخواست 1", "درخواست 2", "درخواست 3")
    val requests: List<String> get() = _requests

    fun addRequest(request: String) {
        _requests.add(request)
    }

    fun updateRequests(newRequests: List<String>) {
        _requests = newRequests as SnapshotStateList<String>
    }
    fun fetchData(apiService: ApiServiceInterface) {
        viewModelScope.launch {
            try {
                val response = apiService.getData()
                // انجام هر عملیات مرتبط با درخواست اینجا
            } catch (e: Exception) {
                // مدیریت خطا
            }
        }
    }
}