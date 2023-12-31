plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("kotlin-kapt")
  id("com.google.devtools.ksp")
}

android {
  namespace = "info.sergeikolinichenko.coinwatch"
  compileSdk = 34

  defaultConfig {
    applicationId = "info.sergeikolinichenko.coinwatch"
    minSdk = 26
    targetSdk = 34
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

val retrofitVersion = "2.9.0"
val daggerVersion = "2.48"
val lifecycleVersion = "2.6.2"

dependencies {

  implementation(project(":data"))
  implementation(project(":domain"))

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.8.1")
  implementation(platform("androidx.compose:compose-bom:2023.10.01"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  implementation ("androidx.lifecycle:lifecycle-viewmodel-compose")
  // For Anchored Draggable Modifier
//  implementation("androidx.compose.foundation:foundation:1.6.0-beta01")

  implementation("androidx.compose.runtime:runtime-livedata")

  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  // Lifecycle
  implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
  implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

  // Dagger 2
  implementation ("com.google.dagger:dagger:$daggerVersion")
  ksp ("com.google.dagger:dagger-compiler:$daggerVersion")

  // Coil
  implementation("io.coil-kt:coil-compose:2.4.0")

  // Jetpack Compose Navigating
  implementation ("androidx.navigation:navigation-compose:2.7.5")
}