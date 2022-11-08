package com.ebi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataDTO {

    @NotNull(message = "Persons can not be null!")
    private List<PersonDTO> person;

    public DataDTO() {
    }

    public DataDTO(List<PersonDTO> person) {
        this.person = person;
    }


}
