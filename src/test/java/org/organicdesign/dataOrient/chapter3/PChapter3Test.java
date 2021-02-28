package org.organicdesign.dataOrient.chapter3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.organicdesign.dataOrient.chapter3.PChapter3.*;
import static org.organicdesign.fp.StaticImports.*;

/**
 * Paguro version
 */
public class PChapter3Test {
    @Test
    public void testChapter3A() {
        var watchmen = new PBook("978-1779501127",
                                 "Watchmen",
                                 1987,
                                 vec("alan-moore", "dave-gibbons"),
                                 vec(new PBookItem("book-item-1", "rack-17", true),
                                    new PBookItem("book-item-2", "rack-17", false)));

        var alanMoore = new PAuthor("alan-moore", "Alan Moore", vec("978-1779501127"));
        var daveGibbons = new PAuthor("dave-gibbons", "Dave Gibbons", vec("978-1779501127"));


        var booksByIsbn = map(tup("978-1779501127", watchmen));

        var authorsById = map(tup(alanMoore.id(), alanMoore),
                              tup(daveGibbons.id(), daveGibbons));

        var catalog = new PCatalog(booksByIsbn, authorsById);

        assertEquals("Watchmen",
                     catalog.booksByIsbn().get("978-1779501127").title());

        assertEquals(vec("Alan Moore", "Dave Gibbons"),
                     pAuthorNames(catalog, watchmen));

        assertEquals("Watchmen",
                     pSearchBooksByTitle(catalog, "Watch").get(0)._1());

        assertEquals("Watchmen",
                     pSearchBooksByTitle2(catalog, "Watch").get(0).title());

        assertEquals("Watchmen",
                     pSearchBooksByTitle3(catalog, "Watch").get(0).title());

    }

}