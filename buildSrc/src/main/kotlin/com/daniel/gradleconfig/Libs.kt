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
    }

    object UI {
        const val constraintlayout: String = "androidx.constraintlayout:constraintlayout:" +
                Versions.constraintlayout
    }

}
