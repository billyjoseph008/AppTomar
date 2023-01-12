package com.brainstormideas.apptomar.domain.models

data class PaymentModel(
    val id: String, val products: Array<ProductModel>, val totalPayment: Double,
    val iva: Double, val commission: Double, val tip: Double,
    val finalPayment: Double, val filled: Boolean
)