package com.github.dakyskye.ticietacietoe.game.player

import com.github.dakyskye.ticietacietoe.game.column.Column
import com.github.dakyskye.ticietacietoe.game.column.WinningColumns

class Player(val name: String) {
    var score: Int = 0
        private set

    private var columns = ArrayList<Column>()

    fun ownColumn(column: Column) {
        columns.add(column)
    }

    fun resetScore() {
        score = 0
    }

    fun resetOwnedColumns() {
        columns = ArrayList()
    }

    fun hasWinningCombo(): Boolean {
        return WinningColumns.check(columns)
    }

    fun incScore() {
        score++
    }
}

data class Players(val player1: Player, val player2: Player)
