package tw.tedu.inventory.service.ex;

public class AccessDeniedException extends ServiceException{

    private static final long serialVersionUID = 8685333451118615035L;

    public AccessDeniedException() {
    }

    public AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }
}
