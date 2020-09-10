package prilax.yk.dto.common;

import java.util.Date;

public class ApiMessageDto {

	private boolean error;

	private int code;

	private String detail;

	private String status;

	private Date timeStamp;

	public ApiMessageDto() {
	}

	public ApiMessageDto(boolean error, int code, String detail, String status) {
		this.error = error;
		this.code = code;
		this.detail = detail;
		this.status = status;
		this.timeStamp = new Date();
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
