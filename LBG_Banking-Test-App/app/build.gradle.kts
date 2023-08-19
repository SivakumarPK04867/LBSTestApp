import Dependencies.androidAppCompat
import Dependencies.androidConstraintLayout
import Dependencies.androidCore
import Dependencies.androidCoreTesting
import Dependencies.androidDataBindingCompiler
import Dependencies.androidKtx
import Dependencies.androidTestEspressoCore
import Dependencies.androidTestExtJunit
import Dependencies.androidTestRules
import Dependencies.androidTestRunner
import Dependencies.androidViewModel
import Dependencies.androidViewModelKTX
import Dependencies.glide
import Dependencies.junit
import Dependencies.koinAndroidScope
import Dependencies.koinAndroidViewModel
import Dependencies.koinTest
import Dependencies.kotlinCoroutinesAndroid
import Dependencies.kotlinCoroutinesCore
import Dependencies.kotlinCoroutinesTest
import Dependencies.kotlinSerializationJSON
import Dependencies.kotlinStdLib
import Dependencies.leakCanary
import Dependencies.materialDesign
import Dependencies.mockk
import Dependencies.okHttp
import Dependencies.okHttpInterceptor
import Dependencies.okhttpMockWebServer
import Dependencies.okhttpTls
import Dependencies.retrofit
import Dependencies.retrofitGsonConverter
import Dependencies.retrofitScalarsConverter
import Dependencies.roomCompiler
import Dependencies.roomKtx
import Dependencies.roomRuntime
import Dependencies.timber

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lbg.testapp"
        minSdk = 24
        targetSdk  = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            isTestCoverageEnabled = true

            buildConfigField(
                    "String",
                    "API_URL",
                    "\"https://randomuser.me/\""
            )
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            isZipAlignEnabled = true

            proguardFile(getDefaultProguardFile("proguard-android.txt"))
            proguardFile(file("proguard-rules.pro"))

            buildConfigField(
                    "String",
                    "API_URL",
                    "\"https://randomuser.me/\""
            )
        }
    }

    dataBinding {
        isEnabled = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    //Android
    implementation(androidAppCompat)
    implementation(androidConstraintLayout)
    implementation(androidCore)
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    testImplementation(project(mapOf("path" to ":app")))
    testImplementation(project(mapOf("path" to ":app")))
    testImplementation(project(mapOf("path" to ":app")))
    kapt(androidDataBindingCompiler)
    implementation(androidViewModel)
    implementation(androidViewModelKTX)
    implementation(androidTestEspressoCore)
    implementation(androidKtx)

    implementation(okHttp)
    implementation(okHttpInterceptor)

    //Glide
    implementation(glide)

    //Room
    implementation(roomRuntime)
    kapt(roomCompiler)
    implementation(roomKtx)

    // Retrofit
    implementation(retrofit)
    implementation(retrofitGsonConverter)
    implementation(retrofitScalarsConverter)

    // Google Material Design
    implementation(materialDesign)

    // Koin
    implementation(koinAndroidScope)
    implementation(koinAndroidViewModel)

    // Kotlin
    implementation(kotlinStdLib)
    implementation(kotlinCoroutinesAndroid)
    implementation(kotlinCoroutinesCore)
    implementation(kotlinSerializationJSON)

    // Leak Canary
    debugImplementation(leakCanary)

    // Tests
    testImplementation(junit)
    testImplementation(mockk)
    testImplementation(okhttpTls)
    testImplementation(androidCoreTesting)
    testImplementation(okhttpMockWebServer)
    testImplementation(kotlinCoroutinesTest)

    androidTestImplementation(koinTest)
    androidTestImplementation(okhttpTls)
    androidTestImplementation(androidTestRules)
    androidTestImplementation(androidTestRunner)
    androidTestImplementation(androidTestExtJunit)
    androidTestImplementation(okhttpMockWebServer)

    // Timber
    implementation(timber)

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
}
