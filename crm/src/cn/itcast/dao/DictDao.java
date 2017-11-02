package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface DictDao {
	List<BaseDict> findDictByTypeCode(String typeCode);
}
