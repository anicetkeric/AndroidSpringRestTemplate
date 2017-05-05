# AndroidSpringRestTemplate
Calling REST service with Spring RestTemplate for Android


## Overview
The Spring for Android project supports the usage of the Spring Framework in an Android environment. This includes the ability to use RestTemplate as the REST client for your Android applications. Spring for Android also provides support for integrating Spring Social functionality into your Android application, which includes a robust OAuth based, authorization client and implementations for popular social web sites, such as Twitter and Facebook.[Read more](http://docs.spring.io/spring-android/docs/1.0.x/reference/html/overview.html).


This example, we will use the service rest  online [JSONPlaceholder](https://jsonplaceholder.typicode.com/). 

## Add dependencies in gradle file

```java
apply plugin: 'android'

android {
    compileSdkVersion 19
    buildToolsVersion "19.0.3"

    defaultConfig {
        minSdkVersion 8
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            runProguard false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }
    packagingOptions {
        exclude 'META-INF/ASL2.0'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/notice.txt'
    }
}

dependencies {
    compile 'com.android.support:appcompat-v7:+'
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'org.springframework.android:spring-android-rest-template:1.0.1.RELEASE'
    compile 'com.fasterxml.jackson.core:jackson-databind:2.3.2'
}

```
### AndroidManifest.xml
Add the INTERNET permission so the application can access resources over the internet.
```xml
 <uses-permission android:name="android.permission.INTERNET" />

```
### Create JSONParser.class

