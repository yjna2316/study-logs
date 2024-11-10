package effectivejava.chatp03.item15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private final List<String> books = new ArrayList<>();  // private 필드로 설정

    public void addBook(String book) {  // 필요한 메서드만 public으로 공개
        books.add(book);
    }

    public void removeBook(String book) {
        books.remove(book);
    }

    public List<String> getBooks() {  // 외부에서 접근할 때는 불변 리스트로 반환
        return Collections.unmodifiableList(books);
    }
}
