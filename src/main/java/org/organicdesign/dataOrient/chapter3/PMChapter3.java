package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;

import java.util.Map;

class PMChapter3 {

    public static ImList<String> pAuthorNames(ImMap<String,ImMap<String,ImMap<String,Object>>> catalogData, Map book) { 
        var authorIds = (ImList<String>)book.get("authorIds");
        return authorIds.map(authorId -> (String)catalogData.get("authorsById")
                                                    .get(authorId)
                                                    .get("name"))
          .toImList();
    }

    public static Map pBookInfo(ImMap<String,ImMap<String,ImMap<String,Object>>> catalogData, Map book) {
        return map(tup("title", book.get("title")),
                   tup("isbn", book.get("isbn")),
                   tup("authorNames", pAuthorNames(catalogData, book)));
    }


    public static ImList<Tuple3<String,String,ImList<String>>> pSearchBooksByTitle(ImMap<String,ImMap<String,ImMap<String,Object>>> catalogData, String query) {
        var allBooks = catalogData.get("booksByIsbn");
        var matchingBooks = allBooks.filter(kv -> kv.getValue()
                                                    .title()
                                                    .contains(query));
        return matchingBooks.map(kv -> pBookInfo(catalogData, kv.getValue())).toImList();
    }

    public static ImList<PBookInfo> pSearchBooksByTitle2(PCatalog catalogData, String query) {
        var allBooks = catalogData.booksByIsbn();
        var matchingBooks = allBooks.filter(kv -> kv.getValue()
                                                    .title()
                                                    .contains(query));
        return matchingBooks.map(kv -> pBookInfo2(catalogData, kv.getValue())).toImList();
    }

    public static ImList<PBookInfo> pSearchBooksByTitle3(PCatalog catalogData, String query) {
        return catalogData.booksByIsbn()
                          .map(Map.Entry::getValue)
                          .filter(book -> book
                                          .title()
                                          .contains(query))
                          .map(book -> pBookInfo2(catalogData, book)).toImList();
    }
}
