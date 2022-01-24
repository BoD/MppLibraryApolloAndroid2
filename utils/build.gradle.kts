plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.apollographql.apollo") version "2.5.11"
}

kotlin {
    android()
    iosX64("ios")

    sourceSets {
        val commonMain by getting {
            dependencies {
                // See https://www.apollographql.com/docs/kotlin/v2/essentials/get-started-multiplatform/
                implementation("com.apollographql.apollo:apollo-runtime-kotlin:2.5.11")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13")
            }
        }
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

apollo {
    rootPackageName.set("com.example.utils")
    generateKotlinModels.set(true)
    generateApolloMetadata.set(true)
}
