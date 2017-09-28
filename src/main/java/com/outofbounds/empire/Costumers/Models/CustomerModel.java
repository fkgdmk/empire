package com.outofbounds.empire.Costumers.Models;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
public class CustomerModel {
        @Id
        @GeneratedValue
        @Column(name = "id", unique = true, nullable = false)
        private int id;

        @Column(name = "Phonenumber")
        private String phoneNumber;

        @Column(name = "Name", nullable = true)
        private String name;

        @Column(name = "Email")
        private String email;

        public CustomerModel(String phonumber, String name, String email) {
            this.phoneNumber = phonumber;
            this.name = name;
            email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhonumber() {
            return phoneNumber;
        }

        public void setPhonumber(String phonumber) {
            this.phoneNumber = phonumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() { return email; }

        public void setEmail(String email) {
            email = email;
        }
    }