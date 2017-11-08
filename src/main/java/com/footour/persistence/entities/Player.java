package com.footour.persistence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "foot", name = "player")
public class Player implements Serializable {
//    private final long serialVersionUID = 4712583599534785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "player_id_seq")
    @SequenceGenerator(schema = "foot", name = "player_id_seq", sequenceName = "foot.player_id_seq")
    private Long id;
    @OneToOne
    @JoinColumn(name = "end_user_id")
    private User user;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "known_as")
    private String knownAs;
    @Column(name = "commentary_name")
    private String commentaryName;
    @Column(name = "kit_name")
    private String kitName;
    @Column(name = "kit_number")
    private Long kitNumber;
    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;
    @Column(name = "birth_date")
    private Date birthDate;
    @OneToMany
    @JoinTable(schema = "foot", name = "player_post", joinColumns = { @JoinColumn(name = "player_id") }, inverseJoinColumns = { @JoinColumn(name = "post_id") })
    private List<PlayerPosition> playerPositionList = new ArrayList<>();
    @Column(name = "is_manager")
    private Boolean manager;
    @Column(name = "is_free_agent")
    private Boolean freeAgent;
    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
    @OneToOne
    @JoinColumn(name = "player_statistics_id")
    private PlayerStatistics playerStatistics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getCommentaryName() {
        return commentaryName;
    }

    public void setCommentaryName(String commentaryName) {
        this.commentaryName = commentaryName;
    }

    public String getKitName() {
        return kitName;
    }

    public void setKitName(String kitName) {
        this.kitName = kitName;
    }

    public Long getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Long kitNumber) {
        this.kitNumber = kitNumber;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<PlayerPosition> getPlayerPositionList() {
        return playerPositionList;
    }

    public void setPositionList(List<PlayerPosition> playerPositionList) {
        this.playerPositionList = playerPositionList;
    }

    @JsonProperty("manager")
    public Boolean isManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    @JsonProperty("freeAgent")
    public Boolean isFreeAgent() {
        return freeAgent;
    }

    public void setFreeAgent(Boolean freeAgent) {
        this.freeAgent = freeAgent;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerStatistics getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(PlayerStatistics playerStatistics) {
        this.playerStatistics = playerStatistics;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", knownAs='" + knownAs + '\'' +
                ", commentaryName='" + commentaryName + '\'' +
                ", kitName='" + kitName + '\'' +
                ", kitNumber=" + kitNumber +
                ", nationality=" + nationality +
                ", birthDate=" + birthDate +
                ", playerPositionList=" + playerPositionList +
                ", manager=" + manager +
                ", freeAgent=" + freeAgent +
                ", contract=" + contract +
                ", team=" + team +
                ", playerStatistics=" + playerStatistics +
                '}';
    }
}
