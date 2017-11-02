package cn.itcast.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.Customer;
import cn.itcast.domain.CustomerQueryVo;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;

@Controller 
@RequestMapping("/cust")
public class CustController {
	
	@Resource(name="customerService")
	private CustomerService customerService;
	

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(CustomerQueryVo vo,Model model){
		
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
		Integer total = customerService.findByVoForCount(vo);
		
		List<Customer> rows = customerService.findByVo(vo);
		
		Page<Customer> page = new Page<Customer>();
		
		page.setPage(vo.getPage());
		page.setTotal(total);
		page.setRows(rows);
		page.setSize(vo.getSize());
		
		model.addAttribute("page", page);
		
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "/customer";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	@ResponseBody
	public Customer toEdit(Long id){
		Customer customer = customerService.findByCustId(id);
		return customer;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(Customer customer){
		customerService.updateByCustId(customer);
		return "ok";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(Long id){
		customerService.deleteByCustId(id);
		return "ok";
	}
	
}
