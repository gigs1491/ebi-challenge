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

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Hobby(String hobbyName, Person person) {
        this.hobbyName = hobbyName;
        this.person = person;
    }

    public Hobby() {
    }
}
