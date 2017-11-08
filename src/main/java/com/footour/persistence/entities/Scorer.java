/*
 * Copyright (c) 2017.
 */

package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "scorer")
public class Scorer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "scorer_id_seq")
    @SequenceGenerator(schema = "foot", name = "scorer_id_seq", sequenceName = "foot.scorer_id_seq")
    private Long id;
    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @OneToOne
    @JoinColumn(name = "game_id")
    private Match match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "Scorer{" +
                "id=" + id +
                ", player=" + player +
                ", match=" + match +
                '}';
    }
}
