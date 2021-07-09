plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")

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
        jvmTarget = "1.8"
    }
}


dependencies {
    implementation(project(":remote"))

    implementation(Libraries.javaxAnnotation)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxJava)

    testImplementation(Libraries.junit)
    testImplementation(Libraries.kotlinJUnit)
    testImplementation(Libraries.mockito)
    testImplementation(Libraries.mockitoKotlin)
    testImplementation(Libraries.archTesting)
    testImplementation(Libraries.liveDataTesting)
    testImplementation(Libraries.roboElectric)
    testImplementation(Libraries.reflections)
    testImplementation(Libraries.androidTestCore)
    testImplementation(Libraries.androidTestExt)
    testImplementation(Libraries.koinTest)
}
