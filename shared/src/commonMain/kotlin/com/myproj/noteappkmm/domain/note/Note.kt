package com.myproj.noteappkmm.domain.note

import com.myproj.noteappkmm.presentation.BabyBlueHex
import com.myproj.noteappkmm.presentation.LightGreenHex
import com.myproj.noteappkmm.presentation.RedOrangeHex
import com.myproj.noteappkmm.presentation.RedPinkHex
import com.myproj.noteappkmm.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, LightGreenHex, BabyBlueHex, VioletHex)

        fun generateRandomColor() = colors.random()
    }
}
