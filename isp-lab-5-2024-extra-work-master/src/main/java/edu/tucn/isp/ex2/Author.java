package edu.tucn.isp.ex2;

import java.time.LocalDate;

record Author(String firstName, String lastName, LocalDate dateOfBirth) {

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }


    public boolean equalsIgnoreCase(String otherLastName) {
        return this.lastName.equalsIgnoreCase(otherLastName);
    }

}