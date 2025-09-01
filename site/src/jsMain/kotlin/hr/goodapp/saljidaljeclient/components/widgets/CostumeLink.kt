package hr.goodapp.saljidaljeclient.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.init.KobwebConfig
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.navigation.toOpenLinkStrategy
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLAnchorElement


@Composable
fun CostumeLink(
    href: String,
    attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
    openInternalLinksStrategy: OpenLinkStrategy? = null,
    openExternalLinksStrategy: OpenLinkStrategy? = null,
    updateHistoryMode: UpdateHistoryMode? = null,
    content: ContentBuilder<HTMLAnchorElement>? = null
) {
    val ctx = rememberPageContext()
    A(
        BasePath.prependTo(href), // match `navigateTo` which internally prepends as well
        attrs = {
            if (attrs != null) {
                attrs()
            }
            @Suppress("NAME_SHADOWING") // Intentional shadowing - nullable to non-null
            onClick { evt ->
                val openInternalLinksStrategy = openInternalLinksStrategy
                    ?: evt.toOpenLinkStrategy(KobwebConfig.Instance.openLinkStrategies.internal)
                val openExternalLinksStrategy = openExternalLinksStrategy
                    ?: evt.toOpenLinkStrategy(KobwebConfig.Instance.openLinkStrategies.external)
                ctx.router.navigateTo(
                    href,
                    updateHistoryMode ?: UpdateHistoryMode.PUSH,
                    openInternalLinksStrategy = openInternalLinksStrategy,
                    openExternalLinksStrategy = openExternalLinksStrategy,
                )
                evt.preventDefault()
                evt.stopPropagation()
            }
        },
        content
    )
}