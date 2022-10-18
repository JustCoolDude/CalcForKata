class ThrowsException extends Exception {
    public ThrowsException() {


    }

    public ThrowsException(String message) {
        super(message);
    }

    public ThrowsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThrowsException(Throwable cause) {
        super(cause);
    }

    protected ThrowsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}