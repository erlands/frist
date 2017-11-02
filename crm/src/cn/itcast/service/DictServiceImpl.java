package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.DictDao;
import cn.itcast.domain.BaseDict;

@Service("dictService")
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDao dictDao;
	@Override
	public List<BaseDict> findDictByTypeCode(String typeCode) {
		return dictDao.findDictByTypeCode(typeCode);
	}

}
