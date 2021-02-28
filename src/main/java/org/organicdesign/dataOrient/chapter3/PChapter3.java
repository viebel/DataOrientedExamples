package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple3;

import java.util.Map;

import static org.organicdesign.fp.StaticImports.tup;

class PChapter3 {

    public static ImList<String> pAuthorNames(PCatalog catalogData, PBook book) {
        var authorIds = book.authorIds();
        return authorIds.map(authorId -> catalogData.authorsById()
                                                    .get(authorId)
                                                    .name())
                        .toImList();
    }

    public static Tuple3<String,String,ImList<String>> pBookInfo(PCatalog catalogData, PBook book) {
        return tup(book.title(), book.isbn(), pAuthorNames(catalogData, book));
    }

    public static PBookInfo pBookInfo2(PCatalog catalogData, PBook book) {
        return new PBookInfo(book.title(), book.isbn(), pAuthorNames(catalogData, book));
    }

    public static ImList<Tuple3<String,String,ImList<String>>> pSearchBooksByTitle(PCatalog catalogData, String query) {
        var allBooks = catalogData.booksByIsbn();
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
