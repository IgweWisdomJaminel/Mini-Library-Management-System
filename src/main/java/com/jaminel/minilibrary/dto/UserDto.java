package com.jaminel.minilibrary.dto;

import lombok.*;
import model.User;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName ="build")
public class UserDto extends User {
    private String fullName;

    private int age;

    private String address;

    private String email;
}
