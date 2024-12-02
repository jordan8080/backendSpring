package com.example.demo.repository;

import com.example.demo.entities.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
    // List<Bet> findByCompetition(String competition);
}
