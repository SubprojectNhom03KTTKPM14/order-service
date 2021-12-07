package comjava.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import comjava.VO.OrderDetailVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private UserDTO user;
	private LocalDate createdDate;
	private List<OrderDetailVO> orderDetails;

	public double getTotalPrice() {

		double total = 0;

		for (OrderDetailVO orderDetailVO : orderDetails) {

			total += orderDetailVO.getTotalPrice();
		}

		return total;
	}
}
