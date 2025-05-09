pluginManagement {
    plugins {
        kotlin("jvm") version "1.9.23"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "handson-java"

// Java
include("java-lang:convert-string-xml-to-document-node")
include("java-lang:custom-annotation")
include("java-lang:try-with-resources")

// kotlin
include("kotlin-lang:android-training")

// spring
include("spring:using-mockmvc-vs-webmvctest")
include("spring:spring-boot-configure-multiple-datasources")
include("spring:spring-boot-security")
include("spring:spring-data-jpa")
include("spring:spring-data-jdbc")
include("spring:spring-thymeleaf-sample")
