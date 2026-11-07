package com.example.codequiz.model;

import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String fullName;
    private String email;
    private String username;
    private String passwordHash;
    private String passwordSalt;
    private String profileImage;
    private long createdAt;

    public User() {
    }

    public User(long id, String fullName, String email, String username, String passwordHash, String passwordSalt, long createdAt) {
        this(id, fullName, email, username, passwordHash, passwordSalt, null, createdAt);
    }

    public User(long id, String fullName, String email, String username, String passwordHash, String passwordSalt, String profileImage, long createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.profileImage = profileImage;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
