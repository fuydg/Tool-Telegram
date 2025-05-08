import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("org.jetbrains.kotlin.plugin.compose")
  id("com.mikepenz.aboutlibraries.plugin")
}

android {
  namespace = "dev.trindadedev.tooltelegram"
  compileSdk = 35
    
  defaultConfig {
    applicationId = "dev.trindadedev.tooltelegram"
    minSdk = 26
    targetSdk = 35
    versionCode = 3
    versionName = "1.0.2"

    vectorDrawables.useSupportLibrary = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.15"
  }

  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }

  signingConfigs {
    getByName("debug") {
      storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
      storePassword = "testkey"
      keyAlias = "testkey"
      keyPassword = "testkey"
    }
  }
}

aboutLibraries {
  excludeFields = arrayOf("generated")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  compilerOptions {
    jvmTarget = JvmTarget.JVM_21
  }
}

dependencies {
  val aboutLibrariesVersion = "11.6.3"
  val koinVersion = "4.0.4"

  implementation("androidx.appcompat:appcompat:1.7.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.0")
  implementation("androidx.core:core-ktx:1.16.0")
  implementation("androidx.datastore:datastore-preferences:1.1.6")
  implementation("com.google.android.material:material:1.13.0-alpha13")
  implementation("androidx.core:core-splashscreen:1.0.1")

  implementation("com.squareup.okhttp3:okhttp:4.12.0")
  implementation("com.mikepenz:aboutlibraries-core:$aboutLibrariesVersion")

  implementation("io.insert-koin:koin-android:$koinVersion")
  implementation("io.insert-koin:koin-androidx-compose:$koinVersion")

  implementation(platform("androidx.compose:compose-bom:2025.05.00"))
  implementation("androidx.compose.material3:material3")
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")

  implementation("androidx.activity:activity-compose:1.10.1")
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
  implementation("androidx.navigation:navigation-compose:2.8.9")
  implementation("io.github.fornewid:material-motion-compose-core:2.0.1")

  implementation("com.mikepenz:aboutlibraries-compose:$aboutLibrariesVersion")
  implementation("com.mikepenz:aboutlibraries-compose-m3:$aboutLibrariesVersion")
}