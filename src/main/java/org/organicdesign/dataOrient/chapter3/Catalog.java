package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImMap;
import org.organicdesign.fp.tuple.Tuple2;

public class Catalog extends Tuple2<ImMap<String,Book>, ImMap<String,Author>> {
    protected Catalog(ImMap<String, Book> booksByIsbn, ImMap<String, Author> authorsById) {
        super(booksByIsbn, authorsById);
    }

    public ImMap<String, Book> booksByIsbn() { return _1; }
    public ImMap<String, Author> authorsById() { return _2; }
}
