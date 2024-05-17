Employee Payroll and Utility Management System
Table of Contents

    Overview
    Features
    Class and Interface Descriptions
        PayableEntity Interface
        Employee Abstract Class
        HourlyEmployee Class
        SalariedEmployee Class
        CommissionEmployee Class
        LimitedCommissionEmployee Class
        Utility Class
        Company Class
    Usage
        Compilation and Execution
        Example Output
    Main Method Demonstration
    License

Overview

Provide a brief description of the project, its purpose, and its key functionalities.

Features

List and describe the main features of the project.


Class and Interface Descriptions

PayableEntity Interface
public interface PayableEntity {
    double amountOwed();
}

Purpose and functionality:


Employee Abstract Class
abstract class Employee implements PayableEntity {
    // class implementation
}

Purpose and functionality:


HourlyEmployee Class
class HourlyEmployee extends Employee {
    // class implementation
}

Describing the HourlyEmployee class and how it calculates pay based on hours worked:

SalariedEmployee Class
class SalariedEmployee extends Employee {
    // class implementation
}

Describing the SalariedEmployee class and its fixed weekly pay structure:

CommissionEmployee Class
class CommissionEmployee extends Employee {
    // class implementation
}

Describing the CommissionEmployee class and how it calculates 
pay based on commission rate and sales amount:


LimitedCommissionEmployee Class
class LimitedCommissionEmployee extends CommissionEmployee {
    // class implementation
}


Describe the LimitedComissionEmployee class, its base pay, 
and the capped commission calculation:

Utility Class
class Utility implements PayableEntity {
    // class implementation
}

Purpose of the Utiliy class and its properties for managing utility expenses:

Company Class
class Company {
    // class implementation
}

Purpose of the Company class, its methods for adding employees and utilities, and
calculating total expenditures:


Usage
Compilation and Execution

javac Main.java
java Main

Example Output

Acme Corporation Payroll
Name            Code Pay      Total Pay
Smith           HRLY $ 1050.00 $ 1050.00
...
Total employees in all companies: 9


