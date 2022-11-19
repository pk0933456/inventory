package tw.tedu.inventory.service.ex;

/**
 * 使用者資料不存在
 */
public class UserNotFoundException extends ServiceException{

    private static final long serialVersionUID = -6059923747318973467L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
