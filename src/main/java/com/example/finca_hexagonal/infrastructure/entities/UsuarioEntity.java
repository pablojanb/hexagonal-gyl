package com.example.finca_hexagonal.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    private boolean enabled;
    @Column(name = "account_not_expired")
    private boolean accountNotExpired;
    @Column(name = "credentials_not_expired")
    private boolean credentialsNotExpired;
    @Column(name = "account_not_locked")
    private boolean accountNotLocked;

    @ManyToMany(targetEntity = RolEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolEntity> rolEntitySet;
}