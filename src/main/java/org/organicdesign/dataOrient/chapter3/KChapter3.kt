package org.organicdesign.dataOrient.chapter3


data class KAuthor(
        val name: String,
        val books: MutableList<KBook> = mutableListOf()
)

data class KBook(
        val isbn: String,
        val title: String,
        val publicationYear: Int,
        val authors: MutableList<KAuthor> = mutableListOf(),
        val bookItems: MutableList<KBookItem> = mutableListOf()
)

data class KRack(
        val name: String,
        val books: MutableList<KBook> = mutableListOf()
)

data class KBookItem(
        val book: KBook,
        val rack: KRack,
        val isLent: Boolean
)