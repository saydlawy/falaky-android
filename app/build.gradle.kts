plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

// Version comes from the git tag in CI (v1.2.3 -> name 1.2.3, code 1002003). The local default is only for IDE sync.
val appVersionName: String = providers.environmentVariable("FALAKY_VERSION_NAME").orElse("0.0.0-dev").get()
val appVersionCode: Int = providers.environmentVariable("FALAKY_VERSION_CODE").orElse("1").get().toInt()
val keystorePath: String? = providers.environmentVariable("FALAKY_KEYSTORE_PATH").orNull

android {
    namespace = "com.saydlawy.falaky"
    compileSdk {
        version = release(37) { minorApiLevel = 2 }
    }

    defaultConfig {
        applicationId = "com.saydlawy.falaky"
        minSdk = 24
        targetSdk = 37
        versionCode = appVersionCode
        versionName = appVersionName
    }

    signingConfigs {
        if (keystorePath != null) {
            create("release") {
                storeFile = file(keystorePath)
                storePassword = providers.environmentVariable("FALAKY_KEYSTORE_PASSWORD").get()
                keyAlias = providers.environmentVariable("FALAKY_KEY_ALIAS").get()
                keyPassword = providers.environmentVariable("FALAKY_KEY_PASSWORD").get()
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // No keystore env vars: stays unsigned (push checks only). The release workflow refuses to run without them.
            signingConfigs.findByName("release")?.let { signingConfig = it }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
    implementation(project(":feature:home"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
