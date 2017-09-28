package com.outofbounds.empire.Customers.Models;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
        @Id
        @GeneratedValue
        @Column(name = "id", unique = true, nullable = false)
        private int id;

        @Column(name = "phoneNumber")
        private String phoneNumber;

        @Column(name = "name", nullable = true)
        private String name;

        @Column(name = "email")
        private String email;

        public Customer(String phoneNumber, String name, String email) {
            this.phoneNumber = phoneNumber;
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