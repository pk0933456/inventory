package tw.tedu.inventory.service.ex;

public class NoPermissionsException extends ServiceException{

    private static final long serialVersionUID = 3816577888010460113L;

    public NoPermissionsException() {
    }

    public NoPermissionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoPermissionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionsException(String message) {
        super(message);
    }

    public NoPermissionsException(Throwable cause) {
        super(cause);
    }
}
