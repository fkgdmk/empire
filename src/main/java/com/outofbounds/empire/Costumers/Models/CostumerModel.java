package com.outofbounds.empire.Costumers.Models;
import javax.persistence.*;

@Entity
@Table(name = "Costumers")
public class CostumerModel {


    public class Movie {

        @Id
        @GeneratedValue
        @Column(name = "id", unique = true, nullable = false)
        private int id;

        @Column(name = "Phonenumber")
        private String phonumber;

        @Column(name = "Name", nullable = true)
        private String name;

        @Column(name = "Email")
        private int Email;

        public Movie(String phonumber, String name, int email) {
            this.phonumber = phonumber;
            this.name = name;
            Email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhonumber() {
            return phonumber;
        }

        public void setPhonumber(String phonumber) {
            this.phonumber = phonumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEmail() {
            return Email;
        }

        public void setEmail(int email) {
            Email = email;
        }
    }


}
