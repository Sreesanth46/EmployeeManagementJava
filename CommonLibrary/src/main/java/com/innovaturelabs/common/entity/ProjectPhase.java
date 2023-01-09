package com.innovaturelabs.common.entity;

import com.innovaturelabs.common.form.ProjectPhaseForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */
@Entity
public class ProjectPhase {

    public ProjectPhase(Integer phaseId) {
        this.phaseId = phaseId;
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
    private Integer phaseId;

    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "project_id", unique = true)
    private Project project;

    private String phaseName;
    private byte phaseStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public ProjectPhase() {
    }

    public ProjectPhase(ProjectPhaseForm form) {
        this.project = new Project(form.getProjectId());
        this.phaseName = form.getPhaseName();
        this.phaseStatus = Status.NEW.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public ProjectPhase update(ProjectPhaseForm form) {
        this.phaseName = form.getPhaseName();
        this.phaseStatus = form.getPhaseStatus();

        Date dt = new Date();
        this.updateDate = dt;
        return this;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public byte getPhaseStatus() {
        return phaseStatus;
    }

    public void setPhaseStatus(byte phaseStatus) {
        this.phaseStatus = phaseStatus;
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
