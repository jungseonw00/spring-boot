import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    kotlin("plugin.allopen") version "1.9.23"
    kotlin("plugin.lombok") version "1.9.23"
    kotlin("kapt") version "1.9.23"
    idea
}

group = "hello.memory"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.23")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.5")
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("io.github.microutils:kotlin-logging-jvm:4.0.0-beta-2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
