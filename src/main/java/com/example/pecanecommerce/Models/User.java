package com.example.pecanecommerce.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

    @Entity
    @Table(name="user")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name;
        private String username;
        private String email;
        private String address;
        private String phone;
        private String type;
        private String password;

        @OneToMany(mappedBy = "user")
        private List<Product> products;

        @OneToMany(mappedBy = "user")
        private List<Order> orders;

        public User() {}

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", type='" + type + '\'' +
                    ", password='" + password + '\'' +
                    ", products=" + products +
                    ", orders=" + orders +
                    '}';
        }

        public User(Integer id, String name, String username, String email, String address, String phone, String password) {
            super();
            this.id = id;
            this.name = name;
            this.username = username;
            this.email = email;
            this.address = address;
            this.phone = phone;
            this.password = password;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        public List<Product> getProduct() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }


    }


