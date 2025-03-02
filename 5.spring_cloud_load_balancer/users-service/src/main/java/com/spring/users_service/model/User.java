package com.spring.users_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "CELL_PHONE")
    private String cellPhone;

    public User() {
    }

    public User(Long userId, String name, String lastName, String cellPhone) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
    }

}
