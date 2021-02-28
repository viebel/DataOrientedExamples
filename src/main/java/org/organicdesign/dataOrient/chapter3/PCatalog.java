package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImMap;
import org.organicdesign.fp.tuple.Tuple2;

public class PCatalog extends Tuple2<ImMap<String, PBook>, ImMap<String, PAuthor>> {
    protected PCatalog(ImMap<String, PBook> booksByIsbn, ImMap<String, PAuthor> authorsById) {
        super(booksByIsbn, authorsById);
    }

    public ImMap<String, PBook> booksByIsbn() { return _1; }
    public ImMap<String, PAuthor> authorsById() { return _2; }
}
