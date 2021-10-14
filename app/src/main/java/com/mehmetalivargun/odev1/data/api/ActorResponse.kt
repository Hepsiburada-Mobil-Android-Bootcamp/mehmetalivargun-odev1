package com.mehmetalivargun.odev1.data.api

data class ActorResponse(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)