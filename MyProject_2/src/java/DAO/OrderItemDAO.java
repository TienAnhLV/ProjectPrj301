/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.Item;
import enity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderItemDAO extends DBcontext.DBContext {

    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void insertOrderItem(int orderDetailID, int productID, int quanity) {
        String query = "INSERT INTO [dbo].[OrderItem]\n"
                + "           ([OrderDetailD]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quanity])\n"
                + "     VALUES\n"
                + "           (?,?,?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, orderDetailID);
            ps.setInt(2, productID);
            ps.setInt(3, quanity);

            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public List<Item> getListItemByOrderDetailId(int orderIDnew) {
        String query = "select Product.*, OrderItem.Quanity from OrderItem\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  where OrderItem.OrderDetailD = ?";

        List<Item> list = new ArrayList<>();

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, orderIDnew);

            rs = ps.executeQuery();
            
            while(rs.next()){
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), 
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                
                int quanity = rs.getInt(8);
                
                list.add(new Item(p,quanity));
            }
            return list;
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }
}
