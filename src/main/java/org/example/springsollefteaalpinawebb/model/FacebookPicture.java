package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facebook_picture")
public class FacebookPicture {

    @Id
    @Column(name = "id_p")
    private String idPicture;

    @Column(name = "created_time_p")
    private String createdTime;


    public FacebookPicture() {
    }

    public FacebookPicture(String id, String createdTime) {
        this.idPicture = id;
        this.createdTime = createdTime;
    }

    public String getId() {return idPicture;}
    public void setId(String id) {this.idPicture = id;}

    public String getCreatedTime() {return createdTime;}
    public void setCreatedTime(String createdTime) {this.createdTime = createdTime;}
}