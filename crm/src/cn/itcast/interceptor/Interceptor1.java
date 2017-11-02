package cn.itcast.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.domain.BaseDict;
import cn.itcast.service.DictService;

public class Interceptor1 implements HandlerInterceptor {
	
	@Value("${dict.source}")
	private String dictSource;
	
	@Value("${dict.industry}")
	private String dictIndustry;
	
	@Value("${dict.level}")
	private String dictLevel;
	
	@Resource(name="dictService")
	private DictService dictService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view)
			throws Exception {
		String uri = request.getRequestURI();
		if("/crm/cust/list.action".equals(uri) || "/crm/cust/list".equals(uri)){
			List<BaseDict> fromType = dictService.findDictByTypeCode(dictSource);
			List<BaseDict> industryType = dictService.findDictByTypeCode(dictIndustry);
			List<BaseDict> levelType = dictService.findDictByTypeCode(dictLevel);
			
			view.addObject("fromType", fromType);
			view.addObject("industryType", industryType);
			view.addObject("levelType", levelType);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}

}
