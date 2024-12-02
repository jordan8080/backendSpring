package com.example.demo.controller;

import com.example.demo.entities.Bet;
import com.example.demo.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bet")
public class BetController {

    private final BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    // Récupérer tous les paris
    @GetMapping
    public ResponseEntity<List<Bet>> getAllBets() {
        List<Bet> bets = betService.getAllBets();
        return bets.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(bets);
    }

    // Récupérer un pari par ID
    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBetById(@PathVariable Long id) {
        Optional<Bet> bet = betService.getBetById(id);
        return bet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Ajouter un nouveau pari
    @PostMapping
    public ResponseEntity<Bet> addBet(@RequestBody Bet bet) {
        if (bet.getName() == null || bet.getCompetition() == null) {
            return ResponseEntity.badRequest().body(null); // Validation simple
        }
        Bet createdBet = betService.addBet(bet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBet);
    }

    // Mettre à jour un pari
    @PutMapping("/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable Long id, @RequestBody Bet betDetails) {
        Optional<Bet> existingBet = betService.getBetById(id);
        if (existingBet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Bet updatedBet = betService.updateBet(id, betDetails);
        return ResponseEntity.ok(updatedBet);
    }

    // Supprimer un pari
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBet(@PathVariable Long id) {
        Optional<Bet> existingBet = betService.getBetById(id);
        if (existingBet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        betService.deleteBet(id);
        return ResponseEntity.noContent().build();
    }
}
