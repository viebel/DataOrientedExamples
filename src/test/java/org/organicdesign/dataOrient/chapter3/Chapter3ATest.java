package org.organicdesign.dataOrient.chapter3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.organicdesign.dataOrient.chapter3.Chapter3A.*;
import static org.organicdesign.fp.StaticImports.*;

public class Chapter3ATest {
    @Test
    public void testChapter3A() {
        var watchmen = new Book("978-1779501127",
                                "Watchmen",
                                1987,
                                vec("alan-moore", "dave-gibbons"),
                                vec(new BookItem("book-item-1", "rack-17", true),
                                    new BookItem("book-item-2", "rack-17", false)));

        var alanMoore = new Author("alan-moore", "Alan Moore", vec("978-1779501127"));
        var daveGibbons = new Author("dave-gibbons", "Dave Gibbons", vec("978-1779501127"));


        var booksByIsbn = map(tup("978-1779501127", watchmen));

        var authorsById = map(tup(alanMoore.id(), alanMoore),
                              tup(daveGibbons.id(), daveGibbons));

        var catalog = new Catalog(booksByIsbn, authorsById);

        assertEquals("Watchmen",
                     catalog.booksByIsbn().get("978-1779501127").title());

        assertEquals(vec("Alan Moore", "Dave Gibbons"),
                     authorNames(catalog, watchmen));

        assertEquals("Watchmen",
                     searchBooksByTitle(catalog, "Watch").get(0)._1());

        assertEquals("Watchmen",
                     searchBooksByTitle2(catalog, "Watch").get(0).title());

        assertEquals("Watchmen",
                     searchBooksByTitle3(catalog, "Watch").get(0).title());

    }

}