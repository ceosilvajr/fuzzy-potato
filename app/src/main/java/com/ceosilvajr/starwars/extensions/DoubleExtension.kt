package com.ceosilvajr.starwars.extensions

import java.text.NumberFormat
import java.util.*

/**
 * converts double to money
 */
fun Double.toMoney() = NumberFormat.getCurrencyInstance(Locale.US).format(this) ?: "-"