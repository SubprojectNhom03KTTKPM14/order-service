package comjava.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer productId;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders orders;

	public OrderDetail(Integer productId, Integer quantity, Orders orders) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.orders = orders;
	}

}
