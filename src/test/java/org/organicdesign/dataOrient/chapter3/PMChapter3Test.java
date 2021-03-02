
package org.organicdesign.dataOrient.chapter3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.organicdesign.dataOrient.chapter3.PMChapter3.*;
import static org.organicdesign.fp.StaticImports.*;

/**
 * Paguro version
 */
public class PMChapter3Test {
    @Test
    public void testChapter3A() {
        var watchmen = map(tup("isbn", "978-1779501127"),
                           tup("title", "Watchmen"),
                           tup("publicationYear", 1987),
                           tup("authorIds", vec("alan-moore", "dave-gibbons")));

        var alanMoore = map(tup("name", "Alan Moore"),
                            tup("bookIsbns", vec("978-1779501127")));
        var daveGibbons = map(tup("name", "Dave Gibbons"),
                            tup("bookIsbns", vec("978-1779501127")));

        var booksByIsbn = map(tup("978-1779501127", watchmen));

        var authorsById = map(tup("alan-moore", alanMoore),
                              tup("dave-gibbons", daveGibbons));

        var catalog = map(tup("booksByIsbn", booksByIsbn),
                          tup("authorsById", authorsById));

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
