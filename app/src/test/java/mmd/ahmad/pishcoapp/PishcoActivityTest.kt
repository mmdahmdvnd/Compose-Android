package mmd.ahmad.pishcoapp

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import mmd.ahmad.pishcoapp.apiService.ApiServiceInterface
import mmd.ahmad.pishcoapp.model.MyResponseModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PishcoActivityTest {

    private lateinit var mockApiService: ApiServiceInterface

    @Before
    fun setup() {
        // ایجاد یک نمونه از ApiService به صورت ماک
        mockApiService = mockk()
    }

    @Test
    fun testSubmitRequest_Success() = runBlocking {
        // تعریف پاسخ مقابل با فراخوانی getData در mockApiService
        coEvery { mockApiService.getData() } returns MyResponseModel(true, "Success")

        // فراخوانی submitRequest و چک کردن نتیجه
        val result = submitRequest(mockApiService)

        // بررسی اطمینان از درستی نتیجه
        assertEquals(true, result.status)
        assertEquals("Success", result.message)
    }

    @Test
    fun testSubmitRequest_Failure() = runBlocking {
        // تعریف پاسخ مقابل با فراخوانی getData در mockApiService
        coEvery { mockApiService.getData() } throws Exception("Mocked error")

        // فراخوانی submitRequest و چک کردن نتیجه
        val result = submitRequest(mockApiService)

        // بررسی اطمینان از درستی نتیجه
        assertEquals(false, result.status)
        assertEquals("Mocked error", result.message)
    }
}