package com.spring.boot.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column( nullable = false)
    private String name;

    @NotBlank(message = "Specialty is mandatory")
    @Size(max = 100, message = "Specialty cannot exceed 100 characters")
    @Column( nullable = false)
    private String specialty;

    @NotBlank(message = "Logo path is mandatory")
    @Column(unique = true, nullable = false)
    private String logoPath;

    @URL(message = "Facebook link must be a valid URL")
    private String facebookLink;

    @URL(message = "Twitter link must be a valid URL")
    private String twitterLink;

    @URL(message = "Instagram link must be a valid URL")
    private String instagramLink;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
