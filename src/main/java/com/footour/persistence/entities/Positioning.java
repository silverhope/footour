package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "positioning")
public class Positioning implements Serializable {
//    private final long serialVersionUID = 4712585788424785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "positioning_id_seq")
    @SequenceGenerator(schema = "foot", name = "positioning_id_seq", sequenceName = "foot.positioning_id_seq")
    private Long id;
    @Column(name = "interceptions")
    private Integer interceptions;
    @Column(name = "blocks")
    private Integer blocks;
    @Column(name = "out_of_position")
    private Integer outOfPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getOutOfPosition() {
        return outOfPosition;
    }

    public void setOutOfPosition(Integer outOfPosition) {
        this.outOfPosition = outOfPosition;
    }

    @Override
    public String toString() {
        return "Positioning{" +
                "id=" + id +
                ", interceptions=" + interceptions +
                ", blocks=" + blocks +
                ", outOfPosition=" + outOfPosition +
                '}';
    }
}
