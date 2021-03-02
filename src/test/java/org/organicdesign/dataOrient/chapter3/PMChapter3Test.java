
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
        var catalog = map(tup("booksByIsbn", map(
                                 tup("978-1779501127", map(
                                     tup("isbn", "978-1779501127"),
                                     tup("title", "Watchmen"),
                                     tup("publicationYear", 1987),
                                     tup("authorIds", vec("alan-moore", "dave-gibbons")))))),
                          tup("authorsById", map(
                              tup("alan-moore", map(
                                  tup("name", "Alan Moore"),
                                  tup("bookIsbns", vec("978-1779501127")))),
                              tup("dave-gibbons", map(
                                  tup("name", "Dave Gibbons"),
                                  tup("bookIsbns", vec("978-1779501127")))))));

        var expectedResult = vec(map(tup("isbn", "978-1779501127"),
                                     tup("title", "Watchmen"),
                                    tup("authorNames", vec("Alan Moore", "Dave Gibbons"))));
        
        assertEquals(expectedResult,
                     pSearchBooksByTitle(catalog, "Watch"));

    }
}
