package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "book",uniqueConstraints = {@UniqueConstraint(name = "uniqueIsbn",columnNames = "isbn")})
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "book_id",nullable = false)
    private long bookId;
    @Column(name = "author",nullable = false)
    private String author;
    @Column(name = "title",nullable = false)
    private String title;
    @Pattern(regexp = "[0-9]{4}")
    @Column(name = "publication_year",nullable = false)
    private int publicationYear;

    @Pattern(regexp = "[a-z]{3}-[0-9]{3}")
    @Column(name = "isbn",nullable = false)
    private String isbn;
}