plugins {
    alias(libs.plugins.android.library)

}

android {
    namespace = "com.saydlawy.falaky.core.model"
    compileSdk {
        version = release(37) { minorApiLevel = 2 }
    }
    defaultConfig { minSdk = 24 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    testImplementation(libs.junit)
}
