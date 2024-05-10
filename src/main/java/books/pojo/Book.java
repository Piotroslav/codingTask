package books.pojo;

import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publication;
    private String category;
    private Integer pages;
    private Double price;

    public static Book randomBook() {
        Book newBook = new Book();
        newBook.name = RandomStringUtils.randomAlphanumeric(10);
        newBook.author = RandomStringUtils.randomAlphanumeric(10);
        newBook.publication = RandomStringUtils.randomAlphanumeric(10);
        newBook.category = RandomStringUtils.randomAlphanumeric(10);
        newBook.pages = RandomUtils.nextInt();
        newBook.price = Math.round(RandomUtils.nextDouble() * 100.0) / 100.0;

        return newBook;
    }

    public boolean isEmpty() {
        return id.describeConstable().isEmpty() || name.isEmpty() || author.isEmpty()
                || publication.isEmpty() || category.isEmpty() || pages.describeConstable().isEmpty()
                || price.isNaN();
    }
}
