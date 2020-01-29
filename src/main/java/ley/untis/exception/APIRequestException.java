package ley.untis.exception;

import org.omg.CORBA.UNKNOWN;

public class APIRequestException extends Exception {

    Throwable source;
    String message;
    EnumError errorType;

    public APIRequestException(Throwable error) {
        source = error;
        message = source.getMessage();
        if (message == null) {
            errorType = EnumError.UNKNOWN;
        } else if (message.contains("no such element")) {
            errorType = EnumError.ELEMENTNOTFOUND;
        } else if (message.contains("no right")) {
            errorType = EnumError.NOPERMISSION;
        } else {
            switch (message) {
                case "bad credentials":
                    errorType = EnumError.BADCREDENTIALS;
                    break;
                case "0":
                    errorType = EnumError.SCHOOLNOTFOUND;
                    break;
                case "too many results":
                    errorType = EnumError.TOOMANYSCHOOLS;
                    break;
                case "no allowed date":
                    errorType = EnumError.DATENOTALLOWED;
                default:
                    errorType = EnumError.UNKNOWN;
                    break;
            }
        }
    }

    public EnumError getError() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        return source.getLocalizedMessage();
    }
}
