plugins {
    kotlin("jvm") version "1.8.0"
}

allprojects {
    group = "no.fortedigital"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
    apply(plugin = "org.jetbrains.kotlin.jvm")

    kotlin {
        jvmToolchain(17)
    }
}

