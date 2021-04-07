package com.sterlit.dvd.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "last_update", nullable = true)
    protected Date lastUpdate;
}
