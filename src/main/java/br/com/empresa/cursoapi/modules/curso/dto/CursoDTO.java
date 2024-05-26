package br.com.empresa.cursoapi.modules.curso.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoDTO {

    @NotBlank(message = "O nome do curso é obrigatório")
    private String name;

    @NotBlank(message = "A categoria do curso é obrigatória")
    private String category;

}
