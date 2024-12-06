package com.example.demo.repository;

import com.example.demo.entities.UserBet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBetRepository extends JpaRepository<UserBet, Long> {
}
