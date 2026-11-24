/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookbridge.ui;

/**
 *
 * @author Juan Benamer
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import bookbridge.dao.BookDAO;
import bookbridge.dao.MemberDAO;
import bookbridge.service.ReservationService;
import bookbridge.reporting.ReportGenerator;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

public class MainMenu extends JFrame {

    public MainMenu() {

        setTitle("BookBridge Library System");

        setSize(700, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        /*
         * BOOK MANAGEMENT
         */

        JButton addBookButton =
                new JButton("Add Book");

        panel.add(addBookButton);

        addBookButton.addActionListener(e ->
                new AddBookForm());

        JButton viewBooksButton =
                new JButton("View Books");

        panel.add(viewBooksButton);

        viewBooksButton.addActionListener(e -> {

            BookDAO dao =
                    new BookDAO();

            StringBuilder output =
                    new StringBuilder();

            for (String book : dao.getBooks()) {

                output.append(book)
                        .append("\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    output.toString(),
                    "Book List",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        JButton editBookButton =
                new JButton("Edit Book");

        panel.add(editBookButton);

        editBookButton.addActionListener(e ->
                new EditBookForm());

        JButton deleteBookButton =
                new JButton("Delete Book");

        panel.add(deleteBookButton);

        deleteBookButton.addActionListener(e ->
                new DeleteBookForm());

        /*
         * MEMBER MANAGEMENT
         */

        JButton addMemberButton =
                new JButton("Add Member");

        panel.add(addMemberButton);

        addMemberButton.addActionListener(e ->
                new AddMemberForm());

        JButton viewMembersButton =
                new JButton("View Members");

        panel.add(viewMembersButton);

        viewMembersButton.addActionListener(e -> {

            MemberDAO dao =
                    new MemberDAO();

            StringBuilder output =
                    new StringBuilder();

            for (String member : dao.getMembers()) {

                output.append(member)
                        .append("\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    output.toString(),
                    "Member List",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        JButton editMemberButton =
                new JButton("Edit Member");

        panel.add(editMemberButton);

        editMemberButton.addActionListener(e ->
                new EditMemberForm());

        JButton deleteMemberButton =
                new JButton("Delete Member");

        panel.add(deleteMemberButton);

        deleteMemberButton.addActionListener(e ->
                new DeleteMemberForm());

        /*
         * LOANS & RESERVATIONS
         */

        JButton issueButton =
                new JButton("Issue Book");

        panel.add(issueButton);

        issueButton.addActionListener(e ->
                new IssueBookForm());

        JButton returnButton =
                new JButton("Return Book");

        panel.add(returnButton);

        returnButton.addActionListener(e ->
                new ReturnBookForm());

        JButton reserveButton =
                new JButton("Reserve Book");

        panel.add(reserveButton);

        reserveButton.addActionListener(e ->
                new ReserveBookForm());

        JButton cancelButton =
                new JButton("Cancel Reservation");

        panel.add(cancelButton);

        cancelButton.addActionListener(e ->
                new CancelReservationForm());

        /*
         * TOOLS
         */

        JButton searchButton =
                new JButton("Search Book");

        panel.add(searchButton);

        searchButton.addActionListener(e -> {

            String keyword =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Title:"
                    );

            if (keyword == null) {
                return;
            }

            BookDAO dao =
                    new BookDAO();

            StringBuilder output =
                    new StringBuilder();

            for (String book :
                    dao.searchBooks(keyword)) {

                output.append(book)
                        .append("\n");
            }

            if (output.isEmpty()) {

                output.append("No books found.");
            }

            JOptionPane.showMessageDialog(
                    this,
                    output.toString(),
                    "Search Results",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        JButton sortButton =
                new JButton("Sort Books");

        panel.add(sortButton);

        sortButton.addActionListener(e -> {

            BookDAO dao =
                    new BookDAO();

            StringBuilder output =
                    new StringBuilder();

            for (String book :
                    dao.sortBooks()) {

                output.append(book)
                        .append("\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    output.toString(),
                    "Sorted Books",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        JButton queueButton =
                new JButton("Process Queue");

        panel.add(queueButton);

        queueButton.addActionListener(e -> {

            ReservationService service =
                    new ReservationService();

            JOptionPane.showMessageDialog(
                    this,
                    service.processNextReservation(),
                    "Queue Processing",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        JButton refreshButton =
                new JButton("Refresh");

        panel.add(refreshButton);

        refreshButton.addActionListener(e -> {
            dispose();
            new MainMenu();
        });

        /*
         * REPORTS
         */

        JButton reportButton =
                new JButton("Generate Report");

        panel.add(reportButton);

        reportButton.addActionListener(e -> {

            ReportGenerator report =
                    new ReportGenerator();

            JOptionPane.showMessageDialog(
                    this,
                    report.generateReport(),
                    "BookBridge Report",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {

        new MainMenu();
    }
}