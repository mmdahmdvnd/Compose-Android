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
//
//class NavigationTest {
//    private lateinit var navController: NavController
//
//    @Before
//    fun setUp() {
//        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
//    }
//
//    @Test
//    fun testNavigationToMainScreen() {
//        composeTestRule.setContent {
//            PishcoNavigation(navController = navController)
//        }
//
//        // بررسی اینکه صفحه اصلی نمایش داده می‌شود
//        assertThat(navController.currentDestination?.route).isEqualTo("home")
//    }
//
//    @Test
//    fun testNavigationToCollectionRequestPage() {
//        composeTestRule.setContent {
//            PishcoNavigation(navController = navController)
//        }
//
//        navController.navigate(Screen.CollectionRequestPage.route)
//
//        // بررسی اینکه به صفحه CollectionRequestPage هدایت شده است
//        assertThat(navController.currentDestination?.route).isEqualTo("collectionRequest")
//    }
//}