//package mmd.ahmad.pishcoapp
//
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.navigation.NavController
//import androidx.navigation.testing.TestNavHostController
//import androidx.test.core.app.ApplicationProvider
//import com.google.common.truth.Truth.assertThat
//import com.example.projectname.NewRequestPage // مسیر فایل مربوط به صفحه NewRequestPage را تغییر دهید
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.performClick
//import androidx.compose.ui.test.performTextInput
//import androidx.compose.ui.test.onNodeWithText
//
//class NewRequestPageTest {
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testSubmitRequestButton() {
//        composeTestRule.setContent {
//            NewRequestPage(
//                navController = TestNavHostController(ApplicationProvider.getApplicationContext()),
//                requests = mutableListOf()
//            )
//        }
//
//        composeTestRule.onNodeWithText("نام و نام خانوادگی").performTextInput("احمد")
//        composeTestRule.onNodeWithText("شماره تلفن").performTextInput("09123456789")
//        composeTestRule.onNodeWithText("آدرس").performTextInput("تهران، ایران")
//        composeTestRule.onNodeWithText("ثبت درخواست").performClick()
//
//        // بررسی وضعیت لیست یا مسیریابی
//        composeTestRule.onNodeWithText("درخواست جدید").assertExists()
//    }
//}