package org.organicdesign.dataOrient.chapter3


class KAuthor(
        val name: String,
        val books: MutableList<KBook> = mutableListOf()
)

class KBook(
        val isbn: String,
        val title: String,
        val publicationYear: Int,
        val authors: MutableList<KAuthor> = mutableListOf(),
        val bookItems: MutableList<KBookItem> = mutableListOf()
)

class KRack(
        val name: String,
        val books: MutableList<KBook> = mutableListOf()
)

class KBookItem(
        val book: KBook,
        val rack: KRack,
        val isLent: Boolean
)