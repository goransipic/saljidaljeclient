package hr.goodapp.saljidaljeclient.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.layout.Layout
import hr.goodapp.saljidaljeclient.components.sections.common.*
import hr.goodapp.saljidaljeclient.components.widgets.*
import org.jetbrains.compose.web.dom.Main


@Composable
@Layout
fun PageLayout(ctx: PageContext, content: @Composable () -> Unit) {
    //val data = ctx.data.getValue<PageLayoutData>()
    /*LaunchedEffect(data.title) {
        document.title = "Kobweb - ${data.title}"
    }*/
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
    BackToTop()
}
