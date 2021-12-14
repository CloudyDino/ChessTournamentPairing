package models

data class Match(
    val white: Player,
    val black: Player,
    val result: MatchResult?
)
