//package mmd.ahmad.pishcoapp
//
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import io.reactivex.Single
//import org.mockito.Mockito.*
//import org.mockito.ArgumentMatchers.anyString
//import org.mockito.Mock
//import org.mockito.MockitoAnnotations
//import com.example.app.viewmodel.UserViewModel
//import com.example.app.repository.UserRepository
//import com.example.app.models.MyResponseModel
//
//class SubmitRequestTest {
//
//    private lateinit var mockRepository: UserRepository
//    private lateinit var viewModel: UserViewModel
//
//    @Before
//    fun setUp() {
//        mockRepository = mock(UserRepository::class.java)
//        viewModel = UserViewModel(mockRepository)
//    }
//
//    @Test
//    fun testSubmitRequestSuccess() {
//        // شبیه‌سازی پاسخ موفق از Repository
//        `when`(mockRepository.submitRequest(anyString(), anyString(), anyString()))
//            .thenReturn(Single.just(MyResponseModel(true, "Success")))
//
//        // فراخوانی تابع
//        viewModel.submitRequest("احمد", "09123456789", "تهران، ایران")
//
//        // بررسی اینکه وضعیت به Success تغییر کرده است
//        viewModel.responseState.observeForever { state ->
//            assert(state is UserViewModel.State.Success)
//            assertEquals("Success", (state as UserViewModel.State.Success).message)
//        }
//    }
//
//    @Test
//    fun testSubmitRequestFailure() {
//        // شبیه‌سازی پاسخ ناموفق از Repository
//        `when`(mockRepository.submitRequest(anyString(), anyString(), anyString()))
//            .thenReturn(Single.error(Throwable("Network Error")))
//
//        // فراخوانی تابع
//        viewModel.submitRequest("احمد", "09123456789", "تهران، ایران")
//
//        // بررسی اینکه وضعیت به Error تغییر کرده است
//        viewModel.responseState.observeForever { state ->
//            assert(state is UserViewModel.State.Error)
//            assertEquals("Network Error", (state as UserViewModel.State.Error).errorMessage)
//        }
//    }
//
//    @Test
//    fun testSubmitRequestInvalidInput() {
//        // فراخوانی تابع با ورودی نامعتبر
//        viewModel.submitRequest("", "09123456789", "")
//
//        // بررسی اینکه وضعیت به Error تغییر کرده است
//        viewModel.responseState.observeForever { state ->
//            assert(state is UserViewModel.State.Error)
//            assertEquals("Invalid input", (state as UserViewModel.State.Error).errorMessage)
//        }
//    }
//}