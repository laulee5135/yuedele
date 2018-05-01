package com.laulee.audio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.minidev.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 */
@Component
public class BaseController {

    protected final static Logger logger = LoggerFactory.getLogger(BaseController.class);
//    @Value("${service.no}")
//    private String serviceNo;

//    public String getUniqueNo(){
//        return serviceNo + OrderSingleton.getInstance().getOrderSn();
//    }

    public Map<String,String> getParam(){
        HttpServletRequest request = getRequest();
        return getParam(request);
    }

    public Map<String,Object> getParams(){
        HttpServletRequest request = getRequest();
        return getParams(request);
    }


    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public HttpSession findSession(){
        HttpServletRequest request = getRequest();

        HttpSession session = request.getSession();
        return  session;
    }



    public static Map<String,String> getParam(HttpServletRequest request){
        Map properties = request.getParameterMap();
//        Object data = request.getAttribute(Conts.TOKEN_DATA);
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }

        logger.info(request.getServletPath()+"接口访问参数:"+JSONObject.toJSONString(returnMap));
//        returnMap.put(Conts.TOKEN_DATA,data);
        String ip = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        returnMap.put("sourcesIp",ip);
        return returnMap;
    }

    public static Map<String,Object> getParams(HttpServletRequest request){
        Map properties = request.getParameterMap();
//        Object data = request.getAttribute(Conts.TOKEN_DATA);
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }

//        logger.info(request.getServletPath()+"接口访问参数:"+JSONObject.toJSONString(returnMap));
//        returnMap.put(Conts.TOKEN_DATA,data);

        String ip = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        }else{
            ip = request.getHeader("x-forwarded-for");
        }
        returnMap.put("sourcesIp",ip);
        return returnMap;
    }
}
