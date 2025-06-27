package com.example.finca_hexagonal.domain.models;

import java.util.Set;

public class Usuario {

    private Long id;
    private String username;
    private String email;
    private String password;

    private boolean enabled;
    private boolean accountNotExpired;
    private boolean credentialsNotExpired;
    private boolean accountNotLocked;

    private Set<Rol> rolSet;

    public Usuario(Long id, String username, String email, String password, boolean enabled, boolean accountNotExpired, boolean credentialsNotExpired, boolean accountNotLocked, Set<Rol> rolSet) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.accountNotExpired = accountNotExpired;
        this.credentialsNotExpired = credentialsNotExpired;
        this.accountNotLocked = accountNotLocked;
        this.rolSet = rolSet;
    }

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNotExpired() {
        return accountNotExpired;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public boolean isCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    public void setCredentialsNotExpired(boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }

    public boolean isAccountNotLocked() {
        return accountNotLocked;
    }

    public void setAccountNotLocked(boolean accountNotLocked) {
        this.accountNotLocked = accountNotLocked;
    }

    public Set<Rol> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Rol> rolSet) {
        this.rolSet = rolSet;
    }
}