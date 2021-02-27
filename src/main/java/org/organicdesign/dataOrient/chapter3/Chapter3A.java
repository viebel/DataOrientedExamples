package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple3;

import java.util.Map;

import static org.organicdesign.fp.StaticImports.tup;

class Chapter3A {

    public static ImList<String> authorNames(Catalog catalogData, Book book) {
        var authorIds = book.authorIds();
        return authorIds.map(authorId -> catalogData.authorsById()
                                                    .get(authorId)
                                                    .name())
                        .toImList();
    }

    public static Tuple3<String,String,ImList<String>> bookInfo(Catalog catalogData, Book book) {
        return tup(book.title(), book.isbn(), authorNames(catalogData, book));
    }

    public static BookInfo bookInfo2(Catalog catalogData, Book book) {
        return new BookInfo(book.title(), book.isbn(), authorNames(catalogData, book));
    }

    public static ImList<Tuple3<String,String,ImList<String>>> searchBooksByTitle(Catalog catalogData, String query) {
        var allBooks = catalogData.booksByIsbn();
        var matchingBooks = allBooks.filter(kv -> kv.getValue()
                                                    .title()
                                                    .contains(query));
        return matchingBooks.map(kv -> bookInfo(catalogData, kv.getValue())).toImList();
    }

    public static ImList<BookInfo> searchBooksByTitle2(Catalog catalogData, String query) {
        var allBooks = catalogData.booksByIsbn();
        var matchingBooks = allBooks.filter(kv -> kv.getValue()
                                                    .title()
                                                    .contains(query));
        return matchingBooks.map(kv -> bookInfo2(catalogData, kv.getValue())).toImList();
    }

    public static ImList<BookInfo> searchBooksByTitle3(Catalog catalogData, String query) {
        return catalogData.booksByIsbn()
                          .map(Map.Entry::getValue)
                          .filter(book -> book
                                          .title()
                                          .contains(query))
                          .map(book -> bookInfo2(catalogData, book)).toImList();
    }
}
