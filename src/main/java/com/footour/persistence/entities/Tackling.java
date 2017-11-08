package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "tackling")
public class Tackling implements Serializable {
//    private final long serialVersionUID = 4712584789424785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "tackling_id_seq")
    @SequenceGenerator(schema = "foot", name = "tackling_id_seq", sequenceName = "foot.tackling_id_seq")
    private Long id;
    @Column(name = "tackling_percentage")
    private Integer tacklingPercentage;
    @Column(name = "won")
    private Integer won;
    @Column(name = "lost")
    private Integer lost;
    @Column(name = "fouls")
    private Integer fouls;
    @Column(name = "penalties_conceded")
    private Integer penaltiesConceded;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTacklingPercentage() {
        return tacklingPercentage;
    }

    public void setTacklingPercentage(Integer tacklingPercentage) {
        this.tacklingPercentage = tacklingPercentage;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getLost() {
        return lost;
    }

    public void setLost(Integer lost) {
        this.lost = lost;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getPenaltiesConceded() {
        return penaltiesConceded;
    }

    public void setPenaltiesConceded(Integer penaltiesConceded) {
        this.penaltiesConceded = penaltiesConceded;
    }

    @Override
    public String toString() {
        return "Tackling{" +
                "id=" + id +
                ", tacklingPercentage=" + tacklingPercentage +
                ", won=" + won +
                ", lost=" + lost +
                ", fouls=" + fouls +
                ", penaltiesConceded=" + penaltiesConceded +
                '}';
    }
}
