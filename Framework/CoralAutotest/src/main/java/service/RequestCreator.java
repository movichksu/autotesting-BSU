package service;

import model.Request;

public class RequestCreator {

    public static final String TESTDATA_REQUEST_NUMBER = "testdata.request.number";
    public static final String TESTDATA_REQUEST_PASSPORT = "testdata.request.passport";

    public static Request requestFromProperty() {
        return new Request(TestDataReader.getTestData(TESTDATA_REQUEST_NUMBER),
                TestDataReader.getTestData(TESTDATA_REQUEST_PASSPORT));
    }
}
