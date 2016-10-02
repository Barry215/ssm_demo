package com.frank.dto;

/**
 * 登录结果
 */
public class LoginResult {
	/**
	 *  结果详情
	 */
	private String result;
	/**
	 * 结果编号
	 */
	private long resultNum;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getResultNum() {
		return resultNum;
	}

	public void setResultNum(long resultNum) {
		this.resultNum = resultNum;
	}

	@Override
	public String toString() {
		return "LoginResult [result=" + result + ", resultNum=" + resultNum
				+ "]";
	}

	public LoginResult(String result, long resultNum) {
		this.result = result;
		this.resultNum = resultNum;
	}

	public LoginResult() {
	}
}
