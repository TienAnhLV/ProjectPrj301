/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.Account;
import enity.OrderCart;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderCartDao extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<OrderCart> getAllOrderCart() {

        List<OrderCart> list = new ArrayList<>();

        String query = "  select \n"
                + "  OrderDetail.OrderDetaiID, Account.fullName,OrderDetail.LocationOrder,\n"
                + "  sum(OrderItem.Quanity * Product.price) as [Total],\n"
                + "  OrderDetail.status,OrderDetail.comment\n"
                + "  from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  join OrderItem on OrderDetail.OrderDetaiID = OrderItem.OrderDetailD\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  group by OrderDetail.OrderDetaiID, Account.fullName,\n"
                + "  OrderDetail.LocationOrder,OrderDetail.status,OrderDetail.comment";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                OrderCart oc = new OrderCart(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6));

                list.add(oc);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public String getNameByUserID(int userID) {

        AccountDAO aO = new AccountDAO();

        Account account = aO.getAccountByUserID(userID);

        return account.getFullName();
    }

    public double getTotalProductByOrderID(int orderDetailID) {

        String query = "SELECT sum(OrderItem.Quanity * Product.price)\n"
                + "FROM [MyProject].[dbo].[OrderItem]\n"
                + "join Product on OrderItem.ProductID = Product.productID\n"
                + "where OrderItem.OrderDetailD = ?";

        double sum = 0;

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, orderDetailID);

            rs = ps.executeQuery();

            if (rs.next()) {
                sum = rs.getDouble(1);
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return sum;
    }

    public static void main(String[] args) {
        OrderCartDao cartDao = new OrderCartDao();

        List<OrderCart> list = cartDao.getAllOrderCart();

        for (OrderCart orderCart : list) {
            System.out.println(orderCart.toString());
        }

    }

    public List<OrderCart> getOrderCartByName(String fullname) {

        List<OrderCart> list = new ArrayList<>();

        String query = "  select OrderDetail.OrderDetaiID, Account.fullName,OrderDetail.LocationOrder,\n"
                + "  sum(OrderItem.Quanity * Product.price) as [Total],\n"
                + "  OrderDetail.status,OrderDetail.comment\n"
                + "  from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  join OrderItem on OrderDetail.OrderDetaiID = OrderItem.OrderDetailD\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  where Account.fullName like ?\n"
                + "  group by OrderDetail.OrderDetaiID, Account.fullName,\n"
                + "  OrderDetail.LocationOrder,OrderDetail.status,OrderDetail.comment";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, "%" + fullname + "%");

            rs = ps.executeQuery();

            while (rs.next()) {

                OrderCart oc = new OrderCart(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6));

                list.add(oc);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<OrderCart> getAllOrderCartByUserID(int userID) {
        List<OrderCart> list = new ArrayList<>();

        String query = "  select OrderDetail.OrderDetaiID, Account.fullName,OrderDetail.LocationOrder,\n"
                + "  sum(OrderItem.Quanity * Product.price) as [Total],\n"
                + "  OrderDetail.status,OrderDetail.comment\n"
                + "  from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  join OrderItem on OrderDetail.OrderDetaiID = OrderItem.OrderDetailD\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  where Account.userID = ?\n"
                + "  group by OrderDetail.OrderDetaiID, Account.fullName,\n"
                + "  OrderDetail.LocationOrder,OrderDetail.status,OrderDetail.comment";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, userID);

            rs = ps.executeQuery();

            while (rs.next()) {

                OrderCart oc = new OrderCart(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6));

                list.add(oc);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<OrderCart> getOrderCartBySatus(int statusSearch) {
        List<OrderCart> list = new ArrayList<>();

        String query = "  select OrderDetail.OrderDetaiID, Account.fullName,OrderDetail.LocationOrder,\n"
                + "  sum(OrderItem.Quanity * Product.price) as [Total],\n"
                + "  OrderDetail.status,OrderDetail.comment\n"
                + "  from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  join OrderItem on OrderDetail.OrderDetaiID = OrderItem.OrderDetailD\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  where OrderDetail.status = ?\n"
                + "  group by OrderDetail.OrderDetaiID, Account.fullName,\n"
                + "  OrderDetail.LocationOrder,OrderDetail.status,OrderDetail.comment";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, statusSearch);

            rs = ps.executeQuery();

            while (rs.next()) {

                OrderCart oc = new OrderCart(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6));

                list.add(oc);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;

    }

    public List<OrderCart> getAllOrderCartByUserIDAndStatus(int userID, int status) {
        List<OrderCart> list = new ArrayList<>();

        String query = "  select OrderDetail.OrderDetaiID, Account.fullName,OrderDetail.LocationOrder,\n"
                + "  sum(OrderItem.Quanity * Product.price) as [Total],\n"
                + "  OrderDetail.status,OrderDetail.comment\n"
                + "  from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  join OrderItem on OrderDetail.OrderDetaiID = OrderItem.OrderDetailD\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  where Account.userID = ? and OrderDetail.status = ?\n"
                + "  group by OrderDetail.OrderDetaiID, Account.fullName,\n"
                + "  OrderDetail.LocationOrder,OrderDetail.status,OrderDetail.comment";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, userID);
            
            ps.setInt(2, status);

            rs = ps.executeQuery();

            while (rs.next()) {

                OrderCart oc = new OrderCart(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6));

                list.add(oc);

            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

}
