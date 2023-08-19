object Dependencies {
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    const val androidConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}"
    const val androidCore = "androidx.core:core:${Versions.androidCore}"
    const val androidCoreTesting = "androidx.arch.core:core-testing:${Versions.androidCoreTesting}"
    const val androidDataBindingCompiler =
        "androidx.databinding:databinding-compiler:${Versions.androidGradlePlugin}"
    const val androiGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    //const val androidLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.androidLiveData}"
    const val androidTestEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.androidTestEspressoCore}"
    const val androidTestExtJunit = "androidx.test.ext:junit:${Versions.androidTestExtJunit}"
    const val androidTestRules = "androidx.test:rules:${Versions.androidTestRules}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val androidViewModel =
        "androidx.lifecycle:lifecycle-viewmodel:${Versions.androidViewModel}"
    const val androidViewModelKTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidViewModel}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitScalarsConverter =
        "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val retrofitKotlixConverter =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitKotlinxVersion}"

    const val junit = "junit:junit:${Versions.junit}"

    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    const val koinAndroidScope = "io.insert-koin:koin-androidx-scope:${Versions.koinScope}"
    const val koinAndroidViewModel = "io.insert-koin:koin-androidx-viewmodel:${Versions.koinScope}"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinStdLib}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinStdLib}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val kotlinSerializationGradlePugin =
        "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinStdLib}"
    const val kotlinSerializationJSON =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinJSON}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"

    const val mockk = "io.mockk:mockk-android:${Versions.mockk}"

    const val okhttpTls = "com.squareup.okhttp3:okhttp-tls:${Versions.okhttp}"
    const val okhttpMockWebServer = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val androidKtx = "androidx.core:core-ktx:${Versions.androidKtxVersion}"

}

object Versions {
    internal const val androidAppCompat = "1.0.2"
    internal const val androidConstraintLayout = "1.1.3"
    internal const val androidCore = "1.0.2"
    internal const val androidGradlePlugin = "7.2.0"
    internal const val androidLiveData = "2.0.0"
    internal const val androidCoreTesting = "2.0.1"
    internal const val androidTestEspressoCore = "3.2.0"
    internal const val androidTestExtJunit = "1.1.1"
    internal const val androidTestRules = "1.2.0"
    internal const val androidTestRunner = "1.2.0"
    internal const val androidViewModel = "2.6.1"
    internal const val retrofit = "2.9.0"
    internal const val junit = "4.12"
    internal const val koin = "3.4.0"
    internal const val koinScope = "2.2.3"
    internal const val kotlinStdLib = "1.8.0"
    internal const val kotlinCoroutines = "1.6.4"
    internal const val kotlinJSON = "1.5.0"
    internal const val leakCanary = "2.10"
    internal const val materialDesign = "1.0.0"
    internal const val mockk = "1.13.5"
    internal const val okhttp = "4.9.3"
    internal const val roomVersion = "2.4.3"
    internal const val timber = "5.0.1"
    internal const val retrofitKotlinxVersion = "0.4.0"
    internal const val glideVersion = "4.5.0"
    internal const val androidKtxVersion = "0.1"
}
