package comjava.dto;

import comjava.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {

    private Integer productID;
    private Integer quantity;

    public OrderDetailDTO(OrderDetail orderDetail) {
        super();
        this.productID = orderDetail.getProductId();
        this.quantity = orderDetail.getQuantity();
    }
}
