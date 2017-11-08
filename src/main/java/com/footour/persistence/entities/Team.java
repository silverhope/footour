package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "foot", name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "team_id_seq")
    @SequenceGenerator(schema = "foot", name = "team_id_seq", sequenceName = "foot.team_id_seq")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Long value;
    @Column(name = "budget")
    private Long budget;
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    private List<TeamStatistics> teamStatisticsList = new ArrayList<>();

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

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public List<TeamStatistics> getTeamStatisticsList() {
        return teamStatisticsList;
    }

    public void setTeamStatisticsList(List<TeamStatistics> teamStatisticsList) {
        this.teamStatisticsList = teamStatisticsList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", budget=" + budget +
                ", teamStatisticsList=" + teamStatisticsList +
                '}';
    }
}
