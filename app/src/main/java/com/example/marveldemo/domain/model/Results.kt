package com.example.marveldemo.domain.model

data class Results (

	val id : Int,
	val digitalId : Int,
	val title : String,
	val issueNumber : Int,
	val variantDescription : String,
	val description : String,
	val modified : String,
	val isbn : String,
	val upc : String,
	val diamondCode : String,
	val ean : String,
	val issn : String,
	val format : String,
	val pageCount : Int,
	val textObjects : List<TextObjects>,
	val resourceURI : String,
	val urls : List<Urls>,
	val series : Series,
	val variants : List<Variants>,
	val collections : List<String>,
	val collectedIssues : List<CollectedIssues>,
	val dates : List<Dates>,
	val prices : List<Prices>,
	val thumbnail : Thumbnail,
	val images : List<Images>,
	val creators : Creators,
	val characters : Characters,
	val stories : Stories,
	val events : Events
)