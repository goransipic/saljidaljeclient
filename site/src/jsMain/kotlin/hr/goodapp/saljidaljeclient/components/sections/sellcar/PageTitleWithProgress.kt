package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun PageTitleWithProgress(
    title: String,
    progress: Int // e.g. 80
) {
    @Composable
    fun TitleSection(title: String, progress: Int) {
        Div(attrs = { classes("mb-4") }) {
            // Title
            H1(attrs = { classes("h2", "text-light", "mb-0") }) {
                Text(title)
            }

            // Mobile-only text
            Div(attrs = { classes("d-lg-none", "text-light", "pt-3", "mb-2") }) {
                Text("$progress% content filled")
            }

            // Mobile-only progress bar
            Div(attrs = {
                classes("progress", "progress-light", "d-lg-none", "mb-4")
                style { property("height", ".25rem") }
            }) {
                Div(attrs = {
                    classes("progress-bar", "bg-success")
                    attr("role", "progressbar")
                    style { property("width", "${progress}%") }
                    attr("aria-valuenow", progress.toString())
                    attr("aria-valuemin", "0")
                    attr("aria-valuemax", "100")
                })
            }
        }
    }
}