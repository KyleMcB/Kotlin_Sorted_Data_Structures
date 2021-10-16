/*
 * Copyright (c) 2021. Kyle McBurnett
 */

import kotlin.test.*

class EmptySetTest {
    val ss = SortedSet<Int>()
    @Test
    fun size() {
        assertTrue(ss.size == 0, "empty set should be size 0")
    }
    @Test
    fun contains() {
        assertFalse("empty set should not contain a value") { ss.contains(5) }
    }
    @Test
    fun containsAll() {
        assertFalse { ss.containsAll(listOf(3, 2)) }
    }

    @Test
    fun get() {
        assertFails {
            val test = ss[0]
            test.dec()
        }
    }
    @Test
    fun indexOf() {
        assertEquals(-1, ss.indexOf(6), "should return -1 if element is missing")
    }
}
