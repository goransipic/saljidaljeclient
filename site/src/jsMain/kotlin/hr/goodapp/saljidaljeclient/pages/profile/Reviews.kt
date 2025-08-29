package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems


@Page("reviews")
@Layout(".components.layouts.AccountLayout")
@Composable
fun Reviews() {
    Content(SidebarItems.REVIEWS)
}