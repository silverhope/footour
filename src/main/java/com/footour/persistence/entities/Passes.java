package com.footour.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "foot", name = "passes")
public class Passes implements Serializable {
//    private final long serialVersionUID = 4712584693146085126L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passes_id_seq")
    @SequenceGenerator(schema = "foot", name = "passes_id_seq", sequenceName = "foot.passes_id_seq")
    private Long id;
    @Column(name = "passes_percentage")
    private Integer passesPercentage;
    @Column(name = "assists")
    private Integer assists;
    @Column(name = "completed_short")
    private Integer completedShort;
    @Column(name = "completed_medium")
    private Integer completedMedium;
    @Column(name = "completed_long")
    private Integer completedLong;
    @Column(name = "failed_short")
    private Integer failedShort;
    @Column(name = "failed_medium")
    private Integer failedMedium;
    @Column(name = "failed_long")
    private Integer failedLong;
    @Column(name = "key_passes")
    private Integer keyPasses;
    @Column(name = "crosses_successful")
    private Integer crossesSuccessful;
    @Column(name = "crosses_failed")
    private Integer crossesFailed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassesPercentage() {
        return passesPercentage;
    }

    public void setPassesPercentage(Integer passesPercentage) {
        this.passesPercentage = passesPercentage;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getCompletedShort() {
        return completedShort;
    }

    public void setCompletedShort(Integer completedShort) {
        this.completedShort = completedShort;
    }

    public Integer getCompletedMedium() {
        return completedMedium;
    }

    public void setCompletedMedium(Integer completedMedium) {
        this.completedMedium = completedMedium;
    }

    public Integer getCompletedLong() {
        return completedLong;
    }

    public void setCompletedLong(Integer completedLong) {
        this.completedLong = completedLong;
    }

    public Integer getFailedShort() {
        return failedShort;
    }

    public void setFailedShort(Integer failedShort) {
        this.failedShort = failedShort;
    }

    public Integer getFailedMedium() {
        return failedMedium;
    }

    public void setFailedMedium(Integer failedMedium) {
        this.failedMedium = failedMedium;
    }

    public Integer getFailedLong() {
        return failedLong;
    }

    public void setFailedLong(Integer failedLong) {
        this.failedLong = failedLong;
    }

    public Integer getKeyPasses() {
        return keyPasses;
    }

    public void setKeyPasses(Integer keyPasses) {
        this.keyPasses = keyPasses;
    }

    public Integer getCrossesSuccessful() {
        return crossesSuccessful;
    }

    public void setCrossesSuccessful(Integer crossesSuccessful) {
        this.crossesSuccessful = crossesSuccessful;
    }

    public Integer getCrossesFailed() {
        return crossesFailed;
    }

    public void setCrossesFailed(Integer crossesFailed) {
        this.crossesFailed = crossesFailed;
    }

    @Override
    public String toString() {
        return "Passes{" +
                "id=" + id +
                ", passesPercentage=" + passesPercentage +
                ", assists=" + assists +
                ", completedShort=" + completedShort +
                ", completedMedium=" + completedMedium +
                ", completedLong=" + completedLong +
                ", failedShort=" + failedShort +
                ", failedMedium=" + failedMedium +
                ", failedLong=" + failedLong +
                ", keyPasses=" + keyPasses +
                ", crossesSuccessful=" + crossesSuccessful +
                ", crossesFailed=" + crossesFailed +
                '}';
    }
}
