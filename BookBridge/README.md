1. Project Description

BookBridge is a Java-based Library Loan and Reservation Management System developed throughout the four Technical Summative Assessments. The system allows users to manage books, members, loans, reservations, and reports through a desktop application. Java Swing was used for the graphical user interface, while JDBC and MySQL were used to store and manage records. The system includes book management, member management, borrowing and return transactions, reservation processing, search and sort functions, queue processing, and report generation. The project integrates concepts learned throughout Modules 1 to 8 into a single working application.

2. Software Requirements

The following software is needed to run the project:

• Apache NetBeans IDE
• Java Development Kit (JDK 17 or later)
• XAMPP with MySQL
• MySQL JDBC Driver
• Web Browser for phpMyAdmin

3. Database Setup

The project uses a MySQL database named bookbridge_db.

To set up the database, follow these steps:

1. Open XAMPP Control Panel and start Apache and MySQL.
2. Open a browser and go to http://localhost/phpmyadmin
3. Create a new database named bookbridge_db.
4. Click the database and select Import.
5. Choose the provided schema.sql file and click Import.
6. Check if the four tables (books, members, loans, and reservations) were successfully created.

The database connection is handled by DBConnection.java, which connects the Java application to MySQL using JDBC.

4. Project Setup

1. Open Apache NetBeans.
2. Click File → Open Project.
3. Find and open the BookBridge_Final project.
4. Make sure that the MySQL JDBC Driver is added to the project's Libraries.
5. Check if the database settings in DBConnection.java match the database in XAMPP.
6. Set bookbridge.ui.MainMenu as the main class if necessary.

5. Building and Running the Project

1. Make sure MySQL is running in XAMPP.
2. Open the BookBridge_Final project in NetBeans.
3. Right-click the project and select Clean and Build.
4. Wait until the Output window displays BUILD SUCCESSFUL.
5. Right-click the project again and select Run.
6. The BookBridge application should open and display the main dashboard.

The dashboard provides the following functions:

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

If the program cannot connect to the database, check if MySQL is running in XAMPP and if the database settings in DBConnection.java are correct.

If there is an error related to JDBC, check if the MySQL JDBC Driver is added to the project’s Libraries.

If the application does not open, make sure that MainMenu.java is selected as the main class and try cleaning and building the project again.

If records do not appear, verify that the database was imported successfully and that the required tables exist.

7. Testing and Verification

I tested the system using 15 test cases to check if its different features work properly. These include adding books, managing members, borrowing and returning books, managing reservations, queue processing, searching, sorting, and report generation.

I also tested the system by closing and reopening it to check if the records were still saved in the database. 

