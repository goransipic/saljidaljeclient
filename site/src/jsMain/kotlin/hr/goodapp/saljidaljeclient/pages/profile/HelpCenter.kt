package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.profile.HelpCenterContent
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems

@Composable
@Page("help-center")
@Layout(".components.layouts.PageLayout")
fun HelpCenter() {
    HelpCenterContent()
}