package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple5;

public class Book extends Tuple5<String,String,Number, ImList<String>, ImList<BookItem>> {
    Book(String isbn, String title, Number publicationYear, ImList<String> authorIds, ImList<BookItem> bookItems) {
        super(isbn, title, publicationYear, authorIds, bookItems);
    }
    public String isbn() { return _1; }
    public String title() { return _2; }
    public Number publicationYear() { return _3; }
    public ImList<String> authorIds() { return _4; }
    public ImList<BookItem> bookItems() { return _5; }
}