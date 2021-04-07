package com.sterlit.dvd.entity;


import lombok.*;


import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "actor")
// хранит данные об актёрах, включая их имя и фамилию
public class Actor extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;


//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "film_actor",
//            joinColumns = @JoinColumn(name = "actor_id"),
//            inverseJoinColumns = @JoinColumn(name = "film_id"))
//    private List<Film> films;

    }
