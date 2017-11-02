package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.CustomerQueryVo;

public interface CustomerService {

	List<Customer> findByVo(CustomerQueryVo vo);
	
	Integer findByVoForCount(CustomerQueryVo vo);
	
	Customer findByCustId(Long id);
	
	void updateByCustId(Customer customer);
	
	void deleteByCustId(Long id);
}
