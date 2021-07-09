plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(BuildPlugin.Versions.compileSdkVersion)
    buildToolsVersion = BuildPlugin.Versions.buildToolsVersion

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    api(project(":common"))

    implementation(Libraries.javaxAnnotation)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.kotlin)
    implementation(Libraries.rxAndroid)
    api(Libraries.moshi)
    api(Libraries.moshiKotlin)
    api(Libraries.moshiAdapters)
    kapt(Libraries.moshiCodegen)
    implementation(Libraries.okHttp)
    implementation(Libraries.okHttpLogger)
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitConverter)
    implementation(Libraries.retrofitAdapter)
    implementation(Libraries.retrofitScalarConverter)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.kotlinJUnit)
}
