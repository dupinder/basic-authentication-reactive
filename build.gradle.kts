plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.dr"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation("org.springframework.data:spring-data-r2dbc:3.1.5")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-sqlserver")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")

	implementation("io.r2dbc:r2dbc-mssql:1.0.2.RELEASE")
	implementation("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")

	implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.2.0")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	implementation("org.flywaydb:flyway-core:9.22.3")
	implementation("org.flywaydb:flyway-sqlserver:9.22.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
