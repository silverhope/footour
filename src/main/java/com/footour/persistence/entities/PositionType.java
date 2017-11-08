package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "post_type")
public class PositionType implements Serializable {
//    private final long serialVersionUID = 5823793693124712466L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "post_type_id_seq")
    @SequenceGenerator(schema = "foot", name = "post_type_id_seq", sequenceName = "foot.post_type_id_seq")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

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

    @Override
    public String toString() {
        return "PositionType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
