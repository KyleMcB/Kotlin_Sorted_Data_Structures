import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

fun equalsList(list1: List<Any?>, list2: List<Any?>) {
    val iter1 = list1.iterator()
    val iter2 = list2.iterator()
    while (iter1.hasNext() || iter2.hasNext()) {
        assertEquals(iter1.next(), iter2.next())
    }
}

class SortedSetTest {
    val ss = SortedSet<Int>()

    @Test
    fun serialize() {
        ss.addAll(mutableListOf(3, 5, 1, 2, 4, 6))
        val json = Json.encodeToString(ss)
        val secondss = Json.decodeFromString<SortedSet<Int>>(json)
        equalsList(secondss, ss)
    }

    @Test
    fun sortedAfterAdd() {
        ss.add(5)
        ss.add(1)
        equalsList(listOf(1, 5), ss)
    }

    @Test
    fun sortedAfterAddAll() {
        ss.addAll(mutableListOf<Int>().apply { repeat(100) { add((0..1000).random()) } })
        equalsList(ss.sorted(), ss)
    }

    @Test
    fun uniqueElementsOnly() {
        ss.add(5)
        ss.add(5)
        assertEquals(1, ss.size, "adding the same element twice only applies once")
    }
}

interface Thing : Comparable<Thing> {
    val i: Int
}

class A : Thing {
    override val i: Int
        get() = 8

    /**
     * Compares this object with the specified object for order. Returns zero if this object is
     * equal to the specified [other] object, a negative number if it's less than [other], or a
     * positive number if it's greater than [other].
     */
    override fun compareTo(other: Thing): Int {
        return i.compareTo(other.i)
    }
}

class varianceTest {
    @Test
    fun variance() {
        val ss = SortedSet<Thing>()
        ss.add(A())
        ss.add(A())
        assertEquals(8, ss[0].i)
    }
}
