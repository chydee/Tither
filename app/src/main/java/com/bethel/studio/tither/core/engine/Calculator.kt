package com.bethel.studio.tither.core.engine

object Calculator {
    fun compute(amount: Long): Long {
        val percentage: Double = 10.0 / 100.0
        val titheable = amount * percentage
        return 0L
    }
}