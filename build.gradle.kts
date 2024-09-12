plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "ru.Translator"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")


    // JSON
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Oracle
    implementation("com.oracle.database.jdbc:ojdbc8-production") {
        exclude(group = "com.oracle.database.xml", module = "xmlparserv2")
        exclude(group = "com.oracle.database.ha", module = "ons")
        exclude(group = "com.oracle.database.ha", module = "simplefan")
    }

    // Liquibase
    implementation("org.liquibase:liquibase-core")

    // Logging
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("net.logstash.logback:logstash-logback-encoder:7.4")

    // Monitoring
    implementation("io.micrometer:micrometer-registry-prometheus:1.12.2")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // Utils
    implementation("org.jsoup:jsoup:1.17.2")

    //Test
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("com.h2database:h2")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
