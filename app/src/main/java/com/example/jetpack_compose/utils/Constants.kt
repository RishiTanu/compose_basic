package com.example.jetpack_compose.utils

object Constants {
    const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
    const val DATE_PATTERN = "MM/yyyy"
    const val IMAGE_PATH = "image_path"
    val monthList = listOf("January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December")
    val yearList = listOf("2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029",
        "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040")

    const val home = "home"
    const val profile = "profile"
    const val about = "about"
}