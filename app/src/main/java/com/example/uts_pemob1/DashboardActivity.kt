package com.example.uts_pemob1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
        private lateinit var binding: AdapterList

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_dashboard)

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.layoutManager = GridLayoutManager(this, 1)
            recyclerView.setHasFixedSize(true)

            val itemList = listOf(
                ItemList("Gear Set", " komponen penggerak rantai pada sepeda motor yang terdiri dari tiga bagian utama: " +
                        "\n1. Gear depan (sprocket depan): terhubung ke mesin." +
                        "\n2. Gear belakang (sprocket belakang): terhubung ke roda belakang." +
                        "\n3. Rantai: menghubungkan gear depan dan belakang untuk menyalurkan tenaga dari mesin ke roda.",
                    R.drawable.gearset),
                ItemList("Komponen Stir(KomStir)", "Bagian dari sistem kemudi pada sepeda motor maupun sepeda. Nama teknisnya adalah bearing setir atau steering bearing, dan fungsinya sangat penting, diantaranya untuk menjaga keseimbangan dan kontrol saat berkendara, terutama saat belok.",
                    R.drawable.komstir),
                ItemList("Roller", "komponen penting pada motor matic yang berada di dalam CVT (Continuously Variable Transmission), tepatnya di bagian rumah roller (drive pulley/drive face).",
                    R.drawable.roller)
            )

            val adapter = AdapterList(itemList)
            recyclerView.adapter = adapter
        }
    }
