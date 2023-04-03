package com.CapgeTicketEvents.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocationResponse {

	private long id;
	private String name;
	private String city;
	private String addres;
	private String type;
	private String capacity;

}
