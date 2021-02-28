package org.organicdesign.dataOrient.chapter3;

import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.tuple.Tuple3;

public class PBookInfo extends Tuple3<String,String, ImList<String>> {
    protected PBookInfo(String title, String isbn, ImList<String> authorNames) {
        super(title, isbn, authorNames);
    }
    public String title() { return _1; }
    public String isbn() { return _2; }
    public ImList<String> authorNames() { return _3; }
}
