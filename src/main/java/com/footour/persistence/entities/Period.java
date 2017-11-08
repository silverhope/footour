package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "period")
public class Period implements Serializable {
//    private final long serialVersionUID = 4712584678424785126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "period_id_seq")
    @SequenceGenerator(schema = "foot", name = "period_id_seq", sequenceName = "foot.period_id_seq")
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "number_of_days")
    private Integer numberOfDays;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}
