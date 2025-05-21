package com.example.grubgo
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<Button>(R.id.registerButton)
        val goToLogin = findViewById<TextView>(R.id.goToLoginText)

        registerButton.setOnClickListener {
            // Enregistrement simulé
            Toast.makeText(this, "Compte créé avec succès", Toast.LENGTH_SHORT).show()
        }

        goToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
