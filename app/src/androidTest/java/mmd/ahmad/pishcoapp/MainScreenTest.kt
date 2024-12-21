//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.onNodeWithText
//import androidx.compose.ui.test.performClick
//import org.junit.Rule
//import org.junit.Test
//
//class MainScreenTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testNavigationToCollectionRequestPage() {
//        composeTestRule.setContent {
//            val navController = rememberNavController()
//            MainScreen(navController)
//        }
//
//        // شبیه‌سازی کلیک روی تصویر برای ناوبری به صفحه CollectionRequest
//        composeTestRule.onNodeWithText("عنوان تصویر 1").performClick()
//
//        // بررسی اینکه صفحه جدید باز شده است
//        composeTestRule.onNodeWithText("CollectionRequest").assertExists()
//    }
//}