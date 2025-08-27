package hr.goodapp.saljidaljeclient.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.SpanText


@Composable
@Page
fun Test() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SpanText("Helooooooo....")
    }
}