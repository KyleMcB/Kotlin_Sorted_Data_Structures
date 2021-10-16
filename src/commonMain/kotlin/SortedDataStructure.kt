import kotlinx.serialization.Serializable

@Serializable
class SortedList<T : Comparable<T>>() : MutableList<T> {
    private val list: MutableList<T> = mutableListOf()
    init {
        list.sort()
    }

    override fun add(element: T): Boolean {
        val index = list.binarySearch(element)
        if (index < 0) {
            val posIndex = -(index + 1)
            list.add(posIndex, element)
        } else {
            list.add(index, element)
        }
        return true
    }

    override fun indexOf(element: T): Int {
        val loc = list.binarySearch(element)
        return if (loc < 0) -1 else loc
    }

    override fun addAll(elements: Collection<T>): Boolean {
        var result = false
        val myList = this
        elements.forEach { if (myList.add(it)) result = true }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        val result = list.retainAll(elements)
        list.sort()
        return result
    }

    override fun remove(element: T): Boolean {
        val index = binarySearch(element)
        return if (index < 0) false
        else {
            list.removeAt(index)
            true
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @return the element previously at the specified position.
     */
    @Deprecated("not compatible with sortlist")
    override fun set(index: Int, element: T): T {
        val removed = list.removeAt(index)
        list.add(element)
        return removed
    }

    override val size: Int
        get() = list.size

    override fun contains(element: T): Boolean {
        return list.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return list.containsAll(elements)
    }

    /** Returns the element at the specified index in the list. */
    override fun get(index: Int): T {
        return list.get(index)
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun iterator(): MutableIterator<T> {
        return list.iterator()
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the
     * specified element is not contained in the list.
     */
    override fun lastIndexOf(element: T): Int {
        return list.lastIndexOf(element)
    }

    /** Inserts an element into the list at the specified [index]. */
    @Deprecated("can not keep list sorted if inserted at specific location")
    override fun add(index: Int, element: T) {
        list.add(element)
    }

    /**
     * Inserts all of the elements of the specified collection [elements] into this list at the
     * specified [index].
     *
     * @return `true` if the list was changed as the result of the operation.
     */
    @Deprecated("can not add to specific location")
    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        val result = list.addAll(elements)
        return result
    }

    override fun clear() {
        return list.clear()
    }

    override fun listIterator(): MutableListIterator<T> {
        return list.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        return list.listIterator(index)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return list.removeAll(elements)
    }

    /**
     * Removes an element at the specified [index] from the list.
     *
     * @return the element that has been removed.
     */
    override fun removeAt(index: Int): T {
        return list.removeAt(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return list.subList(fromIndex, toIndex)
    }
}

@Serializable
class SortedSet<T : Comparable<T>>() : MutableList<T> {
    private val list: MutableList<T> = mutableListOf()
    init {
        list.sort()
    }

    override fun add(element: T): Boolean {
        val index = list.binarySearch(element)
        return if (index < 0) {
            val posIndex = -(index + 1)
            list.add(posIndex, element)
            true
        } else false
    }

    override fun indexOf(element: T): Int {
        val loc = list.binarySearch(element)
        return if (loc < 0) -1 else loc
    }

    override fun addAll(elements: Collection<T>): Boolean {
        var result = false
        val myList = this
        elements.forEach { if (myList.add(it)) result = true }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        val result = list.retainAll(elements)
        list.sort()
        return result
    }

    override fun remove(element: T): Boolean {
        val index = binarySearch(element)
        return if (index < 0) false
        else {
            list.removeAt(index)
            true
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @return the element previously at the specified position.
     */
    @Deprecated("not compatible with a sorted set")
    override fun set(index: Int, element: T): T {
        val removed = list.removeAt(index)
        list.add(element)
        return removed
    }

    override val size: Int
        get() = list.size

    override fun contains(element: T): Boolean {
        return list.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return list.containsAll(elements)
    }

    /** Returns the element at the specified index in the list. */
    override fun get(index: Int): T {
        return list[index]
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun iterator(): MutableIterator<T> {
        return list.iterator()
    }

    /**
     * Returns the index of the last occurrence of the specified element in the list, or -1 if the
     * specified element is not contained in the list.
     */
    override fun lastIndexOf(element: T): Int {
        return lastIndexOf(element)
    }

    /** Inserts an element into the list at the specified [index]. */
    @Deprecated("not compatible with a sorted list")
    override fun add(index: Int, element: T) {
        list.add(element)
    }

    /**
     * Inserts all of the elements of the specified collection [elements] into this list at the
     * specified [index].
     *
     * @return `true` if the list was changed as the result of the operation.
     */
    @Deprecated("not compatible with a sorted list")
    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        return list.addAll(elements)
    }

    override fun clear() {
        return list.clear()
    }

    override fun listIterator(): MutableListIterator<T> {
        return list.listIterator()
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        return list.listIterator(index)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return list.removeAll(elements)
    }

    /**
     * Removes an element at the specified [index] from the list.
     *
     * @return the element that has been removed.
     */
    override fun removeAt(index: Int): T {
        return list.removeAt(index)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return list.subList(fromIndex, toIndex)
    }
}
