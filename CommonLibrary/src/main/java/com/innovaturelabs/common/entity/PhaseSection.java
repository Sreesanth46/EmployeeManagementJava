package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.PhaseSectionForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */
@Entity
public class PhaseSection {

    public PhaseSection(Integer phaseSectionId) {
        this.phaseSectionId = phaseSectionId;
    }

    public enum Status {
        NEW((byte) 1),
        OPEN((byte) 2),
        PROGRESS((byte) 3),
        COMPLETED((byte) 4);

        private final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer phaseSectionId;

    private String sectionName;

    private byte sectionStatus;

    @OneToOne(fetch = FetchType.EAGER)
    private ProjectPhase projectPhase;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public PhaseSection() {
    }

    public PhaseSection(PhaseSectionForm form) {
        this.sectionName = form.getSectionName();
        this.sectionStatus = Status.NEW.value;
        this.projectPhase = new ProjectPhase(form.getPhaseId());

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public PhaseSection update(PhaseSectionForm form) {
        this.sectionName = form.getSectionName();
        this.sectionStatus = form.getSectionStatus();

        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }

    public Integer getPhaseSectionId() {
        return phaseSectionId;
    }

    public void setPhaseSectionId(Integer phaseSectionId) {
        this.phaseSectionId = phaseSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public byte getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(byte sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    public ProjectPhase getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        this.projectPhase = projectPhase;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
