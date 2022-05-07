package com.revature.bankingProject.models;

public class BankCustomer {

    // Encapsulated these variables/attributes to the class or instance thereof
    // Another pillar of OOP Encapsulation
    private String fname;
    private String lname;
    private String email;
    private String password;

    private int age;


//    public Trainer(){}

    // public is allowing any instance of class to leverage this command
    // This is a constructor because it's using the class name
    // This requires all atttributes defined above to be passed
    // This assigns each argument to their respective parameter variable being fname, lname, email, etc
    // We assign this instance of the objects the passed argumented.
    // So now, "this" is refering to the instance and we are setting this.fname to equal the passed arugment that was assign fname

    // Overloading constructors another subset of polymorphism
    public BankCustomer(String fname, String lname, String email, String password, int age) {
        super(); // just always there, by default of EVERY CLASS is Object
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public BankCustomer(){

    }

    public BankCustomer(String password){
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toFileString() {
        // StringBuilder, there is also a StringBuffer (it's thread-safe)
        // Is another class for Strings that allows them to be mutated
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(fname).append(",")
                .append(lname).append(",")
                .append(email).append(",")
                .append(password).append(",")
                .append(age);

        // Without changing the mutableString class from StringBuilder we wont' have an appropriate return type
        return mutableString.toString(); // We need the toString to return it to it's appropriate type
    }

    @Override //  Annotation - basically metadata
    public String toString() {
        return "Our Customer:  {" +
                "fname='" + fname + '\'' +
                ",   lname='" + lname + '\'' +
                ",   email='" + email + '\'' +
                ",   password='" + password + '\'' +
                ",   dob='" + age + '\'' +
                '}';
    }


}

