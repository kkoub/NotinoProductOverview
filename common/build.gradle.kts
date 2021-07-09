plugins {
    id("com.android.library")
    kotlin("android")
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
    implementation(Libraries.kotlin)
    implementation(Libraries.javaxAnnotation)
    implementation(Libraries.androidAnnotations)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxJava)
    implementation(Libraries.rxAndroid)

    api(Libraries.koin)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.kotlinJUnit)
    testImplementation(Libraries.koinTest)
    testImplementation(Libraries.mockito)
    testImplementation(Libraries.mockitoKotlin)
}
