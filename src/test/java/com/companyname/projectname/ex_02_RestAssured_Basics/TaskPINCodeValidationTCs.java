package com.companyname.projectname.ex_02_RestAssured_Basics;

import com.companyname.projectname.utils.APIUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.companyname.projectname.utils.APIUtils.validatePincodeAndStstusCode;

public class TaskPINCodeValidationTCs {

    @DataProvider(name = "pinCode and statusCode")
    public Object[][] getData() {//
        return new Object[][]{
                {"@", 404},
                {"123", 404},
                {"ABCDE", 404},
                {"5600", 404},
                {"9999999", 404},
                {"12@34", 404},
                {"000000", 404},
                {"-56001", 404},
                {"56001A", 404},
                {" ", 404},
                {"560001", 200}
        };
    }
    @Test(dataProvider = "pinCode and statusCode")/*pinCode and statusCode This is the same in line 11
    and this line so the connection is happening to read the data.*/
    public void testPincode(String pincode, int expectedStatusCode) {
        validatePincodeAndStstusCode(pincode, expectedStatusCode);
    }
}
