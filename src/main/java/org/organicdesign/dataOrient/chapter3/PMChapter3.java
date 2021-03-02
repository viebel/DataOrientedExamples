package org.organicdesign.dataOrient.pmchapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.collections.ImMap;
import com.google.gson.Gson;

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
        return ((ImMap<String,ImMap>)catalogData.get("booksByIsbn"))
            .values()
            .filter(book -> ((String)book.get("title")).contains(query))
            .map(book -> pBookInfo(catalogData, book))
            .toImList();
    }

    public static String pSearchBooksByTitleJSON(ImMap libraryData, String query) {
        var books = pSearchBooksByTitle((ImMap)libraryData.get("catalog"), query);
        return new Gson().toJson(books);
    }
}
