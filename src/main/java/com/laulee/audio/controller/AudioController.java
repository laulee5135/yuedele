package com.laulee.audio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laulee.audio.service.AudioSercie;
import com.laulee.audio.utils.AnswerVoUtils;

@RestController
@RequestMapping("book")
public class AudioController extends BaseController{
	
	@Autowired
	private AudioSercie audioService;
	
	//一级目录
	@GetMapping("getStairList")
	public Object getStairList(){
		Map<String, Object> params = this.getParams();
		
		try {
			List<Map<String, Object>> stairList = audioService.getStairList(params);
			return AnswerVoUtils.success(stairList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return AnswerVoUtils.error("查询失败！");
	}
	
	//一级目录
		@GetMapping("getSecondLevelList")
		public Object getSecondLevelList(){
			Map<String, Object> params = this.getParams();
			try {
				List<Map<String, Object>> secondList = audioService.getSecondLevelList(params);
				return AnswerVoUtils.success(secondList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return AnswerVoUtils.error("查询失败！");
		}

}
