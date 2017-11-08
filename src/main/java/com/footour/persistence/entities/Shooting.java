package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "shooting")
public class Shooting implements Serializable {
//    private final long serialVersionUID = 4712584693124785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "shooting_id_seq")
    @SequenceGenerator(schema = "foot", name = "shooting_id_seq", sequenceName = "foot.shooting_id_seq")
    private Long id;
    @Column(name = "shooting_percentage")
    private Integer shootingPercentage;
    @Column(name = "goals")
    private Integer goals;
    @Column(name = "on_target")
    private Integer onTarget;
    @Column(name = "off_target")
    private Integer offTarget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShootingPercentage() {
        return shootingPercentage;
    }

    public void setShootingPercentage(Integer shootingPercentage) {
        this.shootingPercentage = shootingPercentage;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getOnTarget() {
        return onTarget;
    }

    public void setOnTarget(Integer onTarget) {
        this.onTarget = onTarget;
    }

    public Integer getOffTarget() {
        return offTarget;
    }

    public void setOffTarget(Integer offTarget) {
        this.offTarget = offTarget;
    }

    @Override
    public String toString() {
        return "Shooting{" +
                "id=" + id +
                ", shootingPercentage=" + shootingPercentage +
                ", goals=" + goals +
                ", onTarget=" + onTarget +
                ", offTarget=" + offTarget +
                '}';
    }
}
