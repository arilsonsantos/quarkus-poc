package br.com.orion.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Todo extends PanacheEntity {
    
    public String title;
    public boolean completed;
    @Column(name = "ordering")
    public int order;
}