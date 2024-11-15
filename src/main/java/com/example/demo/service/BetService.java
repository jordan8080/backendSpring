package com.example.demo.service;

import com.example.demo.entities.Bet;
import com.example.demo.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {
    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    public Optional<Bet> getBetById(Long id) {
        return betRepository.findById(id);
    }

    public Bet createBet(Bet bet) {
        return betRepository.save(bet);
    }

    public Bet updateBet(Long id, Bet betDetails) {
        return betRepository.findById(id)
                .map(bet -> {
                    bet.setName(betDetails.getName());
                    bet.setCote(betDetails.getCote());
                    return betRepository.save(bet);
                }).orElseThrow(() -> new RuntimeException("Pari non trouvé avec l'id " + id));
    }

    public void deleteBet(Long id) {
        betRepository.deleteById(id);
    }
}
