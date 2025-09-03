package hr.goodapp.saljidaljeclient.components.widgets

import kotlinx.browser.window
import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLScriptElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.asList
import org.w3c.dom.events.Event
import org.w3c.dom.get
import kotlin.collections.forEach
import kotlin.js.Json
import kotlin.js.definedExternally
import kotlin.js.json

/**
 * Toggling password visibility in password input
 */
fun passwordVisibilityToggle() {
    val elements = document.querySelectorAll(".password-toggle")
    for (i in 0 until elements.length) {
        val element = elements.item(i)?.unsafeCast<HTMLElement>() ?: continue
        val passInput = element.querySelector(".form-control")?.unsafeCast<HTMLInputElement>()
        val passToggle = element.querySelector(".password-toggle-btn")?.unsafeCast<HTMLInputElement>()

        passToggle?.addEventListener("click", { event ->
            val target = event.target?.unsafeCast<HTMLInputElement>()
            if (target?.type != "checkbox") return@addEventListener
            passInput?.type = if (target.checked) "text" else "password"
        }, false)
    }
}
/**
 * Input fields formatter
 * @requires https://github.com/nosir/cleave.js
 */

fun inputFormatter() {
    val inputs = document.querySelectorAll("[data-format]")

    if (inputs.length == 0) return

    inputs.asList().forEach { element ->
        val input = element.unsafeCast<HTMLInputElement>()
        val dataset = input.dataset

        val inputFormat = dataset["format"]   // <- use brackets
        val blocksStr = dataset["blocks"]
        val delimiter =  dataset["delimiter"]

        val blocks = blocksStr?.split(" ")?.map { it.toInt() }?.toTypedArray()

        when (inputFormat) {
            "card" -> js("new Cleave(input, { creditCard: true })")
            "cvc" -> js("new Cleave(input, { numeral: true, numeralIntegerScale: 3 })")
            "date" -> js("new Cleave(input, { date: true, datePattern: ['m','y'] })")
            "date-long" -> js("new Cleave(input, { date: true, delimiter: '-', datePattern: ['Y','m','d'] })")
            "time" -> js("new Cleave(input, { time: true, datePattern: ['h','m'] })")
            "custom" -> {
                val options = js("{}")
                options["delimiter"] = delimiter
                if (blocks != null) options["blocks"] = blocks
                js("new Cleave(input, options)")
            }
            else -> console.error(
                "Sorry, your format $inputFormat is not available. " +
                        "You can add it to the theme object method - inputFormatter in src/js/theme.js " +
                        "or choose one from the list of available formats: card, cvc, date, date-long, time or custom."
            )
        }
    }
}

/**
 * Form validation
 */
fun formValidation() {
    val selector = "needs-validation"

    window.addEventListener("load", {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        val forms = document.getElementsByClassName(selector)

        for (i in 0 until forms.length) {
            val form = forms.item(i) as? HTMLFormElement ?: continue

            form.addEventListener("submit", { event ->
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add("was-validated")
            })
        }
    })
}


/**
 * Add shadow effect to fixed to top navigation bar
 */
fun stickyNavbar() {
    val navbar = document.querySelector(".navbar.fixed-top") as? HTMLElement ?: return
    val scrollOffset = 20

    fun navbarStuck() {
        if (window.pageYOffset > scrollOffset) {
            navbar.classList.add("navbar-stuck")
        } else {
            navbar.classList.remove("navbar-stuck")
        }
    }

    // On load
    window.addEventListener("load", {
        navbarStuck()
    })

    // On scroll
    window.addEventListener("scroll", {
        navbarStuck()
    })
}


/**
 * Anchor smooth scrolling
 * @requires https://github.com/cferdinandi/smooth-scroll/
 */
fun smoothScroll() {
    val selector = "[data-scroll]"
    val fixedHeader = "[data-scroll-header]"

    // Define options as a JSON object
    val options: Json = json(
        "speed" to 800,
        "speedAsDuration" to true,
        "offset" to { _: dynamic, toggle: dynamic ->
            (toggle.dataset.scrollOffset?.unsafeCast<String?>())?.toIntOrNull() ?: 40
        },
        "header" to fixedHeader,
        "updateURL" to false
    )

    // Create SmoothScroll instance via dynamic JS interop
    js("new SmoothScroll(selector, options)")
}

