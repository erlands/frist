package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface DictService {
	List<BaseDict> findDictByTypeCode(String typeCode);
}
