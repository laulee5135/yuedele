package com.laulee.audio.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @ClassName: Answer
 * @Description: TODO
 * @author zhanghz
 * @date 2016年8月14日 下午8:08:07
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer<T> {
	// 响应码
    private int              code;
	// 时间戳
    private Long             timestamp;
	// 相应消息
    private String           message;
	// 业务信息
	private T resultObj;

	public Answer() {
        this.timestamp = System.currentTimeMillis();
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public T getResultObj() {
		return resultObj;
    }

	public void setResultObj(T resultObj) {
		this.resultObj = resultObj;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
