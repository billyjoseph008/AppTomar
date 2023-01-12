package com.brainstormideas.apptomar.domain.models

data class ProductModel(
    val id: Int, val name: String, val branch: String, val price: Double,
    val amount: Int, val picture: String, val category: Category
)