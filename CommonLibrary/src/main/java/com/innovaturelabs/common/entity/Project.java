package com.innovaturelabs.common.entity;
import com.innovaturelabs.common.form.ProjectForm;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Sreesanth
 */
@Entity
public class Project {

    public enum Status {
        DELETED((byte) 0),
        NEW((byte) 1),
        OPEN((byte) 2),
        PROGRESS((byte) 3),
        COMPLETED((byte) 4);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String projectName;
    private byte projectStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Project() {
    }

    public  Project(ProjectForm form) {

        this.projectName = form.getProjectName();
        this.projectStatus = form.getProjectStatus();

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }

    public Project update(ProjectForm form){
        this.projectName = form.getProjectName();
        this.projectStatus = form.getProjectStatus();

        Date dt = new Date();
        this.updateDate = dt;

        return this;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(byte projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Project(Integer projectId) {
        this.projectId = projectId;
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
