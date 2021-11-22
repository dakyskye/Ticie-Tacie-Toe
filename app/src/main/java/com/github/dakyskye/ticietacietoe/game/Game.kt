package com.github.dakyskye.ticietacietoe.game

import android.annotation.SuppressLint
import android.widget.Button
import com.github.dakyskye.ticietacietoe.game.board.GameBoard
import com.github.dakyskye.ticietacietoe.game.board.ScoreBoard
import com.github.dakyskye.ticietacietoe.game.player.Players

@SuppressLint("SetTextI18n")
class Game(
    private val players: Players,
    private val scoreBoard: ScoreBoard,
    private val gameBoard: GameBoard
) {
    private var turnOfFirstPlayer = true

    var result: Result? = null
        private set

    init {
        scoreBoard.name1.text = players.player1.name
        scoreBoard.name2.text = players.player2.name
        updateScoreBoard()
    }

    fun process(column: Button) {
        val col = gameBoard.column.filterValues { it.id == column.id }

        col.values.first().apply {
            isEnabled = false
            text = if (turnOfFirstPlayer) {
                "X"
            } else {
                "O"
            }
        }

        val player = if (turnOfFirstPlayer) {
            turnOfFirstPlayer = false
            players.player1
        } else {
            turnOfFirstPlayer = true
            players.player2
        }

        player.ownColumn(col.keys.first())

        if (player.hasWinningCombo()) {
            player.incScore()
            updateScoreBoard()
            result = Result(false, player.name)
        } else if (!isMoveLeft()) {
            result = Result(true)
        }

        if (result != null) {
            enableBoard()
        }
    }

    fun startNewRound() {
        turnOfFirstPlayer = true

        resetBoard()

        players.player1.resetOwnedColumns()
        players.player2.resetOwnedColumns()

        result = null
    }

    private fun updateScoreBoard() {
        scoreBoard.score.text = "${players.player1.score} - ${players.player2.score}"
    }

    private fun enableBoard() {
        gameBoard.column.values.forEach {
            it.isEnabled = true
        }
    }

    private fun isMoveLeft(): Boolean {
        gameBoard.column.values.forEach {
            if (it.isEnabled) {
                return true
            }
        }

        return false
    }

    private fun resetPlayers() {
        players.player1.resetScore()
        players.player2.resetScore()

        players.player1.resetOwnedColumns()
        players.player2.resetOwnedColumns()
    }

    private fun resetBoard() {
        gameBoard.column.values.forEach {
            it.text = ""
        }
    }

    fun reset() {
        result = null
        resetBoard()
        enableBoard()
        resetPlayers()
        updateScoreBoard()
    }
}