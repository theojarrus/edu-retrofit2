plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.retrofitapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofitapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Converter: for paring json
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    // Adapter: for mapping call to RxJava
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.11.0")
    // Logging Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    // RxJava
    implementation("io.reactivex.rxjava3:rxjava:3.0.2")
    // RxAndroid for AndroidSchedulers.mainThread()
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
}
