package com.example.compteurandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur: Int = 0

    private lateinit var textViewCompteur: TextView
    private lateinit var buttonIncrementer: Button
    private lateinit var buttonDecrementer: Button
    private lateinit var buttonReinitialiser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupération des composants
        textViewCompteur = findViewById(R.id.textViewCompteur)
        buttonIncrementer = findViewById(R.id.buttonIncrementer)
        buttonDecrementer = findViewById(R.id.buttonDecrementer)
        buttonReinitialiser = findViewById(R.id.buttonReinitialiser)

        // Restauration après rotation (amélioration facultative)
        compteur = savedInstanceState?.getInt("compteur") ?: 0
        mettreAJourAffichage()

        // Clics sur les boutons
        buttonIncrementer.setOnClickListener {
            compteur++
            mettreAJourAffichage()
        }

        buttonDecrementer.setOnClickListener {
            compteur--
            mettreAJourAffichage()
        }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            mettreAJourAffichage()
        }
    }

    private fun mettreAJourAffichage() {
        textViewCompteur.text = compteur.toString()
        textViewCompteur.setTextColor(
            when {
                compteur > 0 -> Color.rgb(0, 150, 0)   // vert
                compteur < 0 -> Color.RED              // rouge
                else -> Color.BLACK                    // noir
            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", compteur)
    }
}