package com.capgeticketevents.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dchenlia
 * Para la persistencia en la DDBB usando lombok
 * Location es foranea de event
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    //@NotEmpty(message = "Falta o hay un error en name")
    private String name;

    @Column(name = "city")
    //@NotEmpty(message = "Falta o hay un error en city")
    private String city;

    @Column(name = "addres")
    //@NotEmpty(message = "Falta o hay un error en addres")
    private String addres;

    @Column(name = "type")
    //@NotEmpty(message = "Falta o hay un error en type")
    private String type;

    @Column(name = "capacity")
    //@NotEmpty(message = "Falta o hay un error en capacity")
    private String capacity;
    
    //@JsonIgnoreProperties({"location"})
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "location", cascade = CascadeType.ALL )
    private List<Event> event;

}
