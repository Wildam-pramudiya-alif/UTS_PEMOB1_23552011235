package com.example.uts_pemob1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val loginNowText = findViewById<TextView>(R.id.tvDaftarSekarang)


        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show()
            } else {

                val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        loginNowText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
