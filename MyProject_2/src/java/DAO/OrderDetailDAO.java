/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.OrderDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class OrderDetailDAO extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public void insertOrderDetail(String dateString, int userID, String locationOrderDate, int payMethod) {
        String query = "INSERT INTO [dbo].[OrderDetail]\n"
                + "           ([OrderDate]\n"
                + "           ,[UserID]\n"
                + "           ,[LocationOrder]\n"
                + "           ,[PayMethodID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, dateString);
            ps.setInt(2, userID);
            ps.setString(3, locationOrderDate);
            ps.setInt(4, payMethod);

            ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public int getCountOrderDetail() {
        int count = 0;

        String query = "SELECT top 1 OrderDetaiID\n"
                + "  FROM [dbo].[OrderDetail] order by OrderDetaiID desc";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return count;
    }

    public OrderDetail getOrderDetailByID(int orderIDnew) {
        String query = "SELECT *\n"
                + "  FROM [dbo].[OrderDetail]\n"
                + "  where OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, orderIDnew);
            rs = ps.executeQuery();
            if (rs.next()) {
                OrderDetail od = new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                return od;
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }

    public void updateOrderDetaolByOrderID(int orderID, String location, int status, String comment) {
        String query = "UPDATE [dbo].[OrderDetail]\n"
                + "   SET [LocationOrder] = ?\n"
                + "      ,[status] = ?\n"
                + "      ,[comment] = ?\n"
                + " WHERE OrderDetail.OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, location);
            ps.setInt(2, status);
            ps.setString(3, comment);
            ps.setInt(4, orderID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void deleteOrderDetailByOrderDetailId(int orderDetailID) {

        String query1 = "  delete from OrderItem\n"
                + "  where OrderDetailD = ?";

        try {
            ps = connection.prepareStatement(query1);

            ps.setInt(1, orderDetailID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        String query2 = "  delete  from OrderDetail\n"
                + "  where OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query2);

            ps.setInt(1, orderDetailID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void updateStatusOrderDetaolByOrderID(int orderDetailID, int status) {
        String query = "UPDATE [dbo].[OrderDetail]\n"
                + "   SET [status] = ?\n"
                + " WHERE OrderDetail.OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, orderDetailID);
            ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void updateLocationByID(int orderID, String location) {
        String query = "UPDATE [dbo].[OrderDetail]\n"
                + "   SET [LocationOrder] = ?\n"
                + " WHERE OrderDetail.OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, location);
            ps.setInt(2, orderID);
            ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

}
