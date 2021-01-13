package GUI.route;

import GUI.CreateFrame;

import javax.swing.*;
import java.awt.*;

public class Home {
  public static void createHomePage(){
    //buttons
    var addBookButton = new JButton("Add book");
    var deleteBookButton = new JButton("Delete book");
    var viewBookButton = new JButton("View books");
    var issueBookButton = new JButton("Issue book");
    var returnBookButton = new JButton("Return book");

    // text objects
    var heading = new JLabel("Welcome to the Library");
    var headingPanel= new JPanel();
    headingPanel.setLayout(new FlowLayout());
    headingPanel.add(heading);

    // panel with all the buttons
    var buttonGroup = new JPanel();
    buttonGroup.setLayout(new GridLayout(5,1,0,5));
//    buttonGroup.setPreferredSize(new Dimension(120,200));

    //adding buttons to panel
    buttonGroup.add(addBookButton);
    buttonGroup.add(deleteBookButton);
    buttonGroup.add(viewBookButton);
    buttonGroup.add(issueBookButton);
    buttonGroup.add(returnBookButton);

    var homePanel= new JPanel();

//    homePanel.setLayout();
    homePanel.setPreferredSize(new Dimension(135,300));
    homePanel.setLayout( new BoxLayout(homePanel,BoxLayout.Y_AXIS));
//    homePanel.setBounds(200,200,135,300);
    homePanel.add(headingPanel);
    homePanel.add(buttonGroup);

    CreateFrame frame = new CreateFrame(500,500,"Library management system");
    frame.add(homePanel);

    //adding action listener
    addBookButton.addActionListener(e -> AddBook.createAddBook(frame,"add book"));
    deleteBookButton.addActionListener(e -> {
      DeleteBook.createDeleteBook(frame,"delete book");
    });
    viewBookButton.addActionListener(e -> {
      ViewBook.createViewBook(frame,"view book");
    });
    issueBookButton.addActionListener(e -> {
      IssueBook.createIssueBook(frame,"issue book");
    });
    returnBookButton.addActionListener(e -> {
      ReturnBook.createIssueBook(frame,"return book");
    });
  }
}
