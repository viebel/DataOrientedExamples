package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.tuple.Tuple3;

public class BookItem extends Tuple3<String, String, Boolean> {
    public BookItem(String id, String rackId, Boolean isLent) {
        super(id, rackId, isLent);
    }
    public String id() { return _1; }
    public String rackId() { return _2; }
    public Boolean isLent() { return _3; }
}
