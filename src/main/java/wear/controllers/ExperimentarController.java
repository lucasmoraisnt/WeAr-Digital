package wear.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import wear.exception.RestNotFoundException;
import wear.models.Experimentar;
import wear.models.Roupa;
import wear.repository.ExperimentarRepository;
import wear.repository.RoupaRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/experimentar")
@SecurityRequirement(name = "bearer-key")
public class ExperimentarController {

    List<Roupa> roupas = new ArrayList<>();

    @Autowired
    ExperimentarRepository experimentarRepository;

    @Autowired
    RoupaRepository roupaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 5) Pageable pageable){
        Page<Experimentar> despesas = (busca == null)?
                experimentarRepository.findAll(pageable):
                experimentarRepository.findByDescricaoContaining(busca, pageable);

        return assembler.toModel(despesas.map(Experimentar::toModel));
    }


    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "roupa para experimentar cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na validação dos dados da requisição")
    })
    public ResponseEntity<Object> create(@RequestBody @Valid Experimentar experimentar){
        log.info("cadastrando roupa para experimentar: " + experimentar);
        experimentarRepository.save(experimentar);
        experimentar.setRoupa(roupaRepository.findById(experimentar.getRoupa().getId()).get());
        return ResponseEntity
                .created(experimentar.toModel().getRequiredLink("self").toUri())
                .body(experimentar.toModel());
    }
    @GetMapping("{id}")
    @Operation(
            summary = "Detalhes da roupa",
            description = "Retorna os dados de uma roupa com id especificado"
    )
    public EntityModel<Experimentar> show(@PathVariable Long id){
        log.info("buscando roupa com id " + id);
        var experimentar = experimentarRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Roupa não encontrada"));

        return experimentar.toModel();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Experimentar> destroy(@PathVariable Long id){
        log.info("apagando roupa com id " + id);
        var despesa = experimentarRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("roupa não encontrada"));

        experimentarRepository.delete(despesa);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public EntityModel<Experimentar> update(@PathVariable Long id, @RequestBody @Valid Experimentar experimentar){
        log.info("alterando roupa com id " + id);
        experimentarRepository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("roupa não encontrada"));

        experimentar.setId(id);
        experimentarRepository.save(experimentar);

        return experimentar.toModel();

    }

}
