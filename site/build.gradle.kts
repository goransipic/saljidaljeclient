import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

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
                link(rel = "stylesheet", href = "/vendor/simplebar/dist/simplebar.min.css")
                link(rel = "stylesheet", href = "/vendor/tiny-slider/dist/tiny-slider.css")
                link(rel = "stylesheet", href = "/vendor/lightgallery/css/lightgallery-bundle.min.css")


                // FilePond CSS (optional, but usually needed)
                link(rel = "stylesheet", href = "/vendor/filepond/dist/filepond.min.css")
                link(rel = "stylesheet", href = "/vendor/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css")

                link(rel = "stylesheet", href = "/vendor/leaflet/dist/leaflet.css")

                link(rel = "stylesheet", href = "/vendor/nouislider/dist/nouislider.min.css")

                link(rel = "stylesheet", href = "/css/theme.css")


                script(src = "/vendor/bootstrap/dist/js/bootstrap.bundle.min.js") {
                    type = "text/javascript"

                }
                script(src = "/vendor/simplebar/dist/simplebar.min.js") {
                    type = "text/javascript"

                }
                script(src = "/vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js") {
                    type = "text/javascript"

                }

                script(src = "/vendor/leaflet/dist/leaflet.js") {
                    type = "text/javascript"

                }
                script(src = "/vendor/tiny-slider/dist/min/tiny-slider.js") {
                    type = "text/javascript"

                }

                script(src = "/vendor/lightgallery/lightgallery.min.js") {
                    type = "text/javascript"

                }

                script(src = "/vendor/lightgallery/plugins/video/lg-video.min.js") {
                    type = "text/javascript"

                }

                /*script(src = "/vendor/lightgallery/plugins/fullscreen/lg-fullscreen.min.js") {
                    type = "text/javascript"

                }*/

                script(src = "/vendor/nouislider/dist/nouislider.min.js") {
                    type = "text/javascript"

                }

                script(src = "/vendor/jarallax/dist/jarallax.min.js") {
                    type = "text/javascript"

                }
                script(src = "/vendor/rellax/rellax.min.js") {
                    type = "text/javascript"

                }

                // FilePond plugins + core JS
                script(src = "/vendor/filepond-plugin-file-validate-type/dist/filepond-plugin-file-validate-type.min.js") {
                    type = "text/javascript"
                }
                script(src = "/vendor/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.js") {
                    type = "text/javascript"
                }
                script(src = "/vendor/filepond-plugin-image-crop/dist/filepond-plugin-image-crop.min.js") {
                    type = "text/javascript"
                }
                script(src = "/vendor/filepond-plugin-image-resize/dist/filepond-plugin-image-resize.min.js") {
                    type = "text/javascript"
                }
                script(src = "/vendor/filepond-plugin-image-transform/dist/filepond-plugin-image-transform.min.js") {
                    type = "text/javascript"
                }
                script(src = "/vendor/filepond/dist/filepond.min.js") {
                    type = "text/javascript"
                }

                // Main theme script
                /*script(src = "/js/theme.js") {
                    type = "text/javascript"
                    defer = true
                }*/
            }
        }
    }
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("saljidaljeclient" /*, includeServer = true*/)

    sourceSets {
        commonMain.dependencies {
            implementation(project(":common"))
        }

        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.ktor.client.js)
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
