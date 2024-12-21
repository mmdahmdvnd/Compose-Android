import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import mmd.ahmad.pishcoapp.PishcoNavigation
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNavigationBetweenScreens() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            PishcoNavigation(navController)
        }

        // بررسی وجود صفحه اصلی
        composeTestRule.onNodeWithText("MainScreen").assertExists()

        // شبیه‌سازی ناوبری به صفحه NewRequestPage
        composeTestRule.onNodeWithText("افزودن").performClick()
        composeTestRule.onNodeWithText("NewRequestPage").assertExists()
    }
}