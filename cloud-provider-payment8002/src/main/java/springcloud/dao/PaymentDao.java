package springcloud.dao;

import com.veigar.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author VeigarBaron
 * @date 2020/10/20 16:07
 * @Description *
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPayment(@Param("id") Long id);
}

