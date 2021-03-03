package org.organicdesign.dataOrient.pmchapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.collections.ImMap;
import com.google.gson.Gson;

public class UniversalGet {
    // TODO: move to methods in ImMap and ImList
    // TODO: getInAs...
    // TODO: getAsNumber, ...
    public Integer getAsInteger(Map o, Object k) {
        return (Integer)o.get((String)k);
    }

    public String getAsString(Map o, Object k) {
        return (String)o.get((String)k);
    }

    public Boolean getAsBoolean(Map o, Object k) {
        return (Boolean)o.get((String)k);
    }

    public ImMap getAsMap(Map o, Object k) {
        return (ImMap)o.get((String)k);
    }

    public ImMap<String, ImMap> getAsMapOfMaps(ImMap o, Object k) {
        return (ImMap<String,ImMap>)o.get((String)k);
    }

    public ImList getAsList(Map o, Object k) {
        return (ImList)o.get((String)k);
    }
}

class PMChapter3 {
    @SuppressWarnings("unchecked")
    public static ImList<String> pAuthorNames(ImMap catalogData,
                                              ImMap book) {
        var authorIds = getAsList(book, "authorIds");
        var authorByIds = getAsMap(catalogData, "authorsById");
        return authorIds.map(authorId -> getAsMap(authorByIds, authorId).get("name")).toImList();
    }

    @SuppressWarnings("unchecked")
    public static ImMap pBookInfo(ImMap catalogData, ImMap book) {
        return map(tup("title", book.get("title")),
                   tup("isbn", book.get("isbn")),
                   tup("authorNames", pAuthorNames(catalogData, book)));
    }

    @SuppressWarnings("unchecked")
    public static ImList<ImMap> pSearchBooksByTitle(ImMap catalogData, String query) {
        return getAsMapOfMaps(catalogData, "booksByIsbn")
            .values()
            .filter(book -> getAsString(book, "title").contains(query))
            .map(book -> pBookInfo(catalogData, book))
            .toImList();
    }

    @SuppressWarnings("unchecked")
    public static String pSearchBooksByTitleJSON(ImMap libraryData, String query) {
        var books = pSearchBooksByTitle(getAsMap(libraryData, "catalog"), query);
        return new Gson().toJson(books);
    }
}
