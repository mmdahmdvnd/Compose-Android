import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import mmd.ahmad.pishcoapp.PishcoActivity
import mmd.ahmad.pishcoapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(PishcoActivity::class.java)

    @Test
    fun testFullNavigationFlow() {
        // بررسی اینکه صفحه اصلی نمایش داده می‌شود
        onView(withText("صفحه اصلی")).check(matches(isDisplayed()))

        // شبیه‌سازی کلیک روی دکمه "افزودن درخواست جدید"
//        onView(withId(R.id.btn_add_new_request)).perform(click())

        // بررسی اینکه صفحه "NewRequestPage" باز شده است
        onView(withText("افزودن درخواست جدید")).check(matches(isDisplayed()))

        // شبیه‌سازی کلیک روی دکمه بازگشت به صفحه اصلی
        onView(withContentDescription("بازگشت")).perform(click())

        // بررسی اینکه دوباره به صفحه اصلی بازگشتیم
        onView(withText("صفحه اصلی")).check(matches(isDisplayed()))
    }
}