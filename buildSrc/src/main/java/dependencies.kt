const val kotlinVersion = "1.4.10"
const val navigationVersion = "2.3.1"
const val koinVersion = "2.2.3"

object BuildPlugin {
    object Versions {
        const val compileSdkVersion = 29
        const val buildToolsVersion = "29.0.3"
    }
}

object AndroidSdk {
    const val min = 19
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val multiDexVersion = "2.0.1"
        const val javaxAnnotationVersion = "1.3.2"
        const val androidAnnotationsVersion = "1.1.0"
        const val moshiVersion = "1.9.3"
        const val rxKotlinVersion = "2.4.0"
        const val jUnitVersion = "4.13.1"
        const val archCompVersion = "2.1.0"
        const val archCompLifecycleVersion = "2.2.0"
        const val mockitoVersion = "3.5.15"
        const val mockitoInlineVersion = "2.8.47"
        const val mockitoKotlinVersion = "2.2.0"
        const val rxJavaVersion = "2.2.20"
        const val retrofitVersion = "2.9.0"
        const val okHttpVersion = "3.12.6" // last version that supports Android <= 4.4
        const val liveDataTestingVersion = "1.1.2"
        const val testCoreVersion = "1.3.0"
        const val testExtVersion = "1.1.2"
        const val roboElectricVersion = "4.4"
        const val reflections = "0.9.12"
        const val rxAndroidVersion = "2.1.1"
        const val glideVersion = "4.11.0"
        const val constraintLayoutVersion = "2.0.4"
        const val ktxVersion = "1.3.2"
        const val shimmerVersion = "0.5.0"
        const val supportLibraryVersion = "1.1.0"
        const val runnerVersion = "1.3.0"
        const val fragmentVersion = "1.3.1"
    }

    const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"
    const val javaxAnnotation = "javax.annotation:javax.annotation-api:${Versions.javaxAnnotationVersion}"
    const val androidAnnotations = "androidx.annotation:annotation:${Versions.androidAnnotationsVersion}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}"
    const val junit = "junit:junit:${Versions.jUnitVersion}"
    const val archTesting = "androidx.arch.core:core-testing:${Versions.archCompVersion}"
    const val kotlinJUnit = "org.jetbrains.kotlin:kotlin-test-junit:${kotlinVersion}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockitoVersion}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val archRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.archCompLifecycleVersion}"
    const val archExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.archCompLifecycleVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val archCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.archCompLifecycleVersion}"
    const val liveDataTesting = "com.jraska.livedata:testing-ktx:${Versions.liveDataTestingVersion}"
    const val androidTestCore = "androidx.test:core:${Versions.testCoreVersion}"
    const val androidTestExt = "androidx.test.ext:junit:${Versions.testExtVersion}"
    const val roboElectric = "org.robolectric:robolectric:${Versions.roboElectricVersion}"
    const val reflections = "org.reflections:reflections:${Versions.reflections}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val okHttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val retrofitScalarConverter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofitVersion}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${navigationVersion}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${navigationVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    const val koin = "io.insert-koin:koin-androidx-viewmodel:${koinVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktxVersion}"
    const val design = "com.android.support:design:${Versions.supportLibraryVersion}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}"
    const val koinTest = "io.insert-koin:koin-test:${koinVersion}"
    const val androidRunner = "androidx.test:runner:${Versions.runnerVersion}"
    const val androidRules = "androidx.test:rules:${Versions.runnerVersion}"
}
