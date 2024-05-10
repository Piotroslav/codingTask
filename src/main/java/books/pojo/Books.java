package books.pojo;

import lombok.*;

import java.util.ArrayList;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private ArrayList<Book> books = new ArrayList<>();

    public Book getLastBook(){
        if (books.size()>0) {
            return books.get(books.size()-1);
        }
        return null;
    }

    public Book getBookById(Integer id){
        for (Book book : books) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public Book getBookWithMaxId(){
        if (books.size()>0) {
            Integer maxId = 0;
            for (Book book : books) {
                if (book.getId() > maxId){
                    maxId = book.getId();
                }
            }
            return getBookById(maxId);
        }
        return null;
    }

    public Book getBookWithMinId(){
        if (books.size()>0) {
            Integer minId = books.get(0).getId();
            for (Book book : books) {
                if (book.getId() < minId){
                    minId = book.getId();
                }
            }
            return getBookById(minId);
        }
        return null;
    }

    public boolean hasTheBook(Book book){
        return books.contains(book);
    }
}
