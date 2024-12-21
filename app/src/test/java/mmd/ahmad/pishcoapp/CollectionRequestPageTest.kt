//package mmd.ahmad.pishcoapp
//
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.navigation.NavController
//import androidx.test.core.app.ApplicationProvider
//import androidx.compose.ui.test.onNodeWithContentDescription
//
//class CollectionRequestPageTest {
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testRequestListDisplayed() {
//        val mockRequests = listOf("درخواست 1", "درخواست 2")
//
//        composeTestRule.setContent {
//            CollectionRequestPage(
//                navController = TestNavHostController(ApplicationProvider.getApplicationContext()),
//                requests = mockRequests
//            )
//        }
//
//        mockRequests.forEach { request ->
//            composeTestRule.onNodeWithText(request).assertExists()
//        }
//    }
//
//    @Test
//    fun testAddNewRequestNavigation() {
//        composeTestRule.setContent {
//            CollectionRequestPage(
//                navController = TestNavHostController(ApplicationProvider.getApplicationContext()),
//                requests = mutableListOf()
//            )
//        }
//
//        composeTestRule.onNodeWithContentDescription("افزودن").performClick()
//
//        // بررسی اینکه به صفحه newRequestPage هدایت شده است
//        assertThat(navController.currentDestination?.route).isEqualTo("newRequestPage")
//    }
//}