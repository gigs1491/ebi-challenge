package com.ebi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HobbyDTO {

    private String hobby;

    public HobbyDTO() {
    }

    public HobbyDTO(String hobby) {
        this.hobby = hobby;
    }
}
