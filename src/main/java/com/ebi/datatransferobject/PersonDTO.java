package com.ebi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    @JsonProperty("person_id")
    private Long Id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("favourite_colour")
    private String favourite_colour;

    @JsonProperty("hobby")
    private List<String> hobby;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String first_name, String last_name, int age, String favourite_colour, List<String> hobby) {
        this.Id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.favourite_colour = favourite_colour;
        this.hobby = hobby;
    }
}
