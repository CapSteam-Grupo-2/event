package com.capgeticketevents.response;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocationResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String city;
    private String addres;
    private String type;
    private String capacity;

}
