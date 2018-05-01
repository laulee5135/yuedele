package com.laulee.audio.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AudioMapper {

	List<Map<String, Object>> getStairList(Map<String, Object> params);

	List<Map<String, Object>> getSecondLevelList(Map<String, Object> params);

}
