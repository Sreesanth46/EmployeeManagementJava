package com.innovaturelabs.employee.view;


import com.innovaturelabs.common.entity.Detail;


public class DetailDetailView extends DetailListView{

    
    

    public DetailDetailView(Detail detail) {
        super(
                detail.getId(),
                detail.getFirstName(),
                detail.getLastName(),
                detail.getDob(),
                detail.getAddress(),
                detail.getCity(),
                detail.getState(),
                detail.getCountry(),
                detail.getStatus(),
                detail.getPhone(),
                detail.getProfilePic(),
                detail.getPhotos()
        );
        
    }
}
