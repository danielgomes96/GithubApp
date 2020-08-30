package com.daniel.gradleconfig

object Libs {

    object Plugins {
        /**
         * https://github.com/pinterest/ktlint
         */
        const val ktlint: String = "com.pinterest:ktlint:" + Versions.ktlint
    }

    object Core {
        const val kotlin_stdlib_jdk8: String =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" + Versions.kotlin

        /**
         * https://developer.android.com/jetpack/androidx
         */
        const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.appcompat

        /**
          * http://developer.android.com/tools/extras/support-library.html
          */
        const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

        const val kotlinx_coroutines_android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.kotlinx_coroutines

        const val kotlinx_coroutines_core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:" +
                    Versions.kotlinx_coroutines
    }

    object DI {
        /**
         * https://github.com/InsertKoinIO/koin
         */
        const val koin_android: String = "org.koin:koin-android:" + Versions.koin

        const val koin_androidx_viewmodel: String =
            "org.koin:koin-androidx-viewmodel:" + Versions.koin
    }

    object Data {
        /**
         * https://github.com/square/retrofit/
         */
        const val retrofit: String = "com.squareup.retrofit2:retrofit:" + Versions.retrofit

        const val converter_gson: String = "com.squareup.retrofit2:converter-gson:" +
                Versions.converter_gson

        const val okhttp: String = "com.squareup.okhttp3:okhttp:" + Versions.okhttp

        const val logging_interceptor: String = "com.squareup.okhttp3:logging-interceptor:" +
                Versions.okhttp
    }

    object UI {
        const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
                Versions.constraintlayout
    }
}
