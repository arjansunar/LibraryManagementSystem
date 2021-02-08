package GUI.route;

import GUI.dependencies.CreateFrame;
import GUI.dependencies.CreateFrameOnButtonClick;
import GUI.dependencies.GoHomeButton;
import database.Database;
import database.model.Book;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewBook {
  public static void createViewBook(CreateFrame frame, String text, Database db ) throws SQLException {
    var viewFrame= CreateFrameOnButtonClick.createFrame(frame,text,400);
    var homeButton =GoHomeButton.createButton(viewFrame,frame);

    JTable table;
    JScrollPane scrollPane;

    var deleteButton = new JButton("Delete");
    var updateButton = new JButton("Update");
    var finalPanel= new JPanel();
    var panel = new JPanel();
    var buttonPanel = new JPanel();

    ArrayList<Book> books =db.viewBook();
    String[] column={"Book ID","Name","Price","Availability","Author"};
    String[][] rows = new String[books.size()][5];

    for (int i = 0; i < rows.length; i++) {
      Book book= books.get(i);
      rows[i][0]= book.getBookId();
      rows[i][1]= book.getName();
      rows[i][2]= String.valueOf(book.getPrice());
      rows[i][3]= String.valueOf(book.isAvailable());
      rows[i][4]= book.getAuthor();
    }
    table = new JTable(rows,column);
    scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(
            500,200));
    System.out.println("Books"+ books);

    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(homeButton);

    panel.setLayout(new GridLayout(0,1,0,40));
    panel.add(scrollPane);
    panel.add(buttonPanel);

    finalPanel.add(panel);
    viewFrame.add(finalPanel);

    //button click events
    deleteButton.addActionListener(e->{
      var bookIDField= new JTextField(5);
      JOptionPane optionPane= new JOptionPane("Enter Book ID to delete:");
      optionPane.add(bookIDField);
      optionPane.setVisible(true);

      String bookID= bookIDField.getText();
      System.out.println(bookID);
    });


  }
}
