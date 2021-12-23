package com.cloudydino.ctp.algorithms.pairing

import com.cloudydino.ctp.algorithms.pairing.PairingAlgorithm
import com.cloudydino.ctp.models.Match
import com.cloudydino.ctp.models.Player
import com.cloudydino.ctp.models.Round
import com.cloudydino.ctp.models.Section

/**
 * A dumb pairing algorithm for example purposes.
 */
object DumbPairing : PairingAlgorithm {

    /**
     * Pairs the top two players by rating, then next two, then next two, and so on with the higher rated getting white.
     * Doesn't care about previous rounds or if a player has requested a bye.
     */
    override fun pair(section: Section): Round {
        val sortedPlayers = section.players.sortedByDescending { it.rating }
        return Round(
            sortedPlayers
                .zipWithNext()
                .filterIndexed { index, _ -> index % 2 == 0 }
                .map { pair: Pair<Player, Player> -> Match(pair.first, pair.second) },
            emptyList(),
            if (sortedPlayers.size % 2 == 0) emptyList() else listOf(sortedPlayers.last().id),
        )
    }
}
