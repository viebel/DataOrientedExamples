package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.collections.ImMap;


import java.util.Map;

class PMChapter3 {
    public static ImList<String> pAuthorNames(ImMap catalogData,
                                              ImMap book) { 
        var authorIds = (ImList<String>)book.get("authorIds");
        var authorByIds = (ImMap<String,ImMap>)catalogData.get("authorsById");
        return authorIds.map(authorId -> (String)authorByIds.get(authorId).get("name")).toImList();
    }

    public static Map pBookInfo(ImMap<String,ImMap<String,ImMap<String,Object>>> catalogData, Map book) {
        return map(tup("title", book.get("title")),
                   tup("isbn", book.get("isbn")),
                   tup("authorNames", pAuthorNames(catalogData, book)));
    }


    public static ImList<Tuple3<String,String,ImList<String>>> pSearchBooksByTitle(ImMap<String,ImMap<String,ImMap<String,Object>>> catalogData, String query) {
        var allBooks = catalogData.get("booksByIsbn");
        var matchingBooks = allBooks.filter(kv -> ((String)kv.getValue()
                                                    .get("title"))
                                                    .contains(query));
        return matchingBooks.map(kv -> pBookInfo(catalogData, kv.getValue())).toImList();
    }
}
