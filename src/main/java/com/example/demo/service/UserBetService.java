package com.example.demo.service;

import com.example.demo.entities.UserBet;
import com.example.demo.repository.UserBetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBetService {
    private final UserBetRepository userBetRepository;

    public UserBetService(UserBetRepository userBetRepository) {
        this.userBetRepository = userBetRepository;
    }

    public List<UserBet> findAll() {
        return userBetRepository.findAll();
    }

    public UserBet findById(Long id) {
        return userBetRepository.findById(id).orElseThrow(() -> new RuntimeException("Bet not found"));
    }

    public UserBet save(UserBet userBet) {
        return userBetRepository.save(userBet);
    }

    public void deleteById(Long id) {
        userBetRepository.deleteById(id);
    }
}
