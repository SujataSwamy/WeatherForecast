package com.weatherforecast.domain.model

class Pojo {
    var totalResults: String? = null
    lateinit var articles: Array<Articles>
    var status: String? = null

    override fun toString(): String {
        return "ClassPojo [totalResults = $totalResults, articles = $articles, status = $status]"
    }
}
