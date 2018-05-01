package com.laulee.audio.utils;


/**
 * 数据响应工具类
 * @author LauLee
 *
 * 2017年10月14日
 */
public class AnswerVoUtils {
	
	/**
	 * 响应成功
	 * @param obj 需要返回的数据
	 * @param msg 返回的信息
	 * @param code 响应吗
	 * @return
	 */
	public static Answer success(Object obj,Integer code,String msg){
		Answer ans = new Answer<>();
		ans.setCode(code);
		ans.setMessage(msg);
		ans.setResultObj(obj);
		return ans;
	}
	
	/**
	 * 响应成功
	 * @param obj 需要返回的数据
	 * @param msg 返回的信息
	 * @return
	 */
	public static Answer success(Object obj,String msg){
		return success(obj, 1, msg);
	}
	
	/**
	 * 响应成功
	 * @param obj 需要返回的数据
	 * @return
	 */
	public static Answer success(Object obj){
		return success(obj, 1, "成功");
	}
	
	/**
	 * 响应成功
	 * @param obj 需要返回的数据
	 * @return
	 */
	public static Answer success(){
		return success(null);
	}
	
	/**
	 * 响应失败
	 * @param code 错误码
	 * @param msg  错误信息
	 * @return
	 */
	public static Answer error(Integer code, String msg) {
		Answer ans = new Answer();
        ans.setCode(code);
        ans.setMessage(msg);
        return ans;
    }
	
	/**
	 * 响应失败
	 * @param code 错误码
	 * @param msg  错误信息
	 * @return
	 */
	public static Answer error(String msg) {
		return error(0, msg);
    }

}
