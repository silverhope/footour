package com.footour.persistence.entities;

import javax.persistence.*;

@Entity
@Table(schema = "foot", name = "nationality")
public class Nationality {
//    private final long serialVersionUID = 5812693693124712126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "nationality_id_seq")
    @SequenceGenerator(schema = "foot", name = "nationality_id_seq", sequenceName = "foot.nationality_id_seq")
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
        return "Nationality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
