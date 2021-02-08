package database;

import database.model.Book;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.util.ArrayList;

public class Database {

  String url="jdbc:mysql://localhost:3306/individual_project";
  String username= "root";
  String pass= "Imgr00t!";
  String sql;

  Connection con;
  PreparedStatement statement;
  ResultSet resultSet;

  public Database() throws SQLException {
    con = DriverManager.getConnection(url,username,pass);
  }

  public void addBook(Book book) throws SQLException {
    sql= "Insert into books Values( ?,?,?,?,?)";
    statement= con.prepareStatement(sql);

    statement.setString(1, book.getBookId());
    statement.setString(2,book.getName());
    statement.setInt(3,book.getPrice());
    statement.setBoolean(4,book.isAvailable());
    statement.setString(5,book.getAuthor());

    statement.executeUpdate();
    statement.close();
  }

  public ArrayList<Book> viewBook() throws SQLException {
    sql= "Select * from books";
    statement= con.prepareStatement(sql);
    ArrayList<Book> allBook= new ArrayList<>();

    resultSet= statement.executeQuery();

    while(resultSet.next()){
      String bookId = resultSet.getString(1);
      String bookName= resultSet.getString(2);
      int price = resultSet.getInt(3);
      boolean available = resultSet.getBoolean(4);
      String author = resultSet.getString(5);

      allBook.add(new Book(bookId,bookName,price,available,author));
    }

    return allBook;
  }
}
