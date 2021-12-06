package comjava.dto;

import comjava.VO.OrderDetailVO;
import comjava.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private UserDTO user;
    private LocalDate createdDate;
    private List<OrderDetailVO> orderDetails;
}
