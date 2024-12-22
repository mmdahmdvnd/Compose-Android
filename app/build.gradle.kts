plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "mmd.ahmad.pishcoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "mmd.ahmad.pishcoapp"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
//        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
//    java {
//        sourceSets {
//            named("main") {
//                java.srcDirs("src/main/java")
//            }
//            named("test") {
//                java.srcDirs("src/test/java")
//                resources.srcDirs("src/test/resources")
//            }
//        }
//    }
}


dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))

    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
    implementation("androidx.navigation:navigation-compose:2.7.5")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("com.google.maps.android:maps-compose:4.2.0")
    // Optionally, you can include the Compose utils library for Clustering,
    // Street View metadata checks, etc.
    implementation ("com.google.maps.android:maps-compose-utils:4.2.0")
    // Optionally, you can include the widgets library for ScaleBar, etc.
    implementation ("com.google.maps.android:maps-compose-widgets:4.2.0")
//    implementation ("com.google.maps.android:maps-compose:4.1.1")
    implementation ("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")

//    implementation ("com.google.accompanist:accompanist-maps:0.19.0")

    // Handling Permission scenario
    implementation("dev.shreyaspatil.permission-flow:permission-flow-compose:1.2.0")
    // libs for fetching user current location and handling this Task API
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.0")



    //Test
    testImplementation(project(":app")) // یا ماژول مربوطه
    implementation("androidx.test:core-ktx:1.6.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.compose.ui:ui-test-junit4-android:1.5.1")
    testImplementation("androidx.compose.ui:ui-test-android:1.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.5.1")
    androidTestImplementation ("androidx.navigation:navigation-testing:2.7.2")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.2")
    androidTestImplementation ("org.mockito:mockito-core:5.6.0")
//    testImplementation ("org.mockito:mockito-inline:5.6.0") // برای موک کردن final کلاس‌ها
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3") // تست برای coroutines

//    testImplementation (project(":mainModule"))
    }

