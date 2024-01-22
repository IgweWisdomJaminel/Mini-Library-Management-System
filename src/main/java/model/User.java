package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName ="build")
@Entity(name = "user")
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(name ="uniqueEmail",columnNames ="email")})
public class User  {

    @GeneratedValue(strategy = IDENTITY, generator = "idGenerator")
    @Id
    @Column(name="user_id",updatable = false)
    private long userId;
    @Column(name ="full_name",nullable = false,unique = true)
    @Length(min = 6, max = 15, message = "name is too long")
    @NotBlank
    private String fullName;
    @Column(name ="age",nullable = false)
    @Length(min = 18,max = 80 ,message ="You are not within the age range")
    @NotBlank
    private int age;
    @Column(name = "address",nullable = false)
    @NotBlank
    private String address;
    @NotBlank
    @Column(nullable = false)
    @Pattern(regexp = "[@][.com]",message = "Incorrect email")
    private String email;

    public User(String fullName, int age, String address, String email) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.email = email;
    }
}



