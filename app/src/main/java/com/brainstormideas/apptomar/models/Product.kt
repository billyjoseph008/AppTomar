package com.brainstormideas.apptomar.models

data class Product (val id: Int, val name: String, val branch: String, val price: Double,
                        val amount: Int, val picture: String, val category: Category)