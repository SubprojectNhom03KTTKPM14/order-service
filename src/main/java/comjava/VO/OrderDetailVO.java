package comjava.VO;

import java.io.Serializable;

import comjava.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProductDTO product;
	private Integer quantity;

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
}
