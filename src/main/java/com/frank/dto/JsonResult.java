package com.frank.dto;

/**用于包装JSON的结果
 *
 */
public class JsonResult<T> {
	private boolean success;

	private T data;

	private String err;

	/**
	 * 后台是否发生错误
	 * @return 是否发生错误
	 */
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * 获取JSON内的数据
	 * @return 数据
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 获取错误信息
	 * @return 错误信息
	 */
	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public JsonResult(boolean success, T data, String err) {
		super();
		this.success = success;
		this.data = data;
		this.err = err;
	}
	public JsonResult(boolean success, String err) {
		super();
		this.success = success;
		this.err = err;
	}

	@Override
	public String toString() {
		return "JsonResult:{" +
				"success:" + success + ", data:" + data + ", err:" + err +
				'}';
	}
}
