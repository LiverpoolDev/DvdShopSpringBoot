package com.sterlit.dvd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
// хранит адресные данные для сотрудников и клиентов.
public class Address extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "address2", length = 20, nullable = false) // заглушка
    private String address2;

    @Column(name = "district", length = 20, nullable = false)
    private String district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;


}
