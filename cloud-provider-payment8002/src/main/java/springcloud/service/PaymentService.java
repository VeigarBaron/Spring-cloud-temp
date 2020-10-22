package springcloud.service;

import com.veigar.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author VeigarBaron
 * @date 2020/10/20 16:10
 * @Description *
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
