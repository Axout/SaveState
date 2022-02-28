package ru.axout.savestate.parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CounterState(
    val count: Int
): Parcelable
