package com.huare.demo;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 拦截处理类
 * 
 * @author Minbo.He
 */
@Component
public class MyHttpInterceptor extends HandlerInterceptorAdapter {

	protected static Logger logger = LoggerFactory.getLogger(MyHttpInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String queryString = "";
		// 去掉最后一个空格
		Map<String, String[]> params = request.getParameterMap();
		//Map<String,Object> bodyString = this.getBodyString(request);

		/*if(params.isEmpty()){
            for (String key : bodyString.keySet()) {
                String s = JSON.toJSONString(bodyString.get(key)+"");
                queryString += key + "=" + s;
            }
        }else {*/
            for (String key : params.keySet()) {
                String[] values = params.get(key);
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    queryString += key + "=" + value + "&";
                }
            }
//        }
		queryString = queryString.equals("") ? null : queryString.substring(0, queryString.length() - 1);
		logger.info(String.format("请求参数, url: %s, method: %s, params: %s", url, method, queryString));
		
		return true;
	}


	public static Map getBodyString(ServletRequest request) {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			logger.warn("getBodyString出现问题！");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return JSON.parseObject(sb.toString(),Map.class);
	}

}