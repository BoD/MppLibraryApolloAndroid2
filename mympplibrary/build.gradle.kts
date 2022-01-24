plugins {
    kotlin("multiplatform")
    id("com.apollographql.apollo") version "2.5.11"
}

kotlin {
    iosX64("ios") {
        binaries {
            framework {
                baseName = "MyMppLibrary"
                export(project(":utils"))
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // See https://www.apollographql.com/docs/kotlin/v2/essentials/get-started-multiplatform/
                implementation("com.apollographql.apollo:apollo-runtime-kotlin:2.5.11")
                api(project(":utils"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

// See https://www.apollographql.com/docs/kotlin/v2/advanced/multi-modules/
dependencies {
    apolloMetadata(project(":utils"))
}

apollo {
    rootPackageName.set("com.example.mympplibrary")
}
