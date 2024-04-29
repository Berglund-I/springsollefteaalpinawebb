package org.example.springsollefteaalpinawebb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facebook")
public class Facebook {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "created_time_f")
        private String createdTime;

        @Column(name = "message_f")
        private String message;

        @Column(name = "id_f")
        private String idFacebook;

        public Facebook(){

        }

        public Facebook(String createdTime, String message, String idFacebook) {
            this.createdTime = createdTime;
            this.message = message;
            this.idFacebook = idFacebook;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
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
