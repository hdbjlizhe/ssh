package com.info.utils;

import com.info.domain.pojo.Result;

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
	

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result<Object> success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result<Object> error(Integer code,String msg){
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
