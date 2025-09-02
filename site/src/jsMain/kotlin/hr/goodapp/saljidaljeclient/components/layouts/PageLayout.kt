package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.data.get
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.*
import hr.goodapp.saljidaljeclient.components.widgets.*
import org.jetbrains.compose.web.dom.Main


data class PageLayoutData(val content: @Composable () -> Unit)

@Composable
@Layout
fun PageLayout(ctx: PageContext, content: @Composable () -> Unit) {
    val data = ctx.data.get<PageLayoutData>()

    LaunchedEffect(ctx.route.path) {
        passwordVisibilityToggle()
        inputFormatter()
        formValidation()
        stickyNavbar()
        smoothScroll()
        scrollTopButton()
        initTooltips()
        initPopovers()
        initToasts()
        initRangeSliders()
        dropdownSelect()
        carousel()
        gallery()
        lightbox()
        datePicker()
        subscriptionForm()
        interactiveMap()
        cursorParallax()
        elementParallax()
        initFileUploader()
        bindedInputValue()
        masterCheckbox()
        toggle()
    }
    Main(attrs = {classes("page-wrapper")}){
        SignInModal()
        SignupModal()
        NavbarBar()
        content()
    }
    CustomFooter()
    if (data != null)
        data.content()
    BackToTop()
}
