package tw.tedu.inventory.service.ex;

public class DeleteException extends ServiceException{

    private static final long serialVersionUID = 60563922517899282L;

    public DeleteException() {
    }

    public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }
}
