package hr.goodapp.saljidaljeclient.components.sections.category

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun CatalogList() {
    Div(attrs = { classes("col-lg-9") }) {
        BreadCrumb()
        PageTitle()
        SortingAndView()
        cars.forEach { car ->
            CarItem(car)
        }
        SortingAndPagination()
    }
}


val cars = listOf(
    CarData(
        year = 1995,
        title = "Ford kamion s liftom",
        price = "$24,000",
        location = "Chicago",
        mileage = "278K milja",
        gearbox = "Ručni",
        fuel = "Dizel",
        images = listOf(
            "/img/car-finder/catalog/09.jpg",
            "/img/car-finder/catalog/09.jpg"
        )
    ),
    CarData(
        year = 2018,
        title = "Mercedes Benz C300 Sport",
        price = "$53,400",
        location = "San Francisco",
        mileage = "35K milja",
        gearbox = "Automatski",
        fuel = "Hibrid",
        images = listOf(
            "/img/car-finder/catalog/10.jpg",
            "/img/car-finder/catalog/10.jpg"
        ),
        isCertified = true
    ),
    CarData(
        year = 2019,
        title = "Mazda MX-5 Miata kabriolet",
        price = "$36,500",
        location = "Los Angeles",
        mileage = "18K milja",
        gearbox = "Ručni",
        fuel = "Benzin",
        images = listOf(
            "/img/car-finder/catalog/11.jpg",
            "/img/car-finder/catalog/11.jpg"
        )
    ),
    CarData(
        year = 2019,
        title = "Nissan 370Z Nismo",
        price = "$37,900",
        location = "New York",
        mileage = "16K milja",
        gearbox = "Automatski",
        fuel = "Benzin",
        images = listOf(
            "/img/car-finder/catalog/12.jpg",
            "/img/car-finder/catalog/12.jpg"
        )
    ),
    CarData(
        year = 2018,
        title = "BMW 640 XI Gran Turismo",
        price = "$44,300",
        location = "New Jersey",
        mileage = "10K milja",
        gearbox = "Automatski",
        fuel = "Benzin",
        images = listOf(
            "/img/car-finder/catalog/13.jpg",
            "/img/car-finder/catalog/13.jpg"
        ),
        isCertified = true
    ),
    CarData(
        year = 2015,
        title = "Toyota GT86",
        price = "$16,000",
        location = "Chicago",
        mileage = "46K milja",
        gearbox = "Ručni",
        fuel = "Benzin",
        images = listOf(
            "/img/car-finder/catalog/14.jpg",
            "/img/car-finder/catalog/14.jpg"
        )
    ),
    CarData(
        year = 2019,
        title = "Volkswagen GTI S",
        price = "$29,000",
        location = "San Francisco",
        mileage = "25K milja",
        gearbox = "Automatski",
        fuel = "Hibrid",
        images = listOf(
            "/img/car-finder/catalog/15.jpg",
            "/img/car-finder/catalog/15.jpg"
        ),
        isCertified = true
    ),
    CarData(
        year = 2017,
        title = "Ford Explorer XLT",
        price = "$26,900",
        location = "Kansas",
        mileage = "34K milja",
        gearbox = "Ručni",
        fuel = "Dizel",
        images = listOf(
            "/img/car-finder/catalog/16.jpg",
            "/img/car-finder/catalog/16.jpg"
        )
    )
)

data class CarData(
    val year: Int,
    val title: String,
    val price: String,
    val location: String,
    val mileage: String,
    val gearbox: String,
    val fuel: String,
    val images: List<String>,
    val isUsed: Boolean = true,
    val isCertified: Boolean = false
)