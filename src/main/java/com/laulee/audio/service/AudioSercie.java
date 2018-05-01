package com.laulee.audio.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laulee.audio.mapper.AudioMapper;

@Service
public class AudioSercie {
	
	@Autowired
	private AudioMapper audioMapper;

	public List<Map<String, Object>> getStairList(Map<String, Object> params) {

		List<Map<String, Object>> stairList = audioMapper.getStairList(params);
		return stairList;
	}

	public List<Map<String, Object>> getSecondLevelList(Map<String, Object> params) {
		List<Map<String, Object>> secondList  = audioMapper.getSecondLevelList(params);
		return secondList;
	}

}
