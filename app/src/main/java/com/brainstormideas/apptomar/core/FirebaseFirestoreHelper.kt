package com.brainstormideas.apptomar.core

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseFirestoreHelper {
    val dataBase = Firebase.firestore
    fun getFireStoreDataBase(): FirebaseFirestore {
        return dataBase
    }
}