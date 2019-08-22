package com.ceosilvajr.starwars.extensions

import java.text.NumberFormat
import java.util.*

fun Double.toMoney() = NumberFormat.getCurrencyInstance(Locale.US).format(this) ?: "-"