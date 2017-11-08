package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "foot", name = "party")
public class Group implements Serializable{
//    private final long serialVersionUID = 4712584693124785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "party_id_seq")
    @SequenceGenerator(schema = "foot", name = "party_id_seq", sequenceName = "foot.party_id_seq")
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToOne
    @JoinColumn(name = "championship_id")
    private Championship championship;
    @ManyToMany
    @JoinTable(schema = "foot", name = "party_team", joinColumns = {
            @JoinColumn(name = "team_id") }, inverseJoinColumns = { @JoinColumn(name = "party_id") })
    private List<Team> teamList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", season=" + season +
                ", championship=" + championship +
                ", teamList=" + teamList +
                '}';
    }
}
