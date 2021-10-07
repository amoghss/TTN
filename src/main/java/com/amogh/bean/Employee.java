package com.amogh.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

// Answer 2

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private int age;

}
