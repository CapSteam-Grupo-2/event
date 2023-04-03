package com.CapgeTicketEvents.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private Long id;

	@Column(name = "name")
	@NotEmpty(message = "Falta o hay un error en name")
	String name;

	@Column(name = "type")
	@NotEmpty(message = "Falta o hay un error en type")
	String type;

	@Column(name = "description")
	@NotEmpty(message = "Falta o hay un error en description")
	String description;

	// Fecha
	@Column(name = "date")
	@NotEmpty(message = "Falta o hay un error en date")
	String date;

	// Hora
	@Column(name = "time")
	@NotEmpty(message = "Falta o hay un error en time")
	String time;

	
	@NotEmpty(message = "Falta o hay un error en location")
	@ManyToOne()
	@JoinColumn()
	private Location location;
}