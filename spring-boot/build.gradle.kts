import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//	id("org.springframework.boot") version "3.2.5"
//	id("io.spring.dependency-management") version "1.1.4"
	id("war")
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
	kotlin("plugin.allopen") version "1.9.23"
	kotlin("plugin.jpa") version "1.9.23"
	kotlin("plugin.lombok") version "1.9.23"
	kotlin("kapt") version "1.9.23"
	idea
}

group = "com.inflearn"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("jakarta.servlet:jakarta.servlet-api:6.1.0-M2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework:spring-webmvc:6.1.6")
	implementation("org.apache.tomcat.embed:tomcat-embed-core:11.0.0-M20")

	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
	implementation("io.github.microutils:kotlin-logging-jvm:4.0.0-beta-2")
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.Embeddable")
	annotation("jakarta.persistence.MappedSuperclass")
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
