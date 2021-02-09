//this class has all the methods required for the GUI to
//connect and make changes to the database
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

  static Connection con;
  PreparedStatement statement;
  ResultSet resultSet;

  //creates a connection to the db at object creation
  public Database() throws SQLException {
    con = DriverManager.getConnection(url,username,pass);
  }

  //adds a record in the books table
  public void addBook(Book book) throws SQLException {
    sql= "Insert into books Values( ?,?,?,?,?);";
    statement= con.prepareStatement(sql);

    statement.setString(1, book.getBookId());
    statement.setString(2,book.getName());
    statement.setInt(3,book.getPrice());
    statement.setBoolean(4,book.isAvailable());
    statement.setString(5,book.getAuthor());

    statement.executeUpdate();
    statement.close();
  }

  //retrieves all the books stored in db
  public ArrayList<Book> viewBook() throws SQLException {
    sql= "Select * from books;";
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
    statement.close();
    return allBook;
  }

  //deletes a book from db according to book ID
  public void deleteBook( String bookID) throws SQLException {
    sql= "Delete from books where Book_id = ?;";
    statement= con.prepareStatement(sql);

    statement.setString(1,bookID);

    statement.executeUpdate();
    statement.close();
  }

  //updates the name of a book in db
  public void updateBookName(String bookID,String value) throws SQLException{
    sql= "Update books set Name =? where Book_id =?;";
    statement= con.prepareStatement(sql);

    statement.setString(1,value);
    statement.setString(2,bookID);

    statement.executeUpdate();
    statement.close();
  }

  //updates the name of author of a book in db
  public void updateBookAuthor(String bookID,String value) throws SQLException{
    sql= "Update books set Author =? where Book_id =?;";
    statement= con.prepareStatement(sql);

    statement.setString(1,value);
    statement.setString(2,bookID);

    statement.executeUpdate();
    statement.close();
  }

  //updates the price of a book in db
  public void updateBook(String bookID,int value) throws SQLException{
    sql= "Update books set Price=? where Book_id =?;";
    statement= con.prepareStatement(sql);

    statement.setInt(1,value);
    statement.setString(2,bookID);

    statement.executeUpdate();
    statement.close();
  }

  //updates the availability of a book in db
  public void updateBook(String bookID, boolean value) throws SQLException{
    sql= "Update books set Available=? where Book_id =?;";
    statement= con.prepareStatement(sql);

    statement.setBoolean(1,value);
    statement.setString(2,bookID);

    statement.executeUpdate();
    statement.close();
  }

  //closes the connection to the db
  public static void closeConnection() throws SQLException {
    con.close();
  }
}
