package comjava.dto;

import java.io.Serializable;

import comjava.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer productID;
    private Integer quantity;

    public OrderDetailDTO(OrderDetail orderDetail) {
        super();
        this.productID = orderDetail.getProductId();
        this.quantity = orderDetail.getQuantity();
    }
}
