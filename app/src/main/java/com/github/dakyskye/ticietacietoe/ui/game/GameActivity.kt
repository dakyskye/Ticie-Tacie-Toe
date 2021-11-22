package com.github.dakyskye.ticietacietoe.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.github.dakyskye.ticietacietoe.R
import com.github.dakyskye.ticietacietoe.game.*
import com.github.dakyskye.ticietacietoe.game.board.GameBoard
import com.github.dakyskye.ticietacietoe.game.board.ScoreBoard
import com.github.dakyskye.ticietacietoe.game.column.BoardColumn
import com.github.dakyskye.ticietacietoe.game.player.Player
import com.github.dakyskye.ticietacietoe.game.player.Players

class GameActivity : AppCompatActivity() {
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        init()
    }

    private fun init() {
        game = Game(
            Players(
                Player(intent.getStringExtra("PLAYER_1").toString().ifEmpty { "Ticie" }),
                Player(intent.getStringExtra("PLAYER_2").toString().ifEmpty { "Tacie" })
            ),
            ScoreBoard(
                findViewById(R.id.GamePlayer1),
                findViewById(R.id.GamePlayer2),
                findViewById(R.id.GameScore)
            ),
            GameBoard(
                BoardColumn(
                    findViewById(R.id.GameBoardColumnTopLeft),
                    findViewById(R.id.GameBoardColumnTopCentre),
                    findViewById(R.id.GameBoardColumnTopRight),
                ),
                BoardColumn(
                    findViewById(R.id.GameBoardColumnMiddleLeft),
                    findViewById(R.id.GameBoardColumnMiddleCentre),
                    findViewById(R.id.GameBoardColumnMiddleRight)
                ),
                BoardColumn(
                    findViewById(R.id.GameBoardColumnBottomLeft),
                    findViewById(R.id.GameBoardColumnBottomCentre),
                    findViewById(R.id.GameBoardColumnBottomRight)
                )
            ),
        )

        findViewById<Button>(R.id.GameButtonRestart).setOnClickListener {
            Toast.makeText(this, "Resetting the game", Toast.LENGTH_SHORT).show()
            game.reset()
        }
    }

    fun onColumnClick(clickedView: View) {
        if (clickedView !is Button) {
            return
        }

        if (game.result != null) {
            game.startNewRound()
        }

        game.process(clickedView)

        val res = game.result ?: return

        val text = if (res.isTie) {
            "None of the players has won the round! A tie!"
        } else {
            "${res.winner} has won the round!"
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}