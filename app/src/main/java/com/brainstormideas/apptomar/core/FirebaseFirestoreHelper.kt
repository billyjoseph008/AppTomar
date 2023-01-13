package com.brainstormideas.apptomar.core

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseFirestoreHelper {
    fun getFireStoreDataBase(): FirebaseFirestore {
        return Firebase.firestore
    }
}