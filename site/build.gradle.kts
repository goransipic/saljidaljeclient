import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    //alias(libs.plugins.kobwebx.markdown)
}

group = "hr.goodapp.saljidaljeclient"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
            faviconPath.set("/favicon.ico")
            head.add {
                link(rel = "stylesheet", href = "vendor/simplebar/dist/simplebar.min.css")
                link(rel = "stylesheet", href = "vendor/tiny-slider/dist/tiny-slider.css")
                link(rel = "stylesheet", href = "/css/theme.css")
//                script(src = "vendor/bootstrap/dist/js/bootstrap.bundle.min.js") { type = "text/javascript" }
//                script(src = "vendor/simplebar/dist/simplebar.min.js") { type = "text/javascript" }
//                script(src = "vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js") { type = "text/javascript" }
//                script(src = "vendor/tiny-slider/dist/min/tiny-slider.js") { type = "text/javascript" }
//                script(src = "vendor/jarallax/dist/jarallax.min.js") { type = "text/javascript" }
//                script(src = "vendor/rellax/rellax.min.js") { type = "text/javascript" }
//
//                // Main theme script
//                script(src = "js/theme.min.js") { type = "text/javascript" }
            }
        }
    }
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("saljidaljeclient" /*, includeServer = true*/)

    sourceSets {
//        commonMain.dependencies {
//          // Add shared dependencies between JS and JVM here if building a fullstack app
//        }

        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            // This default template uses built-in SVG icons, but what's available is limited.
            // Uncomment the following if you want access to a large set of font-awesome icons:
            // implementation(libs.silk.icons.fa)
            //implementation(libs.kobwebx.markdown)
        }

        // Uncomment the following if you pass `includeServer = true` into the `configAsKobwebApplication` call.
//        jvmMain.dependencies {
//            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
//        }
    }
}
