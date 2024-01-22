package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowed_books",uniqueConstraints = {@UniqueConstraint(name = "unigueIsbn",columnNames = "isbn")})
public class BorrowedBooks {
    @Id
    @Column(name = "user_id",nullable = false, updatable = true)
    private long userId;
    @Id
    @Column(name = "book_id",nullable = false)
    private long bookId;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "title",nullable = false)
    private String title;
    @Pattern(regexp = "[a-z]{3}-[0-9]{3}")
    @Column(name = "isbn",nullable = false)
    private String isbn;

}
