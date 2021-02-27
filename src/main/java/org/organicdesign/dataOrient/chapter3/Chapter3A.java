package org.organicdesign.dataOrient.chapter3;

import static org.organicdesign.fp.StaticImports.vec;

class Chapter3A {
    public static void foo() {
        var watchmenBook = new Book("978-1779501127",
                                    "Watchmen",
                                    1987,
                                    vec("alan-moore", "dave-gibbons"),
                                    vec(new BookItem("book-item-1", "rack-17", true),
                                        new BookItem("book-item-2", "rack-17", false)));
    }
}
