package com.companyname.projectname.ex_02_RestAssured_Basics;

public class API_testing_Non_Builder_Pattern {
    public void step1() {
        System.out.println("Step 1");
    }
    public void step2() {
        System.out.println("Step 2");
    }
    public void step3(String param1) {
        System.out.println("Step 3");
    }
    public static void main(String[] args) {
        API_testing_Non_Builder_Pattern np = new API_testing_Non_Builder_Pattern();
        np.step1();
        np.step2();
        np.step3("Darsh");
    }
}
