package rs.telnet.projekat.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMsg;
	private int errorCode;
	private String errorDcm;
	
	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errorMsg, int errorCode, String errorDcm) {
		super();
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
		this.errorDcm = errorDcm;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDcm() {
		return errorDcm;
	}

	public void setErrorDcm(String errorDcm) {
		this.errorDcm = errorDcm;
	}
	
	

}
