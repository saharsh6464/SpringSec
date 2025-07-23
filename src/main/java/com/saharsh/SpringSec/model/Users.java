package com.saharsh.SpringSec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO
    private Long id;

    private String username;
    private String password;
    private String role; // e.g., "USER" or "ADMIN"
    // getters & setters
}
