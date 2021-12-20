package model;

import java.util.Objects;

public class Request {
    private String requestNumber;
    private String requestPasswordNumber;

    public Request(String requestNumber, String requestPasswordNumber) {
        this.requestNumber = requestNumber;
        this.requestPasswordNumber = requestPasswordNumber;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestPasswordNumber() {
        return requestPasswordNumber;
    }

    public void setRequestPasswordNumber(String requestPasswordNumber) {
        this.requestPasswordNumber = requestPasswordNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(requestNumber, request.requestNumber) &&
                Objects.equals(requestPasswordNumber, request.requestPasswordNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestNumber, requestPasswordNumber);
    }
}
