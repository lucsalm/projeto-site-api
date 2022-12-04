package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private byte[] password;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

}