/**
 * Animate scroll to top button in/off view
 */
fun scrollTopButton() {
    val element = document.querySelector(".btn-scroll-top") as? HTMLElement ?: return
    val offsetFromTop = 600

    window.addEventListener("scroll", { _ ->
        if (window.pageYOffset > offsetFromTop) {
            element.classList.add("show")
        } else {
            element.classList.remove("show")
        }
    })
}


@JsName("bootstrap")
external object Bootstrap {
    class Tooltip(element: Element, options: dynamic = definedExternally)
    class Popover(element: Element, options: dynamic = definedExternally)
    class Toast(element: Element, options: dynamic = definedExternally) {
        fun show()
        fun hide()
    }
}

/**
 * Tooltip
 * @requires https://getbootstrap.com
 * @requires https://popper.js.org/
 */

fun initTooltips() {
    val tooltipTriggerList = document.querySelectorAll("[data-bs-toggle=\"tooltip\"]").asList()
    tooltipTriggerList.forEach { node ->
        val el = node as? Element ?: return@forEach
        Bootstrap.Tooltip(el, js("{ trigger: 'hover' }"))
    }
}

/**
 * Popover
 * @requires https://getbootstrap.com
 * @requires https://popper.js.org/
 */

fun initPopovers() {
    val popoverTriggerList = document.querySelectorAll("[data-bs-toggle=\"popover\"]").asList()
    popoverTriggerList.forEach { node ->
        val el = node as? Element ?: return@forEach
        Bootstrap.Popover(el) // you can also pass options: js("{ trigger: 'focus' }")
    }
}

/**
 * Toast
 * @requires https://getbootstrap.com
 */

fun initToasts() {
    val toastElList = document.querySelectorAll(".toast").asList()
    toastElList.forEach { node ->
        val el = node as? Element ?: return@forEach
        Bootstrap.Toast(el) // creates the Toast instance
    }
}


// External bindings for noUiSlider
external object noUiSlider {
    fun create(element: Element, options: dynamic): dynamic
}

/**
 * Range slider
 * @requires https://github.com/leongersen/noUiSlider
 */
fun initRangeSliders() {
    val widgets = document.querySelectorAll(".range-slider").asList()

    widgets.forEach { widgetNode ->
        val widget = widgetNode as? HTMLElement ?: return@forEach

        val slider = widget.querySelector(".range-slider-ui") as? HTMLElement ?: return@forEach
        val valueMinInput = widget.querySelector(".range-slider-value-min") as? HTMLInputElement
        val valueMaxInput = widget.querySelector(".range-slider-value-max") as? HTMLInputElement

        val dataset = widget.asDynamic().dataset
        val dataStartMin = (dataset["startMin"] as? String)?.toIntOrNull() ?: 0
        val dataStartMax = (dataset["startMax"] as? String)?.toIntOrNull()
        val dataMin = (dataset["min"] as? String)?.toIntOrNull() ?: 0
        val dataMax = (dataset["max"] as? String)?.toIntOrNull() ?: 100
        val dataStep = (dataset["step"] as? String)?.toIntOrNull() ?: 1

        val start = if (dataStartMax != null) arrayOf(dataStartMin, dataStartMax) else arrayOf(dataStartMin)
        val connect: dynamic = if (dataStartMax != null) true else "lower"

        noUiSlider.create(slider, jsObject {
            this.start = start
            this.connect = connect
            this.step = dataStep
            this.tooltips = true
            this.range = jsObject<dynamic> {
                this.min = dataMin
                this.max = dataMax
            }
            this.format = jsObject<dynamic> {
                this.to = { value: dynamic -> "$" + (value as Number).toInt() }
                this.from = { value: String -> value.toIntOrNull() ?: 0 }
            }
        })

        val sliderApi = slider.asDynamic().noUiSlider

        sliderApi.on("update") { values: Array<String>, handle: Int ->
            val raw = values[handle].replace(Regex("\\D"), "")
            if (handle == 1) {
                valueMaxInput?.value = raw
            } else {
                valueMinInput?.value = raw
            }
        }

        valueMinInput?.addEventListener("change", {
            sliderApi.set(arrayOf(valueMinInput.value, null))
        })

        valueMaxInput?.addEventListener("change", {
            sliderApi.set(arrayOf(null, valueMaxInput.value))
        })
    }
}

