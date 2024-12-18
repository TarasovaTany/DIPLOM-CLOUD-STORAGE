package ru.netology.diplom_cloud_storage.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -3418503142215704031L;

    @JsonProperty("auth-token")
    private String authToken;

}
