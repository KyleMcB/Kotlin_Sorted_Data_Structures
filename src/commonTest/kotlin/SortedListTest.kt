/*
 * Copyright (c) 2021. Kyle McBurnett
 */

import kotlin.test.Test

class SortedListTest {
    @Test
    fun staysSorted() {
        val sl = SortedList<Int>()
        sl.add(5)
        sl.add(2)
        sl.add(8)
        equalsList(sl.sorted(), sl)
    }

    @Test
    fun retainAll() {
        val sl = SortedList<Int>()
        repeat(10) { sl.add(it) }
        sl.retainAll(listOf(2, 3, 4))
        equalsList(sl, listOf(2, 3, 4))
    }
}
