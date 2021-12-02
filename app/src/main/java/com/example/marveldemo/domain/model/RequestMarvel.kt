package com.example.marveldemo.domain.model

data class RequestMarvel (

	val code : Int,
	val status : String,
	val copyright : String,
	val attributionText : String,
	val attributionHTML : String,
	val etag : String,
	val data : Data
)