package hr.goodapp.saljidaljeclient.components.sections.profile.common

enum class SidebarItems(val url: String, val title : String) {
    PERSONAL_INFO("/profile/","Personal Info"),
    PASSWORD_SECURITY("/profile/password-security","Password & Security"),
    CARS("/profile/cars","My Cars"),
    WHISH_LIST("/profile/wish-list", "Wishlist"),
    REVIEWS("/profile/reviews","Reviews"),
    NOTIFICATION("/profile/notifications", "Notifications"),
}