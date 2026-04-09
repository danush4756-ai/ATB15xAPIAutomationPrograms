package com.companyname.projectname.ex_02_RestAssured_Basics;

public class API_testing_Non_Builder_Pattern_02 {
    public API_testing_Non_Builder_Pattern_02 step1() {
        System.out.println("Step 1");
        return this;
    }
    public API_testing_Non_Builder_Pattern_02 step2() {
        System.out.println("Step 2");
        return this;
    }
    public API_testing_Non_Builder_Pattern_02 step3(String param1) {
        System.out.println("Step 3");
        return this;
    }
    public static void main(String[] args) {
        API_testing_Non_Builder_Pattern_02 np = new API_testing_Non_Builder_Pattern_02();
        np.step1().step2().step3("Darsh");
    }
}
