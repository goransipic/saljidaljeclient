package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content

@Composable
@Page("password-security")
@Layout(".components.layouts.AccountLayout")
fun PasswordSecurity() {
    Content(SidebarItems.PASSWORD_SECURITY)
}