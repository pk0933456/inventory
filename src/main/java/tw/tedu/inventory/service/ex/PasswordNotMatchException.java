package tw.tedu.inventory.service.ex;

/**
 * 密碼錯誤異常
 */
public class PasswordNotMatchException extends ServiceException{

    private static final long serialVersionUID = 8817220044801339605L;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }
}
