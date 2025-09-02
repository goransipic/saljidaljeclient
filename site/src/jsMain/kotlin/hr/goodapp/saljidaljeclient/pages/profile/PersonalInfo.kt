package hr.goodapp.saljidaljeclient.pages.profile

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.AccountLayoutData
import hr.goodapp.saljidaljeclient.components.sections.profile.common.SidebarItems
import hr.goodapp.saljidaljeclient.components.sections.profile.common.Content


@InitRoute
fun initAccountInfoPage(ctx: InitRouteContext) {
    ctx.data.add(AccountLayoutData(SidebarItems.PERSONAL_INFO))
}

@Composable
@Page("index")
@Layout(".components.layouts.AccountLayout")
fun PersonalInfoPage() {
    Content(SidebarItems.PERSONAL_INFO)
}