plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(BuildPlugin.Versions.compileSdkVersion)
    buildToolsVersion = BuildPlugin.Versions.buildToolsVersion

    defaultConfig {
        applicationId = "cz.koubicl.example"
        multiDexEnabled = true
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    lintOptions {
        isAbortOnError = false
    }

    sourceSets {
        getByName("main") {
            resources.includes.add("**/META-INF/font_license.html")
        }
    }

    packagingOptions {
        exclude("LICENSE-junit.txt")
        exclude("DebugProbesKt.bin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":presentation"))

    implementation(Libraries.multiDex)
    implementation(Libraries.javaxAnnotation)
    implementation(Libraries.kotlin)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.androidAnnotations)
    implementation(Libraries.navigation) {
        exclude(group = "androidx.fragment", module = "fragment")
        exclude(group = "androidx.fragment", module = "fragment-ktx")
    }
    implementation(Libraries.navigationUi)
    implementation(Libraries.fragment)
    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.ktx)
    implementation(Libraries.shimmer)
    implementation(Libraries.archRuntime)
    implementation(Libraries.archExtensions)
    implementation(Libraries.rxAndroid)
    kapt(Libraries.archCompiler)

    // Local test dependencies
    testImplementation(Libraries.kotlinJUnit)
    testImplementation(Libraries.junit)
    testImplementation(Libraries.koin)
    testImplementation(Libraries.androidTestCore)
    testImplementation(Libraries.androidTestExt)
    testImplementation(Libraries.koinTest)
    testImplementation(Libraries.roboElectric)
    testImplementation(Libraries.reflections)

    // Instrumentation test dependencies
    androidTestImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidRunner) {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation(Libraries.androidRules) {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation(Libraries.koin)
    androidTestImplementation(Libraries.koinTest)
}
