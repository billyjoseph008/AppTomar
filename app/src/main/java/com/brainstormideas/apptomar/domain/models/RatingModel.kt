package com.brainstormideas.apptomar.domain.models

data class RatingModel(val client: ClientModel, val stars: Int, val comment: String)
