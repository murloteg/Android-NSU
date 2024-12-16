package ru.nsu.bolotov.currencyconverter.model

data class NameAndCurrency(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Map<String, Currency>
)
