package akshitasharma0683_dev.smoly.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import akshitasharma0683_dev.smoly.Entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}