// Helper to make JS object literals easily
inline fun <T> jsObject(builder: T.() -> Unit): T =
    (js("{}") as T).apply(builder)

/**
 * Force dropdown to work as select box
 */
fun dropdownSelect() {
    val dropdownSelectList = document.querySelectorAll("[data-bs-toggle='select']")
    for (i in 0 until dropdownSelectList.length) {
        val dropdownElement = dropdownSelectList.item(i)?.unsafeCast<HTMLElement>() ?: continue

        val dropdownItems = dropdownElement.querySelectorAll(".dropdown-item")
        val dropdownToggleLabel = dropdownElement.querySelector(".dropdown-toggle-label")?.unsafeCast<HTMLElement>()
        val hiddenInput = dropdownElement.querySelector("input[type='hidden']")?.unsafeCast<HTMLInputElement>()

        for (n in 0 until dropdownItems.length) {
            val item = dropdownItems.item(n)?.unsafeCast<HTMLElement>() ?: continue
            item.addEventListener("click", { e: Event ->
                e.preventDefault()
                val dropdownLabel = item.querySelector(".dropdown-item-label")?.textContent ?: ""
                dropdownToggleLabel?.textContent = dropdownLabel
                hiddenInput?.value = dropdownLabel
            })
        }
    }
}


fun carousel() {
    fun <T> forEach(array: Array<T>, callback: (index: Int, value: T) -> Unit) {
        for (i in array.indices) {
            callback(i, array[i])
        }
    }

    val carousels = document.querySelectorAll(".tns-carousel-wrapper .tns-carousel-inner")
    forEach(Array(carousels.length) { carousels[it] as HTMLElement }) { index, value ->
        val controlsText = if (value.dataset["carouselOptions"] != undefined &&
            JSON.parse<dynamic>(value.dataset["carouselOptions"]!!).axis == "vertical"
        ) {
            arrayOf("<i class=\"fi-chevron-up\"></i>", "<i class=\"fi-chevron-down\"></i>")
        } else {
            arrayOf("<i class=\"fi-chevron-left\"></i>", "<i class=\"fi-chevron-right\"></i>")
        }

        val defaults = js("{ container: value, controlsText: controlsText, navPosition: 'bottom', mouseDrag: true, speed: 500, autoplayHoverPause: true, autoplayButtonOutput: false }")

        val userOptions = if (value.dataset["carouselOptions"] != undefined)
            JSON.parse<dynamic>(value.dataset["carouselOptions"]!!) else js("{}")

        val options = js("Object.assign({}, defaults, userOptions)")

        val carousel = window.asDynamic().tns(options) // tns comes from tiny-slider
        val carouselWrapper = value.closest(".tns-carousel-wrapper") as HTMLElement
        val carouselItems = carouselWrapper.querySelectorAll(".tns-item")
        val carouselCurrentSlide = carouselWrapper.querySelector(".tns-current-slide") as HTMLElement?
        val carouselTotalSlides = carouselWrapper.querySelector(".tns-total-slides") as HTMLElement?

        // Center slide logic
        if (carouselWrapper.classList.contains("tns-center")) {
            val indexCurrentInitial = carousel.getInfo().index
            carousel.getInfo().slideItems[indexCurrentInitial].classList.add("active")
            carousel.events.on("indexChanged") {
                val info = carousel.getInfo()
                val indexPrev = info.indexCached
                val indexCurrent = info.index
                info.slideItems[indexPrev].classList.remove("active")
                info.slideItems[indexCurrent].classList.add("active")
            }
        }

        // Slides count
        if (carouselCurrentSlide != null && carouselTotalSlides != null) {
            carouselCurrentSlide.innerHTML = carousel.getInfo().displayIndex.toString()
            carouselTotalSlides.innerHTML = carousel.getInfo().slideCount.toString()
            carousel.events.on("indexChanged") {
                val info = carousel.getInfo()
                carouselCurrentSlide.innerHTML = info.displayIndex.toString()
            }
        }
    }
}


/**
 * Gallery like styled lightbox component for presenting various types of media
 * @requires https://github.com/sachinchoolur/lightGallery
 */

