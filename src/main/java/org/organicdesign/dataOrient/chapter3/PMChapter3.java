package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.collections.ImMap;

class PMChapter3 {
    public static ImList<String> pAuthorNames(ImMap catalogData,
                                              ImMap book) { 
        var authorIds = (ImList<String>)book.get("authorIds");
        var authorByIds = (ImMap<String,ImMap>)catalogData.get("authorsById");
        return authorIds.map(authorId -> (String)authorByIds.get(authorId).get("name")).toImList();
    }

    public static ImMap pBookInfo(ImMap catalogData, ImMap book) {
        return map(tup("title", book.get("title")),
                   tup("isbn", book.get("isbn")),
                   tup("authorNames", pAuthorNames(catalogData, book)));
    }

    public static ImList<ImMap> pSearchBooksByTitle(ImMap catalogData, String query) {
        var allBooksMap = (ImMap<String,ImMap>)catalogData.get("booksByIsbn");
        var allBooks = allBooksMap.values().toImList();
        return allBooks.filter(book -> ((String)book.get("title"))
                                                    .contains(query)).map(book -> pBookInfo(catalogData, book)).toImList();
    }
}
