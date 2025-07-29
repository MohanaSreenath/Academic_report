package com.example.Academic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Academic.dto.*;
public interface RegisterRepo extends JpaRepository<Register, Long> {
}
