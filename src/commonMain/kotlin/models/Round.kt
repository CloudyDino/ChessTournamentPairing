package models

data class Round(
    val matches: List<Match>,
    val requestedByePlayerIds: List<String>,
    val forcedByePlayerIds: List<String>,
)
