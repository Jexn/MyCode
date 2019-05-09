package Dao;

import Bean.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BookUtil
 * @description: 书籍获取
 * @author: Cube
 * @create: 2019-05-05 14:56
 **/
public class BookUtil {
    private static Map<Integer, Book> map = new HashMap<>();

    public static Map<Integer, Book> getAllBook() {
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select id,name,price,author from shoppingcart.books")
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String author = resultSet.getString("author");

                Book book = new Book(id, name, price, author);
                map.put(book.getId(), book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Book findBookById(int id) {
        Book book = null;
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select id,name,price,author from shoppingcart.books where id = ?")
        ) {
            preparedStatement.setString(1, id + "");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Integer Book_id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Double price = resultSet.getDouble("price");
                    String author = resultSet.getString("author");
                    book = new Book(Book_id, name, price, author);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return book;
    }
}