fun gallery() {
    val galleries = document.querySelectorAll(".gallery")
    if (galleries.length == 0) return

    for (i in 0 until galleries.length) {
        val galleryElement = galleries.item(i)?.unsafeCast<HTMLElement>().asDynamic() ?: continue

        val thumbnails = galleryElement.dataset["thumbnails"] != null
        val video = galleryElement.dataset["video"] != null

        // default plugins
        val defaultPlugins = arrayOf(js("lgZoom"), js("lgFullscreen"))
        val videoPlugin = if (video) arrayOf(js("lgVideo")) else emptyArray<Any>()
        val thumbnailPlugin = if (thumbnails) arrayOf(js("lgThumbnail")) else emptyArray<Any>()
        val plugins = js("defaultPlugins.concat(videoPlugin, thumbnailPlugin)")

        js("""
            lightGallery(galleryElement, {
                selector: '.gallery-item',
                plugins: plugins,
                licenseKey: 'D4194FDD-48924833-A54AECA3-D6F8E646',
                download: false,
                autoplayVideoOnSlide: true,
                zoomFromOrigin: false,
                youtubePlayerParams: {modestbranding:1, showinfo:0, rel:0},
                vimeoPlayerParams: {byline:0, portrait:0, color:'fd5631'}
            });
        """)
    }
}

/**
 * Lightbox component for presenting various types of media
 * @requires https://github.com/sachinchoolur/lightGallery
 */

fun lightbox() {
    val toggles = document.querySelectorAll("[data-bs-toggle=\"lightbox\"]")
    if (toggles.length == 0) return

    for (i in 0 until toggles.length) {
        val element = toggles.item(i)?.unsafeCast<HTMLElement>().asDynamic() ?: continue

        val video = element.dataset["video"] != null
        val zoom = element.dataset["zoom"] != null
        val fullscreen = element.dataset["fullscreen"] != null

        val zoomPlugin = if (zoom) arrayOf(js("lgZoom")) else emptyArray<Any>()
        val fsPlugin = if (fullscreen) arrayOf(js("lgFullscreen")) else emptyArray<Any>()
        val videoPlugin = if (video) arrayOf(js("lgVideo")) else emptyArray<Any>()

        val plugins = js("zoomPlugin.concat(fsPlugin, videoPlugin)")

        js("""
            lightGallery(element, {
                selector: 'this',
                plugins: plugins,
                licenseKey: 'D4194FDD-48924833-A54AECA3-D6F8E646',
                download: false,
                youtubePlayerParams: {modestbranding:1, showinfo:0, rel:0},
                vimeoPlayerParams: {byline:0, portrait:0, color:'fd5631'}
            });
        """)
    }
}

/**
 * Date / time picker
 * @requires https://github.com/flatpickr/flatpickr
 */

fun datePicker() {
    val pickers = document.querySelectorAll(".date-picker")
    if (pickers.length == 0) return

    for (i in 0 until pickers.length) {
        val element = pickers.item(i)?.unsafeCast<HTMLElement>().asDynamic() ?: continue

        // Default options
        val defaults = js("""({ disableMobile: true })""")

        // Parse user options if present
        val userOptions = element.dataset["datepickerOptions"]?.let { options ->
            JSON.parse<dynamic>(options)
        }

        // Handle linked input for range picker
        val linkedInput = if (element.classList.contains("date-range")) {
            js("""({ plugins: [ new rangePlugin({ input: element.dataset.linkedInput }) ] })""")
        } else {
            js("""({})""")
        }

        // Merge defaults + linkedInput + userOptions
        val options = js("Object.assign({}, defaults, linkedInput, userOptions)")

        // Initialize flatpickr
        js("flatpickr(element, options)")
    }
}

/**
 * Ajaxify MailChimp subscription form
 */

fun subscriptionForm() {
    val forms = document.querySelectorAll(".subscription-form")
    if (forms.length == 0) return

    for (i in 0 until forms.length) {
        val form = forms[i] as HTMLFormElement

        val button = form.querySelector("button[type=submit]") as? HTMLButtonElement ?: continue
        val buttonText = button.innerHTML
        val input = form.querySelector(".form-control") as? HTMLInputElement ?: continue
        val antispam = form.querySelector(".subscription-form-antispam") as? HTMLInputElement ?: continue
        val status = form.querySelector(".subscription-status") as? HTMLElement ?: continue

        form.addEventListener("submit", { e ->
            e.preventDefault()
            if (antispam.value.isNotEmpty()) return@addEventListener
            register(form, button, input, buttonText, status)
        })
    }
}

