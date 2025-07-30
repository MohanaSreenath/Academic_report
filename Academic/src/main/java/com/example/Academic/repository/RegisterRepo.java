package com.example.Academic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Academic.entity.registerEntity;

public interface RegisterRepo extends JpaRepository<registerEntity, Long> {
    registerEntity findAllByEmailEqualsIgnoreCase(String email);
}

