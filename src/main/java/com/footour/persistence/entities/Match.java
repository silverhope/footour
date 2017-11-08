package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "foot", name = "game")
public class Match implements Serializable{
//    private final long serialVersionUID = 4712584693124785916L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
    @SequenceGenerator(schema = "foot", name = "game_id_seq", sequenceName = "foot.game_id_seq")
    private Long id;
    @Column(name = "is_party_game")
    private Boolean groupMatch;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Team teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;
    @Column(name = "score_a")
    private Integer scoreA;
    @Column(name = "score_b")
    private Integer scoreB;
    @Column(name = "game_day")
    private Integer matchDay;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(schema="foot", name = "scorer", joinColumns = { @JoinColumn(name = "game_id") }, inverseJoinColumns = { @JoinColumn(name = "player_id") })
    private List<Player> scorerList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isGroupMatch() {
        return groupMatch;
    }

    public void setGroupMatch(Boolean groupMatch) {
        this.groupMatch = groupMatch;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public Integer getScoreA() {
        return scoreA;
    }

    public void setScoreA(Integer scoreA) {
        this.scoreA = scoreA;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public void setScoreB(Integer scoreB) {
        this.scoreB = scoreB;
    }

    public Integer getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(Integer matchDay) {
        this.matchDay = matchDay;
    }

    public List<Player> getScorerList() {
        return scorerList;
    }

    public void setScorerList(List<Player> scorerList) {
        this.scorerList = scorerList;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", groupMatch=" + groupMatch +
                ", season=" + season +
                ", group=" + group +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                ", scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                ", matchDay=" + matchDay +
                ", scorerList=" + scorerList +
                '}';
    }
}
