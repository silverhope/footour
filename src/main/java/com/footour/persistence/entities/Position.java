package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "post")
public class Position implements Serializable {
//    private final long serialVersionUID = 5823793693124712126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "post_id_seq")
    @SequenceGenerator(schema = "foot", name = "post_id_seq", sequenceName = "foot.post_id_seq")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "post_type_id")
    private PositionType positionType;

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

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", positionType=" + positionType +
                '}';
    }
}
