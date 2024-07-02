package com.example.atlasvotegate.entities;

import com.example.atlasvotegate.entities.ElectoralParty;
import com.example.atlasvotegate.entities.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vote {

    /**
     * Identifiant unique du vote.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Utilisateur ayant effectué le vote.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is mandatory")
    private User user;

    /**
     * Parti électoral choisi lors du vote.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoral_party_id", nullable = false)
    @NotNull(message = "Electoral party is mandatory")
    private ElectoralParty electoralParty;

    /**
     * Date et heure à laquelle le vote a été enregistré.
     */

    private LocalDateTime timestamp;

    // Constructeurs, getters, setters, méthodes utilitaires...

}
