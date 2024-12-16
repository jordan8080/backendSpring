package com.example.demo.controller;

import com.example.demo.entities.UserBet;
import com.example.demo.service.UserBetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userbets")
public class UserBetController {
    private final UserBetService userBetService;

    public UserBetController(UserBetService userBetService) {
        this.userBetService = userBetService;
    }

    @GetMapping
    public List<UserBet> getAllBets() {
        return userBetService.findAll();
    }

    @GetMapping("/{id}")
    public UserBet getBetById(@PathVariable Long id) {
        return userBetService.findById(id);
    }

    @PostMapping
    public UserBet createBet(@RequestBody UserBet userBet) {
        return userBetService.save(userBet);
    }

    @PutMapping("/{id}")
    public UserBet updateBet(@PathVariable Long id, @RequestBody UserBet userBet) {
        UserBet existingBet = userBetService.findById(id);
        existingBet.setIdUser(userBet.getIdUser());
        existingBet.setCote(userBet.getCote());
        existingBet.setMise(userBet.getMise());
        existingBet.setGainPotentiel(userBet.getGainPotentiel());
        existingBet.setIsWon(userBet.getIsWon());
        return userBetService.save(existingBet);
    }

    @DeleteMapping("/{id}")
    public void deleteBet(@PathVariable Long id) {
        userBetService.deleteById(id);
    }
}
