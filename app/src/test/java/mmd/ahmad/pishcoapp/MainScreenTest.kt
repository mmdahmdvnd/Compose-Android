//package mmd.ahmad.pishcoapp
//
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.onNodeWithText
//import androidx.compose.ui.test.performClick
//import androidx.navigation.testing.TestNavHostController
//import androidx.test.core.app.ApplicationProvider
//import androidx.compose.ui.test.assertExists
//import com.google.common.truth.Truth.assertThat
//import org.junit.Rule
//import org.junit.Test
//
//class MainScreenTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testMainScreenDisplaysCorrectItems() {
//        composeTestRule.setContent {
//            MainScreen(navController = TestNavHostController(ApplicationProvider.getApplicationContext()))
//        }
//
//        // بررسی نمایش متن و المان‌های اصلی
//        composeTestRule.onNodeWithText("Collection Requests").assertExists()
//        composeTestRule.onNodeWithText("New Request").assertExists()
//    }
//
//    @Test
//    fun testNavigationToCollectionRequestPage() {
//        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//
//        composeTestRule.setContent {
//            MainScreen(navController = navController)
//        }
//
//        // شبیه‌سازی کلیک روی Collection Requests
//        composeTestRule.onNodeWithText("Collection Requests").performClick()
//
//        // بررسی اینکه مسیر به درستی تنظیم شده است
//        assertThat(navController.currentDestination?.route).isEqualTo("collectionRequestPage")
//    }
//
//    @Test
//    fun testNavigationToNewRequestPage() {
//        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//
//        composeTestRule.setContent {
//            MainScreen(navController = navController)
//        }
//
//        // شبیه‌سازی کلیک روی New Request
//        composeTestRule.onNodeWithText("New Request").performClick()
//
//        // بررسی اینکه مسیر به درستی تنظیم شده است
//        assertThat(navController.currentDestination?.route).isEqualTo("newRequestPage")
//    }
//}