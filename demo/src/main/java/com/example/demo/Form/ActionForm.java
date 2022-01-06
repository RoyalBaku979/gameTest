package com.example.demo.Form;



import lombok.Data;
import javax.validation.constraints.*;


@Data
public class ActionForm {

    @NotNull(message = "userId cannot be null")
    private Integer userId;

    @NotNull(message = "gameId cannot be null")
    private Integer gameId;

    @NotBlank(message = "action cannot be blank")
    private String action;
}
