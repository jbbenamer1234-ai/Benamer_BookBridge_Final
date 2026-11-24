BOOKBRIDGE FINAL PROJECT

1. Project Description

BookBridge is a Java-based Library Loan and Reservation Management System developed as the final project for Object-Oriented Programming Laboratory. The project integrates concepts from TSA1, TSA2, TSA3, TSA4, and the final integration assessment.

The system allows users to manage books, members, loans, reservations, and reports through a desktop application. Java Swing was used to create the graphical user interface, while JDBC and MySQL were used to provide persistent storage for records.

The application includes catalog management, member management, borrowing and return transactions, reservation processing, queue management, searching, sorting, and report generation.

2. Software Requirements

The following software is required to run the project:

• Apache NetBeans IDE
• Java Development Kit (JDK 17 or later)
• XAMPP with MySQL
• MySQL JDBC Driver
• Web Browser for phpMyAdmin

3. Database Setup

The project uses a MySQL database named:

bookbridge_db

To set up the database:

1. Open XAMPP Control Panel.
2. Start Apache and MySQL.
3. Open a browser and go to:

http://localhost/phpmyadmin

4. Create a new database named:

bookbridge_db

5. Click the database and select Import.
6. Choose the provided schema.sql file and click Import.
7. Verify that the following tables were successfully created:

• books
• members
• loans
• reservations

The database connection is handled by DBConnection.java, which connects the Java application to MySQL using JDBC.

4. Project Setup

1. Open Apache NetBeans.
2. Click File → Open Project.
3. Locate and open the BookBridge_Final project.
4. Verify that the MySQL JDBC Driver has been added to the project's Libraries.
5. Check if the database settings in DBConnection.java match the local database settings.
6. Set bookbridge.ui.MainMenu as the main class if necessary.

5. Building and Running the Project

1. Make sure MySQL is running in XAMPP.
2. Open the BookBridge_Final project in NetBeans.
3. Right-click the project and select Clean and Build.
4. Wait until the Output window displays:

BUILD SUCCESSFUL

5. Right-click the project again and select Run.
6. The BookBridge Library System main dashboard should open.

The application provides the following functions:

• Add Book
• View Books
• Edit Book
• Delete Book
• Add Member
• View Members
• Edit Member
• Delete Member
• Issue Book
• Return Book
• Reserve Book
• Cancel Reservation
• Search Book
• Sort Books
• Process Queue
• Refresh
• Generate Report

6. Troubleshooting

Database Connection Error

If the program cannot connect to the database:

• Verify that MySQL is running in XAMPP.
• Verify that bookbridge_db exists.
• Verify that the credentials inside DBConnection.java are correct.

JDBC Driver Error

If a JDBC-related error occurs:

• Verify that the MySQL JDBC Driver has been added to the project libraries.

Application Does Not Launch

If the application fails to start:

• Perform Clean and Build again.
• Verify that MainMenu.java is selected as the startup class.
• Resolve any compilation errors shown in the Output window.

7. Testing and Verification

The system was tested using fifteen documented test cases covering:

• Add Book
• View Books
• Search Book
• Sort Books
• Add Member
• View Members
• Edit Member
• Delete Member
• Issue Book
• Return Book
• Reserve Book
• Cancel Reservation
• Process Queue
• Generate Report

The completed test results and screenshots are included in the Final Test Report.

8. Repository Structure

BookBridge_TSA1/
BookBridge_TSA2/
BookBridge_TSA3/
BookBridge_TSA4/
BookBridge_Final/
README.docx

The repository preserves milestone evidence from TSA1 to TSA4 and demonstrates the evolution of the project from a console application into a complete Swing and JDBC-based desktop application.

9. Author

Juan Margaux O. Benamer

Section: TN22

GitHub Repository:
https://github.com/jbbenamer1234-ai/Benamer_BookBridge_Final

10. Academic Declaration

This project was developed as part of the Object-Oriented Programming Laboratory course. The final system integrates concepts, requirements, and features from TSA1, TSA2, TSA3, TSA4, and the BookBridge Final Project.
