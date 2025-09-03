package hr.goodapp.saljidaljeclient.components.sections.profile.common

enum class SidebarItems(val url: String, val title: String) {
    PERSONAL_INFO("/profile/", "Osobni podaci"),
    PASSWORD_SECURITY("/profile/password-security", "Lozinka i sigurnost"),
    CARS("/profile/cars", "Moji automobili"),
    WHISH_LIST("/profile/wish-list", "Lista želja"),
    REVIEWS("/profile/reviews", "Recenzije"),
    NOTIFICATION("/profile/notifications", "Obavijesti"),
}