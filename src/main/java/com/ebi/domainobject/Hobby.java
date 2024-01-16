package com.ebi.domainobject;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hobby")
@Data
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hobby_name")
    private String hobbyName;


    public Hobby(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Hobby() {
    }
}
