package com.github.dakyskye.ticietacietoe.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.github.dakyskye.ticietacietoe.R
import com.github.dakyskye.ticietacietoe.ui.game.GameActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewById<Button>(R.id.welcomeScreenButtonPlay).setOnClickListener {
            val player1 = findViewById<EditText>(R.id.welcomeScreenPlayer1).text.toString()
            val player2 = findViewById<EditText>(R.id.welcomeScreenPlayer2).text.toString()

            val intent = Intent(this, GameActivity::class.java).apply {
                putExtra("PLAYER_1", player1)
                putExtra("PLAYER_2", player2)
            }

            startActivity(intent)
        }
    }
}