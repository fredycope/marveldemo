package com.example.marveldemo.domain.model

data class Data (

	val offset : Int,
	val limit : Int,
	val total : Int,
	val count : Int,
	val results : List<Results>
)