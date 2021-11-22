package com.github.dakyskye.ticietacietoe.game.column

sealed class WinningColumns {
    companion object {
        private val winningColumns = arrayListOf(
            arrayListOf(Column.TOP_LEFT, Column.TOP_CENTRE, Column.TOP_RIGHT),
            arrayListOf(Column.MIDDLE_LEFT, Column.MIDDLE_CENTRE, Column.MIDDLE_RIGHT),
            arrayListOf(Column.BOTTOM_LEFT, Column.BOTTOM_CENTRE, Column.BOTTOM_RIGHT),

            arrayListOf(Column.TOP_LEFT, Column.MIDDLE_LEFT, Column.BOTTOM_LEFT),
            arrayListOf(Column.TOP_CENTRE, Column.MIDDLE_CENTRE, Column.BOTTOM_CENTRE),
            arrayListOf(Column.TOP_RIGHT, Column.MIDDLE_RIGHT, Column.BOTTOM_RIGHT),

            arrayListOf(Column.TOP_LEFT, Column.MIDDLE_CENTRE, Column.BOTTOM_RIGHT),
            arrayListOf(Column.BOTTOM_LEFT, Column.MIDDLE_CENTRE, Column.TOP_RIGHT)
        )

        fun check(columns: ArrayList<Column>): Boolean {
            winningColumns.forEach {
                if (columns.containsAll(it)) {
                    return true
                }
            }

            return false
        }
    }

}