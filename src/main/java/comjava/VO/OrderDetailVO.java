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
    private double totalPrice;

    public double totalPrice() {
        return totalPrice = product.getPrice()*quantity;
    }
}