fun interactiveMap() {
    val mapList = document.querySelectorAll(".interactive-map")
    if (mapList.length == 0) return

    for (i in 0 until mapList.length) {
        val mapElement = mapList[i].unsafeCast<HTMLElement>()
        val dataset = mapElement.dataset.asDynamic()
        val mapOptionsData = dataset.mapOptions as? String
        val mapOptionsExternal = dataset.mapOptionsJson as? String

        var map: dynamic

        // Inline JSON options
        if (!mapOptionsData.isNullOrEmpty()) {
            val mapOptionsObj = JSON.parse<dynamic>(mapOptionsData)
            val mapLayer = mapOptionsObj.mapLayer ?: "https://api.maptiler.com/maps/voyager/{z}/{x}/{y}.png?key=5vRQzd34MMsINEyeKPIs"
            val mapCoordinates = mapOptionsObj.coordinates ?: arrayOf(0, 0)
            val mapZoom = mapOptionsObj.zoom ?: 1
            val scrollWheelZoom = mapOptionsObj.scrollWheelZoom as? Boolean ?: true
            val markers = mapOptionsObj.markers

            // Map setup
            map = js("L.map(mapElement, {scrollWheelZoom: scrollWheelZoom})").unsafeCast<dynamic>()
            map.setView(mapCoordinates, mapZoom)

            // Tile layer
            js("""
                L.tileLayer(mapLayer, {
                    tileSize: 512,
                    zoomOffset: -1,
                    minZoom: 1,
                    attribution: "<a href='https://www.maptiler.com/copyright/' target='_blank'>&copy; MapTiler</a> <a href='https://www.openstreetmap.org/copyright' target='_blank'>&copy; OpenStreetMap contributors</a>",
                    crossOrigin: true
                }).addTo(map)
            """)

            // Markers
            if (markers != null) {
                for (n in 0 until markers.length) {
                    val markerData = markers[n]
                    val iconUrl = markerData.iconUrl ?: "../img/map/marker-icon.png"
                    val iconClass = markerData.className
                    val markerIcon = js("""
                        L.icon({
                            iconUrl: iconUrl,
                            iconSize: [25,39],
                            iconAnchor: [12,39],
                            shadowUrl: '../img/map/marker-shadow.png',
                            shadowSize: [41,41],
                            shadowAnchor: [13,41],
                            popupAnchor: [1,-28],
                            className: iconClass
                        })
                    """)
                    val marker = js("L.marker(markerData.coordinates, {icon: markerIcon}).addTo(map)")
                    val popup = markerData.popup
                    if (popup != null) {
                        marker.bindPopup(popup)
                    }
                }
            }

        } else if (!mapOptionsExternal.isNullOrEmpty()) {
            // External JSON options
            window.fetch(mapOptionsExternal).then { response ->
                response.json().then { data ->
                    val data = data.asDynamic() // now you can access properties dynamically
                    val mapLayer = data.mapLayer ?: "https://api.maptiler.com/maps/voyager/{z}/{x}/{y}.png?key=5vRQzd34MMsINEyeKPIs"
                    val mapCoordinates = data.coordinates ?: arrayOf(0, 0)
                    val mapZoom = data.zoom ?: 1
                    val scrollWheelZoom = data.scrollWheelZoom as? Boolean ?: true
                    val markers = data.markers

                    map = js("L.map(mapElement, {scrollWheelZoom: scrollWheelZoom})").unsafeCast<dynamic>()
                    map.setView(mapCoordinates, mapZoom)

                    js("""
                        L.tileLayer(mapLayer, {
                            tileSize: 512,
                            zoomOffset: -1,
                            minZoom: 1,
                            attribution: "<a href='https://www.maptiler.com/copyright/' target='_blank'>&copy; MapTiler</a> <a href='https://www.openstreetmap.org/copyright' target='_blank'>&copy; OpenStreetMap contributors</a>",
                            crossOrigin: true
                        }).addTo(map)
                    """)

                    if (markers != null) {
                        for (n in 0 until markers.length) {
                            val markerData = markers[n]
                            val iconUrl = markerData.iconUrl ?: "../img/map/marker-icon.png"
                            val iconClass = markerData.className
                            val markerIcon = js("""
                                L.icon({
                                    iconUrl: iconUrl,
                                    iconSize: [25,39],
                                    iconAnchor: [12,39],
                                    shadowUrl: '../img/map/marker-shadow.png',
                                    shadowSize: [41,41],
                                    shadowAnchor: [13,41],
                                    popupAnchor: [1,-28],
                                    className: iconClass
                                })
                            """)
                            val marker = js("L.marker(markerData.coordinates, {icon: markerIcon}).addTo(map)")
                            val popup = markerData.popup
                            if (popup != null) {
                                marker.bindPopup(popup)
                            }
                        }
                    }
                }
            }

        } else {
            // Default map
            map = js("L.map(mapElement)").unsafeCast<dynamic>()
            map.setView(arrayOf(0, 0), 1)
            js("""
                L.tileLayer('https://api.maptiler.com/maps/voyager/{z}/{x}/{y}.png?key=5vRQzd34MMsINEyeKPIs', {
                    tileSize: 512,
                    zoomOffset: -1,
                    minZoom: 1,
                    attribution: "<a href='https://www.maptiler.com/copyright/' target='_blank'>&copy; MapTiler</a> <a href='https://www.openstreetmap.org/copyright' target='_blank'>&copy; OpenStreetMap contributors</a>",
                    crossOrigin: true
                }).addTo(map)
            """)
        }
    }
}

