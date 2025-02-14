plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}


android {
    namespace = "com.vigyat.fitnessappprototype"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vigyat.fitnessappprototype"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {


    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.work:work-runtime:2.8.1")
    implementation("com.google.android.gms:play-services-fitness:21.1.0")
    implementation("com.airbnb.android:lottie:6.1.0")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.2.2")
    implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-auth")
    //implementation ("androidx.activity:activity:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}