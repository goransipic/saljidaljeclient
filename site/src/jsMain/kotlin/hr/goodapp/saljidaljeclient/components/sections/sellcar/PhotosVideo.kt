package hr.goodapp.saljidaljeclient.components.sections.sellcar

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun PhotosVideo() {
    Section(attrs = { classes("card", "card-light", "card-body", "shadow-sm", "p-4", "mb-4"); attr("id", "photos") }) {
        H2(attrs = { classes("h4", "text-light", "mb-4") }) {
            I(attrs = { classes("fi-image", "text-primary", "fs-5", "mt-n1", "me-2") }) {}
            Text("Fotografije / video")
        }

        Div(attrs = { classes("alert", "alert-warning", "bg-faded-warning", "border-warning", "mb-4"); attr("role", "alert") }) {
            Div(attrs = { classes("d-flex") }) {
                I(attrs = { classes("fi-alert-circle", "me-2", "me-sm-3") }) {}
                P(attrs = { classes("fs-sm", "mb-1") }) {
                    Text(
                        "Maksimalna veličina fotografije je 8 MB. Formati: jpeg, jpg, png. Glavnu sliku stavite prvu.\n" +
                                "Maksimalna veličina videa je 10 MB. Formati: mp4, mov."
                    )
                }
            }
        }

        Input(type = InputType.File, attrs = {
            classes("file-uploader", "file-uploader-grid", "bg-faded-light", "border-light")
            attr("multiple", "true")
            attr("data-max-file-size", "10MB")
            attr("accept", "image/png, image/jpeg, video/mp4, video/mov")
            attr(
                "data-label-idle",
                """<div class="btn btn-primary mb-3"><i class="fi-cloud-upload me-1"></i>Učitaj fotografije / video</div>
                   <div class="text-light opacity-70">ili ih povuci ovdje</div>"""
            )
        })
    }
}