package com.example.uts_pemob1
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val daftarSekarang = findViewById<TextView>(R.id.tvDaftarSekarang)

        loginButton.setOnClickListener {
            val inputEmail = emailEditText.text.toString().trim()
            val inputPassword = passwordEditText.text.toString().trim()

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", null)
            val savedPassword = sharedPref.getString("password", null)


            if (inputEmail == savedEmail && inputPassword == savedPassword) {

                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("email", savedEmail)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        daftarSekarang.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
