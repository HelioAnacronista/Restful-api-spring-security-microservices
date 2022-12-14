package github.helioanacronista.dscommerce.dto;

import github.helioanacronista.dscommerce.entities.Category;
import github.helioanacronista.dscommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "O nome precisa ter entre 3 a 8 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 10, message = "Descrição miníma de 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description;
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve ter pelo menos um categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        for (Category  cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }
}
