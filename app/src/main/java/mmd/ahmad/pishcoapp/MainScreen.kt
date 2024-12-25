package mmd.ahmad.pishcoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import dev.shreyaspatil.permissionFlow.PermissionState
import dev.shreyaspatil.permissionflow.compose.rememberPermissionState

@Composable
fun MainScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(8.dp)
        ) {
            // ... سایر بخش‌های MainScreen
            Column(modifier = Modifier
                .height(300.dp)
                .padding(8.dp))
            {
//                GoogleMapLayout()
            }
            // سطر دوم: یک تصویر به عرض صفحه و ارتفاع نصف صفحه
            Image(
                painter = painterResource(id = R.drawable.title_image_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable {
                        navController.navigate("CollectionRequest") {
                            // مثال: تنظیم یک انیمیشن برای انتقال به صفحه جدید
                            launchSingleTop = true
                            // انجام تنظیمات دیگر از اینجا
                        }
                    },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            // سطر سوم: یک تصویر به عرض صفحه و ارتفاع یک چهارم صفحه
            Image(
                painter = painterResource(id = R.drawable.title_image_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            // سطر چهارم: یک شبکه از 9 تصویر با 3 تصویر در هر سطر
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 16.dp) // اضافه کردن فاصله از لبه‌ها
                    .align(Alignment.CenterHorizontally) // قرار دادن در وسط افقی صفحه
            ) {
                items((1..3).toList()) { index ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(3) {
                            Image(
                                painter = painterResource(id = R.drawable.title_image_1),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun GoogleMapLayout(){
//    val singapore = LatLng(1.35, 103.87)
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(singapore, 10f)
//    }
//    GoogleMap(
//        modifier = Modifier.fillMaxSize(),
//        cameraPositionState = cameraPositionState
//    )
//}


//@Preview(showBackground = true)
//@Composable
//fun  MainPreview() {
//    MainScreen()
//}