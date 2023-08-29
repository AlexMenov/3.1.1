package com.userscrud.userscrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users", catalog = "users", schema = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Slf4j
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 30, message = "Max name long is 30 characters")
    private String name;

    @Column(name = "last_name")
    @NotNull
    @Size(max = 30, message = "Max name long is 30 characters")
    private String lastName;

    @Column(name = "user_photo")
    private String photo;

    @Column(name = "achievement")
    private String achievement;
}
