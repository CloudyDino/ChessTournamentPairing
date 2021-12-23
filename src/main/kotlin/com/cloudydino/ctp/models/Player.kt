package com.cloudydino.ctp.models

data class Player(
    val id: String,
    val rating: Int?,
    val roundsRequestingByes: List<Int>,
)
