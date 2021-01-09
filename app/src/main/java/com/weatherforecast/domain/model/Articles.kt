package com.weatherforecast.domain.model


class Articles {
    var publishedAt: String? = null
    var author: String? = null
    var urlToImage: String? = null
    var description: String? = null
    var source: Source? = null
    var title: String? = null
    var url: String? = null
    var content: String? = null

    override fun toString(): String {
        return "ClassPojo [publishedAt = $publishedAt, author = $author, urlToImage = $urlToImage, description = $description, source = $source, title = $title, url = $url, content = $content]"
    }
}
