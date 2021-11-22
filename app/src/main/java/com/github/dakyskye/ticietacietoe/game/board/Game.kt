package com.github.dakyskye.ticietacietoe.game.board

import com.github.dakyskye.ticietacietoe.game.column.BoardColumn
import com.github.dakyskye.ticietacietoe.game.column.Column

data class GameBoard(
    private val top: BoardColumn,
    private val middle: BoardColumn,
    private val bottom: BoardColumn
) {
    val column = hashMapOf(
        Column.TOP_LEFT to top.columnLeft,
        Column.TOP_CENTRE to top.columnCentre,
        Column.TOP_RIGHT to top.columnRight,

        Column.MIDDLE_LEFT to middle.columnLeft,
        Column.MIDDLE_CENTRE to middle.columnCentre,
        Column.MIDDLE_RIGHT to middle.columnRight,

        Column.BOTTOM_LEFT to bottom.columnLeft,
        Column.BOTTOM_CENTRE to bottom.columnCentre,
        Column.BOTTOM_RIGHT to bottom.columnRight,
    )
}

