package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_bet")
public class UserBet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBet;

    @Column (name = "id_user")
    private Long idUser;

    @Column (name = "cote")
    private Double cote;

    @Column (name = "mise")
    private Double mise;

    @Column (name = "gain_potentiel")
    private Double gainPotentiel;

    @Column(name = "is_won")
    private Boolean isWon;
}
