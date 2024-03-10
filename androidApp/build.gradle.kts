@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

android {
    namespace = "com.gorosoft.bookme.now.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.gorosoft.bookme.now.android"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

//tasks.getByPath("preBuild").dependsOn("ktlintCheck")
//tasks.getByPath("preBuild").dependsOn("detekt")
//tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
//    exclude(".*/build/.*,.*/resources/.*")
//}

ktlint {
    android = true
    ignoreFailures = false
    verbose = true
    outputToConsole = true
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
    }

    filter {
        exclude("**/generated/**")
        exclude("**.gradle.kts")
    }
}

detekt {
    toolVersion = libs.versions.detekt.get()
    config.setFrom(file("${rootDir}/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}

dependencies {
    implementation(project(":shared"))
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.tooling)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.material)
    implementation(libs.activity.compose)
    implementation(libs.navigation)
}