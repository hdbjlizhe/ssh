package com.zhelee.utils;

import com.zhelee.info.domain.Result;

public class ResultUtil {
	
	public final static Integer RESULT_SUCCESS=0;
	public final static Integer RESULT_ERROR=-1;
	
	public static Result<Object> success(Object data){
		Result<Object> result=new Result<Object>();
		result.setCode(RESULT_SUCCESS);
		result.setMsg("成功");
		result.setData(data);
		return result; 
	}
	
	public static Result<Object> error(String msg){
		Result<Object> result=new Result<Object>();
		result.setCode(RESULT_ERROR);
		result.setMsg(msg);
		result.setData(null);
		return result;
	} 
}
