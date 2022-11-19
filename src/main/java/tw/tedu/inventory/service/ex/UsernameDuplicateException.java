package tw.tedu.inventory.service.ex;

/**
 * 使用者名稱重複異常
 */
public class UsernameDuplicateException extends ServiceException {
	
	private static final long serialVersionUID = 5613867716082514541L;

	public UsernameDuplicateException() {
		super();
	}

	public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameDuplicateException(String message) {
		super(message);
	}

	public UsernameDuplicateException(Throwable cause) {
		super(cause);
	}

	
}
