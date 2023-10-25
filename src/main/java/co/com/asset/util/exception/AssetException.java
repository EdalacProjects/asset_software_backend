package co.com.asset.util.exception;

import org.springframework.http.HttpStatus;

public class AssetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus statusCode = HttpStatus.NOT_FOUND;

	public AssetException() {
		super();
	}

	public AssetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssetException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssetException(String message) {
		super(message);
	}

	public AssetException(Throwable cause) {
		super(cause);
	}
	
	public AssetException(String message, HttpStatus statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
}