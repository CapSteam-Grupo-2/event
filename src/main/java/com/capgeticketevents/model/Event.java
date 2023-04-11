package com.capgeticketevents.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author dchenlia
 * Para la persistencia en la DDBB usando lombok
 * Clase del modelo de los eventos que existen
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Falta o hay un error en name")
    private String name;

    @Column(name = "type")
    @NotEmpty(message = "Falta o hay un error en type")
    private String type;

    @Column(name = "description")
    @NotEmpty(message = "Falta o hay un error en description")
    private String description;

    // Fecha
    @Column(name = "date")
    @NotEmpty(message = "Falta o hay un error en date")
    private String date;

    // Hora
    @Column(name = "time")
    @NotEmpty(message = "Falta o hay un error en time")
    private String time;


    //@NotEmpty(message = "Falta o hay un error en location")
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_location")
    private Location location;
}
