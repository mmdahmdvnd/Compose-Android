package mmd.ahmad.pishcoapp

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import mmd.ahmad.pishcoapp.import_.ApiService_
import mmd.ahmad.pishcoapp.import_.MyResponseModel_
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

// Test Class
class ApiServiceTest {

    @Test
    fun testGetDataSuccess() = runBlocking {
        // Testing successful response
        val fakeApiService = FakeApiServiceSuccess()

        val response = fakeApiService.getData()
        assertEquals(true, response.status)
        assertEquals("Success", response.message)
    }

    @Test
    fun testGetDataError() = runBlocking {
        // Testing error response
        val fakeApiService = FakeApiServiceError()

        try {
            fakeApiService.getData()
            // Fail the test if no exception is thrown
            assertTrue("Exception was expected but not thrown", false)
        } catch (e: Exception) {
            assertEquals("Server error", e.message)
        }
    }

    @Test
    fun testGetDataTimeout() = runBlocking {
        // Testing timeout scenario
        val fakeApiService = FakeApiServiceTimeout()

        try {
            withTimeout(3000) { // Timeout limit set to 3 seconds
                fakeApiService.getData()
            }
            // Fail the test if no timeout occurs
            assertTrue("Timeout exception was expected but not thrown", false)
        } catch (e: Exception) {
            // Check if the exception is a timeout or simulated timeout error
            assertTrue(
                e is kotlinx.coroutines.TimeoutCancellationException || e.message == "Request timed out"
            )
        }
    }
}


// Fake Implementation of ApiService for Testing
class FakeApiServiceSuccess : ApiService_ {
    override suspend fun getData(): MyResponseModel_ {
        return MyResponseModel_(status = true, message = "Success")
    }
}

class FakeApiServiceError : ApiService_ {
    override suspend fun getData(): MyResponseModel_ {
        throw Exception("Server error")
    }
}

class FakeApiServiceTimeout : ApiService_ {
    override suspend fun getData(): MyResponseModel_ {
        kotlinx.coroutines.delay(5000) // Simulates a long delay causing timeout
        throw Exception("Request timed out")
    }
}