import org.jooq.meta.jaxb.Logging

plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.flywaydb.flyway") version "10.7.1"
	id("org.jooq.jooq-codegen-gradle") version "3.19.7"
}

group = "ru.ccfit.golubevm"
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

buildscript {
	dependencies {
		classpath("org.postgresql:postgresql:42.6.2")
		classpath("org.flywaydb:flyway-database-postgresql:10.7.1")
	}
}

flyway {
	url = "jdbc:postgresql://localhost:5432/practice"
	user = "xisepe"
	password = "admin"
	schemas = arrayOf("public")
	cleanDisabled = false
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.flywaydb:flyway-core:10.7.1")
	implementation("org.flywaydb:flyway-database-postgresql:10.7.1")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")

	//swagger
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	// https://mvnrepository.com/artifact/org.mapstruct/mapstruct
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	// https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
	// https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct-binding
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.withType<JavaCompile> {
	options.encoding="UTF-8"
}
jooq {
	version = dependencyManagement.importedProperties["jooq.version"]!!
	configuration {
		logging = Logging.ERROR
		jdbc {
			driver = "org.postgresql.Driver"
			url = "jdbc:postgresql://localhost:5432/practice"
			user = "xisepe"
			password = "admin"
		}
		generator {
			generate {
				isJooqVersionReference = false
			}
			database {
				name = "org.jooq.meta.postgres.PostgresDatabase"
				inputSchema = "public"
				includes = ".*"
				excludes = ""
			}
			target {
				directory = "src/main/java/generated/jooq"
				packageName = "ru.ccfit.golubevm"
			}
		}
	}
}