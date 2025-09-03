plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "app.oye.weds"
    compileSdk = 35

    defaultConfig {
        applicationId = "app.oye.weds"
        minSdk = 27
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Chart
    implementation("io.github.bytebeats:compose-charts:0.2.1")


    // Core Supabase client
    implementation("io.github.jan-tennert.supabase:supabase-kt:2.4.0")

// Auth
    implementation("io.github.jan-tennert.supabase:auth-kt:3.2.2")


// Postgres REST API
    implementation("io.github.jan-tennert.supabase:postgrest-kt:2.4.0")

// Realtime (live updates, presence, subscriptions)
    implementation("io.github.jan-tennert.supabase:realtime-kt:2.4.0")

// Storage (file uploads / downloads)
    implementation("io.github.jan-tennert.supabase:storage-kt:2.4.0")


    //Coil
    implementation("io.coil-kt:coil-compose:2.5.0")

    //SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Material Theme
    implementation("androidx.compose.material3:material3:1.3.2")


    // Optional: Hilt Navigation Compose or ViewModel support
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")


    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.8.0")

    // Koin Core
    implementation("io.insert-koin:koin-core:4.1.0")

// Koin Android
    implementation("io.insert-koin:koin-android:4.1.0")

// Koin for Jetpack Compose (use this instead of viewmodel)
    implementation("io.insert-koin:koin-androidx-compose:4.1.0")
    

// Ktor
    implementation("io.ktor:ktor-client-core:3.2.3")

    // Ktor client for Android
    implementation("io.ktor:ktor-client-okhttp:3.2.3")

    // Ktor client serialization (Kotlinx)
    implementation("io.ktor:ktor-client-content-negotiation:3.2.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.3")

    // Logging (optional)
    implementation("io.ktor:ktor-client-logging:2.3.4")



    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")

    // ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")


    implementation("androidx.core:core:1.15.0")

    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}