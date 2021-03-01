package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple3;
import org.organicdesign.fp.tuple.Tuple5;
import com.google.gson.annotations.Expose;

import java.util.Map;

import static org.organicdesign.fp.StaticImports.tup;

public class PBookItem extends Tuple3<String, String, Boolean> {
    public PBookItem(String _id, String _rackId, Boolean _isLent) {
        super(_id, _rackId, _isLent);
        id = _id;
        rackId = _rackId;
        isLent = _isLent;
    }
    @Expose
    public String id;
    @Expose
    public String rackId;
    @Expose
    public Boolean isLent;
}

public class PBook extends Tuple5<String,String,Number, ImList<String>, ImList<PBookItem>> {
    PBook(String isbn, String title, Number publicationYear, ImList<String> authorIds, ImList<PBookItem> bookItems) {
        super(isbn, title, publicationYear, authorIds, bookItems);
    }
    public String isbn() { return _1; }
    public String title() { return _2; }
    public Number publicationYear() { return _3; }
    public ImList<String> authorIds() { return _4; }
    public ImList<PBookItem> bookItems() { return _5; }
}

public class PAuthor extends Tuple3<String,String, ImList<String>> {
    PAuthor(String id, String name, ImList<String> bookIsbns) {
        super(id, name, bookIsbns);
    }

    public String id() { return _1; }
    public String name() { return _2; }
    public ImList<String> bookIsbns() { return _3; }
}

public class PBookInfo extends Tuple3<String,String, ImList<String>> {
    protected PBookInfo(String title, String isbn, ImList<String> authorNames) {
        super(title, isbn, authorNames);
    }
    public String title() { return _1; }
    public String isbn() { return _2; }
    public ImList<String> authorNames() { return _3; }
}


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
