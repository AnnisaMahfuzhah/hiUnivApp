package com.example.hiunivapp.network

import com.squareup.moshi.Json

data class Univ (
    val idUniv: String,
    @Json(name = "alpha_two_code") val alpha_two_code : String,
    @Json(name = "domains") val domains : String,
    @Json(name = "country") val country : String,
    @Json(name = "statepropince") val stateprovince : String,
    @Json(name = "web_pages") val web_pages : String,
    @Json(name = "name") val name : String
)