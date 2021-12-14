package algorithms.pairing

import models.Round
import models.Section

interface PairingAlgorithm {
    fun pair(section: Section): Round
}
