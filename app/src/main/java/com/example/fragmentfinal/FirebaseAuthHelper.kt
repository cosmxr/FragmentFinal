// File: app/src/main/java/com/example/fragmentfinal/FirebaseAuthHelper.kt
package com.example.fragmentfinal

import com.google.firebase.auth.FirebaseAuth

object FirebaseAuthHelper {
    //Usuario que siempe va a ser aceptado
    private const val EMAIL = "fixeduser@example.com"
    private const val PASSWORD = "fixedpassword"

    fun signIn(onComplete: (Boolean) -> Unit) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnCompleteListener { task ->
                onComplete(task.isSuccessful)
            }
    }
}