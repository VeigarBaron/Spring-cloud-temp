package springcloud.service.impl;

import com.veigar.springcloud.dao.PaymentDao;
import com.veigar.springcloud.entities.Payment;
import com.veigar.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author VeigarBaron
 * @date 2020/10/20 16:10
 * @Description *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentDao.getPayment(id);
    }
}
