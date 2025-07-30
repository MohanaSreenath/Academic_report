package com.example.Academic.repository;

import com.example.Academic.entity.registerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepo extends JpaRepository<registerEntity, Long> {
    Optional<registerEntity> findByEmailIgnoreCase(String email);
}