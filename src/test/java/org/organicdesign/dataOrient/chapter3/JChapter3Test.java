package org.organicdesign.dataOrient.chapter3;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.organicdesign.dataOrient.chapter3.PChapter3.*;
import static org.organicdesign.dataOrient.chapter3.PChapter3.pSearchBooksByTitle3;
import static org.organicdesign.fp.StaticImports.vec;

/**
 * 1990's Java version
 */
public class JChapter3Test {
    @Test
    public void testBasics() {
        var watchmen = Map.of("isbn", "978-1779501127",
                              "name", "Watchmen",
                              "publicationDate", 1987,
                              "authorIds", vec("alan-moore", "dave-gibbons"),
                              "bookItems", vec(new PBookItem("book-item-1", "rack-17", true),
                                               new PBookItem("book-item-2", "rack-17", false)));

        var alan = Map.of("id", "alan-moore",
                          "name", "Alan Moore",
                          "bookIds", vec("978-1779501127"));

        var dave = Map.of("id", "dave-gibbons",
                          "name", "Dave Gibbons",
                          "bookIds", vec("978-1779501127"));

        Map<String, Map<String, Object>> booksByIsbn = Map.of(
                (String) watchmen.get("isbn"), watchmen);

        Map<String, Map<String, Object>> authorsById = Map.of(
                (String) alan.get("id"), alan,
                (String) dave.get("id"), dave);

        Map<String, Map<String, Map<String, Object>>> catalog;
        catalog = Map.of("booksByIsbn", booksByIsbn,
                         "authorsById", authorsById);


//        assertEquals("Watchmen",
//                     catalog.get("booksByIsbn").get("978-1779501127").get("title"));

//        assertEquals(listOf("Alan Moore", "Dave Gibbons"),
//                     jAuthorNames(catalog, watchmen));
//
//        assertEquals("Watchmen",
//                     pSearchBooksByTitle(catalog, "Watch").get(0)._1());
//
//        assertEquals("Watchmen",
//                     pSearchBooksByTitle2(catalog, "Watch").get(0).title());
//
//        assertEquals("Watchmen",
//                     pSearchBooksByTitle3(catalog, "Watch").get(0).title());

    }
}
