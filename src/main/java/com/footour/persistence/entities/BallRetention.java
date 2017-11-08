package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "ball_retention")
public class BallRetention implements Serializable {
//    private final long serialVersionUID = 4712584678425895126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "ball_retention_id_seq")
    @SequenceGenerator(schema = "foot", name = "ball_retention_id_seq", sequenceName = "foot.ball_retention_id_seq")
    private Long id;
    @Column(name = "possession_won")
    private Integer possessionWon;
    @Column(name = "possession_lost")
    private Integer possessionLost;
    @Column(name = "clearances")
    private Integer clearances;
    @Column(name = "headers_won")
    private Integer headersWon;
    @Column(name = "headers_lost")
    private Integer headersLost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPossessionWon() {
        return possessionWon;
    }

    public void setPossessionWon(Integer possessionWon) {
        this.possessionWon = possessionWon;
    }

    public Integer getPossessionLost() {
        return possessionLost;
    }

    public void setPossessionLost(Integer possessionLost) {
        this.possessionLost = possessionLost;
    }

    public Integer getClearances() {
        return clearances;
    }

    public void setClearances(Integer clearances) {
        this.clearances = clearances;
    }

    public Integer getHeadersWon() {
        return headersWon;
    }

    public void setHeadersWon(Integer headersWon) {
        this.headersWon = headersWon;
    }

    public Integer getHeadersLost() {
        return headersLost;
    }

    public void setHeadersLost(Integer headersLost) {
        this.headersLost = headersLost;
    }

    @Override
    public String toString() {
        return "BallRetention{" +
                "id=" + id +
                ", possessionWon=" + possessionWon +
                ", possessionLost=" + possessionLost +
                ", clearances=" + clearances +
                ", headersWon=" + headersWon +
                ", headersLost=" + headersLost +
                '}';
    }
}