@JsName("encodeURIComponent")
external fun encodeURIComponent(str: String): String

private fun register(
    form: HTMLFormElement,
    button: HTMLButtonElement,
    input: HTMLInputElement,
    buttonText: String,
    status: HTMLElement
) {
    button.innerHTML = "Sending..."

    // Mailchimp JSONP URL
    val url = form.action.replace("/post?", "/post-json?")

    // Form data
    val data = "&${input.name}=${encodeURIComponent(input.value)}"

    // Create script element
    val script = document.createElement("script") as HTMLScriptElement
    val callback = "callback"

    script.src = "$url&c=$callback$data"
    document.body?.appendChild(script)

    // Define callback on window
    window.asDynamic()[callback] = { response: dynamic ->
        // Clean up
        window.asDynamic()[callback] = undefined
        document.body?.removeChild(script)
        button.innerHTML = buttonText

        if (response.result == "success") {
            input.classList.remove("is-invalid")
            input.classList.add("is-valid")
            status.classList.remove("status-error")
            status.classList.add("status-success")
            status.innerHTML = response.msg as String

            window.setTimeout({
                input.classList.remove("is-valid")
                status.innerHTML = ""
                status.classList.remove("status-success")
            }, 6000)
        } else {
            input.classList.remove("is-valid")
            input.classList.add("is-invalid")
            status.classList.remove("status-success")
            status.classList.add("status-error")
            status.innerHTML = (response.msg as String).substring(4)

            window.setTimeout({
                input.classList.remove("is-invalid")
                status.innerHTML = ""
                status.classList.remove("status-error")
            }, 6000)
        }
    }
}


// Bind the JS Parallax constructor
external class Parallax(element: Element, options: dynamic = definedExternally)

// Initialize cursor parallax
fun cursorParallax() {
    val elements = document.querySelectorAll(".parallax")
    for (i in 0 until elements.length) {
        val element = elements[i] as? Element ?: continue
        Parallax(element)
    }
}

/**
 * Element parallax effect
 * @requires https://github.com/dixonandmoe/rellax
 */

external class Rellax(selector: String, options: dynamic = definedExternally)

fun elementParallax() {
    val el = document.querySelector(".rellax") as? Element
    if (el != null) {
        Rellax(".rellax") // initialize parallax for all elements with .rellax class
    }
}

