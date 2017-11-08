package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "contract")
public class Contract implements Serializable {
//    private final long serialVersionUID = 5822683693124712126L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "contract_id_seq")
    @SequenceGenerator(schema = "foot", name = "contract_id_seq", sequenceName = "foot.contract_id_seq")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "years")
    private Integer years;
    @Column(name = "buy_out")
    private Integer buyOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getBuyOut() {
        return buyOut;
    }

    public void setBuyOut(Integer buyOut) {
        this.buyOut = buyOut;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", years=" + years +
                ", buyOut=" + buyOut +
                '}';
    }
}
