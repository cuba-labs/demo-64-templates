package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "DEMO_FOO")
@Entity(name = "demo$Foo")
public class Foo extends StandardEntity {
    private static final long serialVersionUID = -2814086189457491230L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "DETAILS")
    protected String details;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }


}