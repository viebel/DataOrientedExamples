package org.organicdesign.dataOrient.chapter3;

public class JChapter3 {
//    public static List<Map<String,Object>> jAuthorNames(Map<String, Map<String, Object>> catalogData, Map<String,Object> book) {
//        var authorIds = (List<String>) book.get("authorIds");
//        return authorIds.stream()
//                        .map(authorId -> {
//                            var author = catalogData.get("authorsById");
//                            return Map.of("authorId", author.get("authorId"),
//                                          "name", author.get("name"));
//                        })
//                        .collect(Collectors.toUnmodifiableList());
//    }
//
//    public static Map<String,Object> jBookInfo(Map<String, Map<String, Object>> catalogData, Map<String,Object> book) {
//        return Map.of(
//                "title", book.get("title"),
//                "isbn", book.get("isbn"),
//                "authorNames", jAuthorNames(catalogData, book));
//    }

//    public static List<Map<String,Object>> jSearchBooksByTitle(Map<String, Map<String, Object>> catalogData, String query) {
//        var allBooks = catalogData.get("booksByIsbn");
//        var matchingBooks = allBooks.values()
//                                    .stream()
//                                    .filter(book -> book.get("title")
//                                                    .contains(query));
//        return matchingBooks.stream()
//        .map(kv -> jBookInfo(catalogData, kv.getValue())).toImList();
//    }

}
