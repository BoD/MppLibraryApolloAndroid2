plugins {
    kotlin("multiplatform") version "1.5.31" apply false
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath("com.android.tools.build", "gradle", "4.1.2")
        classpath(kotlin("gradle-plugin", "1.5.31"))
    }
}


allprojects {
    group = "com.example"
    version = "1.0.0"

    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}
