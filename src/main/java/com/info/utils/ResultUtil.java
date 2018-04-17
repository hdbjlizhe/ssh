package com.info.utils;

import com.info.domain.JsonResult;

public class ResultUtil {
	
	public final static Integer RESULT_SUCCESS=0;
	public final static Integer RESULT_ERROR=-1;
	
	public static JsonResult<Object> success(Object data){
		JsonResult<Object> result=new JsonResult<Object>();
		result.setCode(RESULT_SUCCESS);
		result.setMsg("成功");
		result.setData(data);
		return result; 
	}
	
	public static JsonResult<Object> error(String msg){
		JsonResult<Object> result=new JsonResult<Object>();
		result.setCode(RESULT_ERROR);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}
	

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static JsonResult<Object> success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult<Object> error(Integer code,String msg){
        JsonResult<Object> result = new JsonResult<Object>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
