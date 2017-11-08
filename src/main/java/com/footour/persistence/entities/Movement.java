package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "movement")
public class Movement implements Serializable {
//    private final long serialVersionUID = 4723684693146085126L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movement_id_seq")
    @SequenceGenerator(schema = "foot", name = "movement_id_seq", sequenceName = "foot.movement_id_seq")
    private Long id;
    @Column(name = "key_dribbles")
    private Integer keyDribbles;
    @Column(name = "fouled")
    private Integer fouled;
    @Column(name = "successful_one_on_one_dribbles")
    private Integer successfulOneOnOneDribbles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKeyDribbles() {
        return keyDribbles;
    }

    public void setKeyDribbles(Integer keyDribbles) {
        this.keyDribbles = keyDribbles;
    }

    public Integer getFouled() {
        return fouled;
    }

    public void setFouled(Integer fouled) {
        this.fouled = fouled;
    }

    public Integer getSuccessfulOneOnOneDribbles() {
        return successfulOneOnOneDribbles;
    }

    public void setSuccessfulOneOnOneDribbles(Integer successfulOneOnOneDribbles) {
        this.successfulOneOnOneDribbles = successfulOneOnOneDribbles;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", keyDribbles=" + keyDribbles +
                ", fouled=" + fouled +
                ", successfulOneOnOneDribbles=" + successfulOneOnOneDribbles +
                '}';
    }
}
