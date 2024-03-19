/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class AccountDAO extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account getAccountByUserAndPass(String user, String password) {

        String query = "select * from Account\n"
                + "  where username = ? and password = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, user);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                Account account = new Account(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8));

                return account;
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }

    public void updateAccount(int userId, String fullName,
            String email, String phone, String location) {

        String query = "UPDATE [dbo].[Account]\n"
                + "   SET \n"
                + "       [fullName] = ?,\n"
                + "       [email] = ?,\n"
                + "       [phone] = ?,\n"
                + "       [location] = ?\n"
                + "   WHERE Account.userID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, location);
            ps.setInt(5, userId);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public List<Account> getAllAccount() {
        String query = "select * from Account";

        List<Account> listAccounts = new ArrayList<>();

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listAccounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            return listAccounts;
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return null;
    }

    public boolean checkUserDupplicate(String userName) {

        Account account = null;

        String query = "select * from Account\n"
                + "where username = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            if (rs.next()) {
                account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return account != null;
    }

    public void UpdatePassAccount(Account acc, String newPass) {
        int userID = acc.getUserID();

        String query = "UPDATE [dbo].[Account]\n"
                + "SET [password] = ?\n"
                + "where Account.userID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, newPass);
            ps.setInt(2, userID);
            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public void insertNewAccount(String userName, String password, String name,
            String phone, String email, String location, int roleId) {
        String query = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[fullName]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[location]\n"
                + "           ,[roleID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, location);
            ps.setInt(7, roleId);
            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public Account getAccountByEmail(String email) {
        String query = "  select * from Account\n"
                + "  where Account.email = ?;";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }

    public void deleteAccountByID(int userID) {

        int orderDetailID = checkAccountContainInOrderDetail(userID);

        if (orderDetailID != 0) {

            String query1 = "delete from OrderItem\n"
                    + "  where OrderDetailD = ?";

            try {
                ps = connection.prepareStatement(query1);

                ps.setInt(1, orderDetailID);

                ps.executeUpdate();

            } catch (SQLException exception) {
                System.out.println(exception);
            }

            String query2 = "delete from OrderDetail\n"
                    + "  where OrderDetail.UserID = ?";

            try {
                ps = connection.prepareStatement(query2);

                ps.setInt(1, userID);

                ps.executeUpdate();

            } catch (SQLException exception) {
                System.out.println(exception);
            }

            String query3 = "DELETE FROM [dbo].[Account]\n"
                    + "where Account.userID = ?";

            try {
                ps = connection.prepareStatement(query3);

                ps.setInt(1, userID);

                ps.executeUpdate();

            } catch (SQLException exception) {
                System.out.println(exception);
            }
        } else {
            String query3 = "DELETE FROM [dbo].[Account]\n"
                    + "where Account.userID = ?";

            try {
                ps = connection.prepareStatement(query3);

                ps.setInt(1, userID);

                ps.executeUpdate();

            } catch (SQLException exception) {
                System.out.println(exception);
            }
        }

    }

    public void updateAccountInEditManagement(int userID, String password, String name, String phone, String location) {
        String query = "UPDATE [dbo].[Account]\n"
                + "   SET [password] = ?,\n"
                + "       [fullName] = ?, \n"
                + "       [phone] = ?, \n"
                + "       [location] = ?\n"
                + "where Account.userID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, password);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, location);
            ps.setInt(5, userID);

            ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public List<Account> searchAccountByUser(String userFind) {

        List<Account> list = new ArrayList<>();

        String query = "SELECT *\n"
                + "FROM [MyProject].[dbo].[Account]\n"
                + "where Account.username like ?;";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, "%" + userFind + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));

                list.add(account);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }

        return list;
    }

    public Account getAccountByUserID(int userID) {
        String query = "select * from Account\n"
                + "  where userID = ?;";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, userID);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }

    private int checkAccountContainInOrderDetail(int userID) {

        String query = "select *  from OrderDetail\n"
                + "  where OrderDetail.UserID = ?";
        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, userID);

            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return 0;
    }

    public static void main(String[] args) {
        AccountDAO adao = new AccountDAO();
        adao.deleteAccountByID(14);

    }

    public Account getAccountByOrderDetailId(int orderDetailId) {
        String query = "  select Account.* from OrderDetail\n"
                + "  join Account on OrderDetail.UserID = Account.userID\n"
                + "  where OrderDetaiID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, orderDetailId);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }

}
