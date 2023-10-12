package com.globallogic.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="micro-users")
public class User {
    @Id
    @Column(name="ID")
    private String UserId;
    @Column(name="NAME",length = 20)
    private String Name;
    @Column(name="EMAIL")
    private String Email;
    @Column(name="ABOUT")
    private String About;

    @Transient
    private List<Rating> ratings=new ArrayList<>();


}
