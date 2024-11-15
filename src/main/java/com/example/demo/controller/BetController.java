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

    @GetMapping
    public List<Bet> getAllBets() {
        return betService.getAllBets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBetById(@PathVariable Long id) {
        Optional<Bet> bet = betService.getBetById(id);
        return bet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bet> addBet(@RequestBody Bet bet) {
        Bet createdBet = betService.addBet(bet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable Long id, @RequestBody Bet betDetails) {
        Bet updatedBet = betService.updateBet(id, betDetails);
        return ResponseEntity.ok(updatedBet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBet(@PathVariable Long id) {
        betService.deleteBet(id);
        return ResponseEntity.noContent().build();
    }
}
