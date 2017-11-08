package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(schema = "foot", name = "season")
public class Season implements Serializable {
//    private final long serialVersionUID = 4712584693146085126L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_id_seq")
    @SequenceGenerator(schema = "foot", name = "season_id_seq", sequenceName = "foot.season_id_seq")
    private Integer id;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
