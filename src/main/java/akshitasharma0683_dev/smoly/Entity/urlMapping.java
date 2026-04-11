package akshitasharma0683_dev.smoly.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

    public class urlMapping {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, columnDefinition = "TEXT")
        private String originalUrl;

        @Column(unique = true)
        private String shortCode;

        private LocalDateTime createdAt;

        private LocalDateTime expiryDate;

        private int clickCount = 0;


}

