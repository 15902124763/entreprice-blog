package com.yarm.blog.pojo.web;

public class AjaxResult<T> {

	public AjaxResult(){
		this.errorStr = "";
		this.success = true;
	}
	
	public AjaxResult(String errorStr){
		this.errorStr = errorStr;
		this.success = false;
	}
	
	private T result ;
	
	private boolean success;
	
	private String errorStr;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorStr() {
		return errorStr;
	}

	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}

	@Override
	public String toString() {
		return "AjaxResult [result=" + result + ", success=" + success + ", errorStr=" + errorStr + "]";
	}
}
