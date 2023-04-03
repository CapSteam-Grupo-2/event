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
 *Para la persistencia en la DDBB usando lombok
 *Location es foranea de event
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
	private Long id;

	
	@OneToMany(mappedBy = "location")
	List<Event> event;
	@Column(name = "name")
	@NotEmpty(message = "Falta o hay un error en name")
	String name;

	@Column(name = "city")
	@NotEmpty(message = "Falta o hay un error en city")
	String city;

	@Column(name = "addres")
	@NotEmpty(message = "Falta o hay un error en addres")
	String addres;

	@Column(name = "type")
	@NotEmpty(message = "Falta o hay un error en type")
	String type;

	@Column(name = "capacity")
	@NotEmpty(message = "Falta o hay un error en capacity")
	String capacity;

}
