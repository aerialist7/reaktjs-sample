plugins {
    kotlin("js") version "1.4.21"
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation("org.jetbrains:kotlin-react:17.0.1-pre.136-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-dom:17.0.1-pre.136-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-react-table:7.6.2-pre.136-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.136-kotlin-1.4.10")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation(npm("react-player", "~2.8.1"))
    implementation(npm("react-share", "~4.3.1"))
}

kotlin.js {
    browser {
        binaries.executable()
    }
}
