package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.CustomerQueryVo;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Override
	public List<Customer> findByVo(CustomerQueryVo vo) {
		return customerDao.findByVo(vo);
	}

	@Override
	public Integer findByVoForCount(CustomerQueryVo vo) {
		return customerDao.findByVoForCount(vo);
	}

	@Override
	public Customer findByCustId(Long id) {
		return customerDao.findByCustId(id);
	}

	@Override
	public void updateByCustId(Customer customer) {
		customerDao.updateByCustId(customer);
	}

	@Override
	public void deleteByCustId(Long id) {
		customerDao.deleteByCustId(id);
	}

}
