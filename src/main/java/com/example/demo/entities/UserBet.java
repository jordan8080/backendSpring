package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserBet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBet;

    private Long idUser;

    private Double cote;

    private Double mise;

    private Double gainPotentiel;

    private Boolean isWon;
}
