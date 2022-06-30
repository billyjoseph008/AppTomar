package com.brainstormideas.apptomar.models

data class Payment (val id: String, val products: Array<Product>, val totalPayment: Double,
                        val iva: Double, val commission: Double, val tip: Double,
                        val finalPayment: Double, val filled: Boolean)