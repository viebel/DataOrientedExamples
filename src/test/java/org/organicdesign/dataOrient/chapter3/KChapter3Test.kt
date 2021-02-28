package org.organicdesign.dataOrient.chapter3

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Kotlin version
 */
class KChapter3Test {
    @Test
    fun testBasics() {
        val watchmen = KBook("978-1779501127", "Watchmen", 1987)
        val alan = KAuthor("Alan Moore", mutableListOf(watchmen))
        val dave = KAuthor("Dave Gibbons", mutableListOf(watchmen))
        watchmen.authors.add(alan)
        watchmen.authors.add(dave)

        val rack17 = KRack("rack-17")
        watchmen.bookItems.add(KBookItem(watchmen, rack17, isLent = true))
        watchmen.bookItems.add(KBookItem(watchmen, rack17, isLent = false))

        val books = setOf(watchmen)

        // Note: functions in Kotlin are denoted with delimiters {}
        // These delimiters can replace the braces on a function if that function's only parameter is another function.
        // The default variable name (Like Clojure's $1) is `it`.
        assertEquals(watchmen,
                     books.find{ it.isbn == "978-1779501127" })

        assertEquals(listOf(alan, dave),
                     watchmen.authors)

        // Note: !! means "ignore a possible null return value"
        assertEquals(listOf(alan, dave),
                     books.find{ it.isbn == "978-1779501127" }!!.authors)

        assertEquals("Watchmen",
                     watchmen.title)

        assertEquals(watchmen,
                     books.find{ it.title.contains("Watch") })

        assertEquals("Watchmen",
                     books.find{ it.title == "Watchmen" }!!.title)
    }
}