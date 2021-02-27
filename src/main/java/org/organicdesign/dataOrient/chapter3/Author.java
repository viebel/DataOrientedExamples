package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple3;

public class Author extends Tuple3<String,String, ImList<String>> {
    Author(String id, String name, ImList<String> bookIsbns) {
        super(id, name, bookIsbns);
    }

    public String id() { return _1; }
    public String name() { return _2; }
    public ImList<String> bookIsbns() { return _3; }
}
