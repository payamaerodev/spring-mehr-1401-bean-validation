package com.anisa.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column
    String name;

    @Column
    String detail;
}
