package wear.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import wear.controllers.ExperimentarController;
import wear.controllers.RoupaController;
import wear.enums.Cor;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Experimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate data;

    @NotBlank @Size(min = 5, max = 255)
    private String descricao;

    private Cor cor;

    private int tamanho;

    @NotNull
    @ManyToOne
    private Roupa roupa;

    public EntityModel<Experimentar> toModel(){
        return EntityModel.of(
                this,
                linkTo(methodOn(ExperimentarController.class).show(id)).withSelfRel(),
                linkTo(methodOn(ExperimentarController.class).destroy(id)).withRel("delete"),
                linkTo(methodOn(ExperimentarController.class).index(null, Pageable.unpaged())).withRel("all"),
                linkTo(methodOn(RoupaController.class).show(this.getRoupa().getId())).withRel("roupa")
        );
    }
}
