package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "foot", name = "championship")
public class Championship implements Serializable {
//    private final long serialVersionUID = 4712584643124785126L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "championship_id_seq")
    @SequenceGenerator(schema = "foot", name = "championship_id_seq", sequenceName = "foot.championship_id_seq")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @OneToMany(mappedBy = "championship")
    private List<Group> groupList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "id=" + id +
                ", season=" + season +
                ", groupList=" + groupList +
                '}';
    }
}
