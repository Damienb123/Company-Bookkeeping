# Employee Payroll and Utility Management System


## Table of Contents

1. [Overview](#Overview)
2. [Features](#Features)
3. [Class and Interface Descriptions](#Class-and-Interface-Descriptions)
    - PayableEntity Interface
    - Employee Abstract Class
    - HourlyEmployee Class
    - SalariedEmployee Class
    - CommissionEmployee Class
    - LimitedCommissionEmployee Class
    - Utility Class
    - Company Class
   
 ## Usage
- Compilation and Execution
- Example Output
- Main Method Demonstration
  
## Overview
### Description
The Employee Payroll and Utility Management System is a Java-based application designed to manage and calculate payroll and utility expenses for companies. The system supports various types of employees, including hourly, salaried, and commission-based employees, as well as utilities that companies may incur.

This project demonstrates object-oriented programming principles by utilizing interfaces and abstract classes to represent different types of employees and utilities. The Company class serves as a container for employees and utilities, providing methods to add new employees and utilities, calculate total expenditures, and generate detailed payroll and utility reports.

The key functionalities of the system include:

- Calculation of pre-bonus and total pay for different types of employees.
- Management of utility costs based on usage and rates.
- Generation of detailed payroll and utility listings.
- Calculation of total expenditures for a company, including both payroll and utility costs.

By running the main method provided, users can see an example of how to create instances of companies, add employees and utilities, and display the payroll and utility information along with the total expenditures. This makes the system a practical tool for understanding and implementing payroll and utility management in a business context.

## Features

1. Employee Management
    - Hourly Employees: Calculate pay based on hours worked with support for overtime.
    - Salaried Employees: Calculate pay based on a fixed weekly salary.
    - Commission Employees: Calculate pay based on a percentage of sales.
    - Limited Commission Employees: Calculate pay with a base salary and a capped commission.

2. Utility Management
    - Electricity and Water Utilities: Calculate utility costs based on usage rates and base fees.
    - Internet and Other Utilities: Manage fixed utility costs with base fees.

3. Payroll Calculation
    - Calculate pre-bonus and total pay for each employee type.
    - Support for setting and calculating bonuses for employees.

4. Utility Calculation
    - Calculate total costs based on usage and rates.
    - Include fixed base fees in the utility cost calculation.

5. Expenditure Calculation
    - Calculate total payroll expenditures for all employees.
    - Calculate total utility expenditures for all utilities.
    - Calculate overall total expenditures for a company, combining payroll and utility costs.

6. Reporting
    - Generate detailed payroll listings for a company, displaying employee details, pre-bonus pay, and total pay.
    - Generate detailed utility listings for a company, displaying utility names and bill amounts.

7. Company Management
    - Add employees and utilities to a company.
    - Support for multiple companies with separate employee and utility records.

8. Global Employee Count
    - Track and display the total number of employees across all companies.

These features together provide a comprehensive system for managing and calculating payroll and utility expenses in a business environment.


## Class and Interface Descriptions

PayableEntity Interface
```
public interface PayableEntity {
    double amountOwed();
}
```
 Purpose and functionality of the PayableEntity interface.


Employee Abstract Class
```
abstract class Employee implements PayableEntity {
    // class implementation
}
```
 Purpose and functionality of the Employee abstract class:

HourlyEmployee Class
```
class HourlyEmployee extends Employee {
    // class implementation
}
```
Purpose of the HourlyEmployee class and how it calculates pay based on hours worked:


SalariedEmployee Class
```
class SalariedEmployee extends Employee {
    // class implementation
}
```
Purpose of the SalariedEmployee class and its fixed weekly pay structure:

CommissionEmployee Class
```
class CommissionEmployee extends Employee {
    // class implementation
}
```
Purpose of the CommissionEmployee class and how it calculates 
pay based on commission rate and sales amount:


LimitedCommissionEmployee Class
```
class LimitedCommissionEmployee extends CommissionEmployee {
    // class implementation
}
```

Purpose of the LimitedComissionEmployee class, its base pay, 
and the capped commission calculation:

Utility Class
```
class Utility implements PayableEntity {
    // class implementation
}
```

Purpose of the Utiliy class and its properties for managing utility expenses:

Company Class
```
class Company {
    // class implementation
}
```

Purpose of the Company class, its methods for adding employees and utilities, and
calculating total expenditures:


# Usage

Compilation and Execution
```
javac Main.java
java Main
```
# Example Output

```
Acme Corporation Payroll
Name            Code Pay      Total Pay
Smith           HRLY $ 1050.00 $ 1050.00
...
Total employees in all companies: 9
```

