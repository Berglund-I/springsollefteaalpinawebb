package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facebook")
public class Facebook {

        @Id
        @Column(name = "id_f")
        private String idFacebook;

        @Column(name = "created_time_f")
        private String createdTime;

        @Column(name = "message_f")
        private String message;

        public Facebook(){

        }

        public Facebook(String createdTime, String message, String idFacebook) {
            this.createdTime = createdTime;
            this.message = message;
            this.idFacebook = idFacebook;
        }

        public String getCreatedTime() {return createdTime;}
        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public String getIdFacebook() { return idFacebook; }
        public void setIdFacebook(String idFacebook) { this.idFacebook = idFacebook; }
}