fun initFileUploader() {
    val fileInputs = document.querySelectorAll(".file-uploader").asList()
    if (fileInputs.isEmpty()) return

    // Register FilePond plugins if they exist
    if (js("typeof FilePondPluginFileValidateType !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginFileValidateType)")
    }
    if (js("typeof FilePondPluginFileValidateSize !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginFileValidateSize)")
    }
    if (js("typeof FilePondPluginImagePreview !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginImagePreview)")
    }
    if (js("typeof FilePondPluginImageCrop !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginImageCrop)")
    }
    if (js("typeof FilePondPluginImageResize !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginImageResize)")
    }
    if (js("typeof FilePondPluginImageTransform !== 'undefined'") as Boolean) {
        js("FilePond.registerPlugin(FilePondPluginImageTransform)")
    }

    // Create FilePond instances
    for (input in fileInputs) {
        js("FilePond.create(input)")
    }
}

/**
 * Bind input value with target element text
 */

fun bindedInputValue() {
    val bindedInputs = document.querySelectorAll("[data-bs-binded-element]")
    if (bindedInputs.length == 0) return

    for (i in 0 until bindedInputs.length) {
        val input = bindedInputs[i]?.unsafeCast<HTMLElement>() ?: continue
        val selector = input.dataset["bsBindedElement"] ?: continue
        val unsetValue = input.dataset["bsUnsetValue"] ?: ""
        val bindedElement = document.querySelector(selector)?.unsafeCast<HTMLElement>() ?: continue

        if (input.tagName.equals("SELECT", ignoreCase = true)) {
            (input as HTMLSelectElement).addEventListener("change", { e: Event ->
                val value = (e.target as? HTMLSelectElement)?.value ?: unsetValue
                bindedElement.innerText = value
            })
        } else if (input.classList.contains("date-picker")) {
            (input as HTMLInputElement).addEventListener("change", { e: Event ->
                val value = (e.target as? HTMLInputElement)?.value
                bindedElement.innerText = value?.ifEmpty { unsetValue } ?: unsetValue
            })
        } else {
            (input as HTMLInputElement).addEventListener("keyup", { e: Event ->
                val value = (e.target as? HTMLInputElement)?.value
                bindedElement.innerText = value?.ifEmpty { unsetValue } ?: unsetValue
            })
        }
    }
}

/**
 * Master checkbox that checkes / unchecks all target checkboxes at once
 */

fun masterCheckbox(){
    val masterCheckboxes = document.querySelectorAll("[data-master-checkbox-for]")

    if (masterCheckboxes.length > 0) {
        for (i in 0 until masterCheckboxes.length) {
            val master = masterCheckboxes[i]?.unsafeCast<HTMLInputElement>() ?: continue
            master.addEventListener("change", callback = {
                val targetSelector = master.dataset["masterCheckboxFor"] ?: return@addEventListener
                val targetWrapper = document.querySelector(targetSelector)?.unsafeCast<HTMLElement>() ?: return@addEventListener
                val targetCheckboxes = targetWrapper.querySelectorAll("input[type='checkbox']")

                val checked = master.checked

                for (n in 0 until targetCheckboxes.length) {
                    val cb = targetCheckboxes[n]?.unsafeCast<HTMLInputElement>() ?: continue
                    cb.checked = checked

                    val toggleClass = cb.dataset["checkboxToggleClass"]
                    val target = cb.dataset["bsTarget"]?.let { document.querySelector(it)?.unsafeCast<HTMLElement>() }

                    if (toggleClass != null && target != null) {
                        if (checked) target.classList.add(toggleClass)
                        else target.classList.remove(toggleClass)
                    }
                }
            })
        }
    }
}

/**
 * Toggle CSS class passed via data attribute
 */

fun toggle() {
    val togglers = document.querySelectorAll("[data-bs-toggle-class]")

    for (i in 0 until togglers.length) {
        val toggler = togglers[i]?.unsafeCast<HTMLElement>() ?: continue
        toggler.addEventListener(
            type = "click",
            callback = { e: Event ->
                e.preventDefault()

                val currentTarget = e.currentTarget?.unsafeCast<HTMLElement>() ?: return@addEventListener
                val targetSelector = currentTarget.dataset["bsTarget"] ?: return@addEventListener
                val toggleClass = currentTarget.dataset["bsToggleClass"] ?: return@addEventListener

                val targetEl = document.querySelector(targetSelector)?.unsafeCast<HTMLElement>() ?: return@addEventListener
                targetEl.classList.toggle(toggleClass)
            }
        )
    }
}