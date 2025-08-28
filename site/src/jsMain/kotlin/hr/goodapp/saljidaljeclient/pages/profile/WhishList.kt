package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content

@Composable
@Page("wishlist")
@Layout(".components.layouts.AccountLayout")
fun WhishList() {
    Content(SidebarItems.WHISH_LIST)
}