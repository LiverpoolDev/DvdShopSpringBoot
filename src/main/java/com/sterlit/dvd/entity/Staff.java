package com.sterlit.dvd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "staff")
// хранит данные персонала.
public class Staff extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "staff_id")
    private Long id;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "username", length = 16)
    private String username;

    @Column(name = "password", length = 40)
    private String password;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] picture;

}
