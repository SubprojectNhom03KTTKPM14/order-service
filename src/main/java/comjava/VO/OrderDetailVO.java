package comjava.VO;

import comjava.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {

	private ProductDTO product;
	private Integer quantity;

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}
}
