package tw.tedu.inventory.service.ex;

/**
 * 業務異常 是所有業務拋出異常的基礎類
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 2841838029589643524L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	
}
