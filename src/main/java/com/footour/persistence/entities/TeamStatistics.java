package com.footour.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "team_statistics")
public class TeamStatistics implements Serializable{
//    private final long serialVersionUID = 5812584693124712126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "team_statistics_id_seq")
    @SequenceGenerator(schema = "foot", name = "team_statistics_id_seq", sequenceName = "foot.team_statistics_id_seq")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @Column(name = "shots")
    private Integer shots;
    @Column(name = "shots_on_target")
    private Integer shotsOnTarget;
    @Column(name = "possession")
    private Integer possession;
    @Column(name = "tackles")
    private Integer tackles;
    @Column(name = "fouls")
    private Integer fouls;
    @Column(name = "corners")
    private Integer corners;
    @Column(name = "shot_accuracy")
    private Integer shotAccuracy;
    @Column(name = "pass_accuracy")
    private Integer passAccuracy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(Integer shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public Integer getPossession() {
        return possession;
    }

    public void setPossession(Integer possession) {
        this.possession = possession;
    }

    public Integer getTackles() {
        return tackles;
    }

    public void setTackles(Integer tackles) {
        this.tackles = tackles;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getCorners() {
        return corners;
    }

    public void setCorners(Integer corners) {
        this.corners = corners;
    }

    public Integer getShotAccuracy() {
        return shotAccuracy;
    }

    public void setShotAccuracy(Integer shotAccuracy) {
        this.shotAccuracy = shotAccuracy;
    }

    public Integer getPassAccuracy() {
        return passAccuracy;
    }

    public void setPassAccuracy(Integer passAccuracy) {
        this.passAccuracy = passAccuracy;
    }

    @Override
    public String toString() {
        return "TeamStatistics{" +
                "id=" + id +
                ", team=" + team +
                ", season=" + season +
                ", shots=" + shots +
                ", shotsOnTarget=" + shotsOnTarget +
                ", possession=" + possession +
                ", tackles=" + tackles +
                ", fouls=" + fouls +
                ", corners=" + corners +
                ", shotAccuracy=" + shotAccuracy +
                ", passAccuracy=" + passAccuracy +
                '}';
    }
}
