package algorithms.pairing

import models.Round
import models.Section

/**
 * A dumb pairing algorithm for example purposes.
 */
object DumbPairing: PairingAlgorithm {

    /**
     * Pairs the top two players by rating, then next two, then next two, and so on with the higher rated getting white.
     * Doesn't care about previous rounds or if a player has requested a bye.
     */
    override fun pair(section: Section): Round {
        TODO("Not yet implemented")
    }
}
