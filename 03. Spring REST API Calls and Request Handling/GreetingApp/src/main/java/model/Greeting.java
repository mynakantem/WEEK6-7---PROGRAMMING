package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // Tells Spring Boot this class is a database entity
public class Greeting {

    @Id  // This marks the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID values
    private Long id;

    private String message;

    // Empty constructor is required by JPA
    public Greeting() {}

    // Constructor with message
    public Greeting(String message) {
        this.message = message;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

