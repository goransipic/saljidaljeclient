package hr.goodapp.saljidaljeclient.pages.category

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.layouts.PageLayoutData
import hr.goodapp.saljidaljeclient.components.sections.category.CatalogList
import hr.goodapp.saljidaljeclient.components.sections.category.FilterButton
import hr.goodapp.saljidaljeclient.components.sections.category.FiltersSidebar
import org.jetbrains.compose.web.dom.Div


@InitRoute
fun initCategoryPage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData(content = {
        FilterButton()
    }))
}

@Composable
@Page("index")
@Layout(".components.layouts.PageLayout")
fun CategoryPage() {
    Div(attrs = {
        classes("container", "mt-5", "mb-md-4", "py-5")
    }) {
        Div(attrs = {
            classes("row", "py-md-1")
        }) {
            FiltersSidebar()
            CatalogList()
        }
    }
}


