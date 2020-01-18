package ley.untis.exception;

public class APIRequestException extends Exception {

    Throwable source;

    public APIRequestException(Throwable error) {
        source = error;
    }

    @Override
    public String getMessage() {
        return source.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return source.getLocalizedMessage();
    }
}
