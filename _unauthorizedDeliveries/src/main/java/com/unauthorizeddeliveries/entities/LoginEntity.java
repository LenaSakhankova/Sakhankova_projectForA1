package com.unauthorizeddeliveries.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "logins")
public class LoginEntity {

    @Id
    @Column(name = "login_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column(name = "application")
    private String application;

    @Column(name = "app_account_name")
    private String appAccountName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;


}
