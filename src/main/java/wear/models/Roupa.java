package wear.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Roupa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String nome;

    @NotNull
    private String codigo;

    @JsonProperty(value = "saldo_inicial", access = JsonProperty.Access.WRITE_ONLY)
    @Min(value=0, message = "o valor da preco deve ser positivo")
    private BigDecimal preco;

    private String cor;

    private String tamanho;
}
