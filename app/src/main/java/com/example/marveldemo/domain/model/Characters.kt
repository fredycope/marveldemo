package com.example.marveldemo.domain.model

data class Characters (

	val available : Int,
	val collectionURI : String,
	val items : List<Items>,
	val returned : Int
)