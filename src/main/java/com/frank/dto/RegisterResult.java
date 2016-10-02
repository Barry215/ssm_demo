package com.frank.dto;

/**
 * 注册结果
 */
public class RegisterResult {
	/**
	 * 结果详情
	 */
	private String result;
	/**
	 * 结果代号
	 */
	private int t_error;



    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getT_error() {
		return t_error;
	}

	public void setT_error(int t_error) {
		this.t_error = t_error;
	}

	@Override
	public String toString() {
		return "RegisterResult [result=" + result + ", t_error=" + t_error
				+ "]";
	}

	public RegisterResult(int t_error,String result) {
		this.result = result;
		this.t_error = t_error;
	}

	public RegisterResult() {
	}
}
