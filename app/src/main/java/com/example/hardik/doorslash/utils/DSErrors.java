package com.example.hardik.doorslash.utils;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;

/**
 * Created by hardik on 9/18/2017.
 */

public class DSErrors {
    @SerializedName("status")
    private int mStatusCode;
    @SerializedName("message")
    private String mErrorMessage;
    private DSErrors.ErrorType mErrorType;

    public DSErrors(Throwable throwable) {
        if(throwable instanceof IOException) {
            this.mStatusCode = DSErrors.ErrorType.ErrorTypeNetwork.ordinal();
            this.mErrorType = DSErrors.ErrorType.ErrorTypeNetwork;
            this.mErrorMessage = "Network error";
        } else {
            this.mStatusCode = DSErrors.ErrorType.ErrorTypeUnknownError.ordinal();
            this.mErrorType = DSErrors.ErrorType.ErrorTypeUnknownError;
            this.mErrorMessage = "Unknown error";
        }

    }

    public DSErrors.ErrorType getErrorType() {
        return this.mErrorType;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void setErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public void setErrorType(int statusCode) {
        switch(statusCode) {
            case 401:
                this.mErrorType = DSErrors.ErrorType.ErrorTypeUnAuthorized;
                break;
            case 404:
                this.mErrorType = DSErrors.ErrorType.ErrorTypeInvalidRequest;
                break;
            case 500:
                this.mErrorType = DSErrors.ErrorType.ErrorTypeInternal;
                break;
            default:
                this.mErrorType = DSErrors.ErrorType.ErrorTypeGeneric;
        }

    }

    public DSErrors(String errorDescription, int statusCode, DSErrors.ErrorType errorType) {
        this.mErrorMessage = errorDescription;
        this.mStatusCode = statusCode;
        this.mErrorType = errorType;
    }

    public interface LibErrors {
        String NETWORK_ERROR = "Network error";
        String INTERNAL_ERROR = "Internal error";
        String UNKNOWN_ERROR = "Unknown error";
    }

    public static enum ErrorType {
        ErrorTypeNetwork,
        ErrorTypeInternal,
        ErrorTypeInvalidRequest,
        ErrorTypeUnknownError,
        ErrorTypeGeneric,
        ErrorTypeUnAuthorized;

        private ErrorType() {
        }
    }
}
