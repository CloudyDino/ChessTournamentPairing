package com.cloudydino.ctp.algorithms.pairing

import com.cloudydino.ctp.models.Round
import com.cloudydino.ctp.models.Section

interface PairingAlgorithm {
    fun pair(section: Section): Round
}
