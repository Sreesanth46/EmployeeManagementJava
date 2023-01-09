package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Manager;

/**
 *
 * @author Sreesanth
 */
public class ManagerView {
    private final int managerId;
    private final String managerName;
    private final String email;
    private final short status;
    private final String imageUrl;

    public ManagerView(Manager manager)
    {
        this.managerId = manager.getManagerId();
        this.managerName = manager.getName();
        this.email = manager.getEmail();
        this.status = manager.getStatus();
        this.imageUrl = manager.getImageUrl();
        
    }



    public int getManagerId() {
        return managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getEmail() {
        return email;
    }

    public short getStatus() {
        return status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
