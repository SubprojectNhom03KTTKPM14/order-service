package comjava.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String name;
    private String image;
    private Double price;
    private String description;
    private Integer categoryId;
}
