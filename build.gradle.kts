// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
}

buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        maven { url = uri("https://jitpack.io") }
        mavenCentral()
        jcenter()
        jcenter {
            content {
                includeGroup("org.jetbrains.kotlinx")
            }
        }
        flatDir {
            dirs("libs")
        }
    }
}
