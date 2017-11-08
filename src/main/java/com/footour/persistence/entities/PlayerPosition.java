/*
 * Copyright (c) 2017.
 */

package com.footour.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "player_post")
public class PlayerPosition implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "player_post_id_seq")
    @SequenceGenerator(schema = "foot", name = "player_post_id_seq", sequenceName = "foot.player_post_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Position position;
    @Column(name = "is_primary")
    private Boolean primary;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @JsonProperty("primary")
    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "PlayerPosition{" +
                "id=" + id +
                ", player=" + player +
                ", position=" + position +
                ", primary=" + primary +
                '}';
    }
}
