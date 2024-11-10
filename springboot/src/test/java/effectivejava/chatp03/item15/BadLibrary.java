// src/main/java/com/example/bad/Library.java
package effectivejava.chatp03.item15;

import java.util.ArrayList;
import java.util.List;

public class BadLibrary {
    public List<String> books = new ArrayList<>();  // public으로 노출된 필드

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }
}
