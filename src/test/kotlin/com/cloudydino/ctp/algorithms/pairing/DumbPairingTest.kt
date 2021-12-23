package com.cloudydino.ctp.algorithms.pairing

import com.cloudydino.ctp.models.Match
import com.cloudydino.ctp.models.Player
import com.cloudydino.ctp.models.Section
import org.junit.Test

import org.junit.Assert.*

class DumbPairingTest {

    @Test
    fun `pairing 0 players returns empty round`() {
        val round = DumbPairing.pair(Section(emptyList(), emptyList()))
        assertTrue(round.matches.isEmpty())
        assertTrue(round.requestedByePlayerIds.isEmpty())
        assertTrue(round.forcedByePlayerIds.isEmpty())
    }

    @Test
    fun `pair with 1 player returns single forced bye`() {
        val player = Player("id1", null, emptyList())
        val round = DumbPairing.pair(Section(listOf(player), emptyList()))
        assertTrue(round.matches.isEmpty())
        assertTrue(round.requestedByePlayerIds.isEmpty())
        assertEquals(1, round.forcedByePlayerIds.size)
        assertEquals("id1", round.forcedByePlayerIds.first())
    }

    @Test
    fun `pair with 5 players pairs 4 highest rated and forces bye for lowest rated`() {
        val player2500 = Player("id2500", 2500, emptyList())
        val player2000 = Player("id2000", 2000, emptyList())
        val player1500 = Player("id1500", 1500, emptyList())
        val player1000 = Player("id1000", 1000, emptyList())
        val player500 = Player("id500", 500, emptyList())
        val round =
            DumbPairing.pair(Section(listOf(player1500, player2000, player500, player2500, player1000), emptyList()))
        assertEquals(
            listOf(
                Match(player2500, player2000),
                Match(player1500, player1000)
            ), round.matches
        )
        assertTrue(round.requestedByePlayerIds.isEmpty())
        assertEquals(1, round.forcedByePlayerIds.size)
        assertEquals(player500.id, round.forcedByePlayerIds.first())
    }
}