package com.rmit.sept.mon17305.majorproject.model;

import javax.persistence.*;

@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
