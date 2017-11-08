package com.footour.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "player_statistics")
public class PlayerStatistics implements Serializable {
//    private final long serialVersionUID = 4712584693124784826L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_statistics_id_seq")
    @SequenceGenerator(schema = "foot", name = "player_statistics_id_seq", sequenceName = "foot.player_statistics_id_seq")
    private Long id;
    @OneToOne
    @JoinColumn(name = "player_id")
    @JsonBackReference
    private Player player;
    @OneToOne
    @JoinColumn(name = "shooting_id")
    private Shooting shooting;
    @OneToOne
    @JoinColumn(name = "passes_id")
    private Passes passes;
    @OneToOne
    @JoinColumn(name = "movement_id")
    private Movement movement;
    @OneToOne
    @JoinColumn(name = "tackling_id")
    private Tackling tackling;
    @OneToOne
    @JoinColumn(name = "positioning_id")
    private Positioning positioning;
    @OneToOne
    @JoinColumn(name = "ball_retention_id")
    private BallRetention ballRetention;

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

    public Shooting getShooting() {
        return shooting;
    }

    public void setShooting(Shooting shooting) {
        this.shooting = shooting;
    }

    public Passes getPasses() {
        return passes;
    }

    public void setPasses(Passes passes) {
        this.passes = passes;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Tackling getTackling() {
        return tackling;
    }

    public void setTackling(Tackling tackling) {
        this.tackling = tackling;
    }

    public Positioning getPositioning() {
        return positioning;
    }

    public void setPositioning(Positioning positioning) {
        this.positioning = positioning;
    }

    public BallRetention getBallRetention() {
        return ballRetention;
    }

    public void setBallRetention(BallRetention ballRetention) {
        this.ballRetention = ballRetention;
    }

    @Override
    public String toString() {
        return "PlayerStatistics{" +
                "id=" + id +
                ", shooting=" + shooting +
                ", passes=" + passes +
                ", movement=" + movement +
                ", tackling=" + tackling +
                ", positioning=" + positioning +
                ", ballRetention=" + ballRetention +
                '}';
    }
}
