package com.damazon.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")  
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;
    
    @Column(name = "userName", unique = true, nullable = false)
    private String username;  

    @Column(name = "password", nullable = false)
    private String password;  

    @Column(name = "isAdmin", nullable = false)
    private int isAdmin;  // 0 = user ,  1 = Admin

    @Column(name = "walletId")
    private Integer walletId;  

    @Column(name = "orders")
    private String orders;

    public User() {
    }

    // Getters and Setters
    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return (isAdmin!=0) ;
    }

    public void setAdmin(boolean admin) {
    	this.isAdmin = admin ? 1 : 0;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getOrders(){
        return orders;
    }
    public void setOrders(String orders) {
        this.orders = orders;
    }

    
}
