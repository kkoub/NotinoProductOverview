plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(BuildPlugin.Versions.compileSdkVersion)
    buildToolsVersion = BuildPlugin.Versions.buildToolsVersion

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        multiDexEnabled = true
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    dexOptions {
        preDexLibraries = false
        dexInProcess = false
        javaMaxHeapSize = "4g"
    }

    lintOptions {
        isQuiet = true
        isAbortOnError = false
        isIgnoreWarnings = true
        disable("InvalidPackage")            //Some libraries have issues with this.
        disable("OldTargetApi")              //Lint gives this warning but SDK 20 would be Android L Beta.
        disable("IconDensities")             //For testing purpose. This is safe to remove.
        disable("IconMissingDensityFolder")  //For testing purpose. This is safe to remove.
    }
}

kapt {
    correctErrorTypes = true
    generateStubs = true
}

dependencies {
    api(project(":domain"))
    api(project(":common"))


    implementation(Libraries.kotlin)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)
    implementation(Libraries.archRuntime)
    implementation(Libraries.archExtensions)
    implementation(Libraries.retrofit)
    implementation(Libraries.okHttp)
    kapt(Libraries.archCompiler)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.kotlinJUnit)
    testImplementation(Libraries.mockito)
    testImplementation(Libraries.mockitoInline)
    testImplementation(Libraries.mockitoKotlin)
    testImplementation(Libraries.archTesting)
    testImplementation(Libraries.liveDataTesting)
    testImplementation(Libraries.roboElectric)
    testImplementation(Libraries.reflections)
    testImplementation(Libraries.androidTestCore)
    testImplementation(Libraries.androidTestExt)
    testImplementation(Libraries.koinTest)
}
