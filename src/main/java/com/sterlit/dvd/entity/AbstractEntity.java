package com.sterlit.dvd.entity;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "last_update")
    private Date lastUpdate;
}
