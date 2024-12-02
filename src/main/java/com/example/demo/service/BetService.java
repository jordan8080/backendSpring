package com.example.demo.service;

import com.example.demo.entities.Bet;
import com.example.demo.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {

    private final BetRepository betRepository;

    @Autowired
    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    public Optional<Bet> getBetById(Long id) {
        return betRepository.findById(id);
    }

    public Bet addBet(Bet bet) {
        return betRepository.save(bet);
    }

    public Bet updateBet(Long id, Bet betDetails) {
        Bet existingBet = betRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bet not found"));
        existingBet.setName(betDetails.getName());
        existingBet.setCote1(betDetails.getCote1());
        existingBet.setCote2(betDetails.getCote2());
        existingBet.setCote3(betDetails.getCote3());
        existingBet.setCompetition(betDetails.getCompetition());
        return betRepository.save(existingBet);
    }

    public void deleteBet(Long id) {
        betRepository.deleteById(id);
    }
}
