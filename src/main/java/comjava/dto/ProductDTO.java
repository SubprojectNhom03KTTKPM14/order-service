package comjava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {
    private Integer id;
    private String name;
    private String image;
    private Double price;
    private String description;
    private Integer categoryId;
}
