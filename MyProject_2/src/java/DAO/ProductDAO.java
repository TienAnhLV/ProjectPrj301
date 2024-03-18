/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.Category;
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
public class ProductDAO extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getListProductSale() {
        List<Product> list = new ArrayList<>();

        String query = "select top 6 * from Product\n"
                + "  order by saleID desc";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<Product> getListProductHot() {
        List<Product> list = new ArrayList<>();

        String query = "select top 3 * from Product\n"
                + "  order by saleID";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();

        int count = pdao.totalProductByCategory(1);

        System.out.println(count);
    }

    public List<Category> getAllCate() {
        List<Category> list = new ArrayList<>();

        String query = " select * from Category";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();

        String query = "select  * from Product\n";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<Product> getProductByCid(int cid, int index) {
        List<Product> list = new ArrayList<>();

        String query = "SELECT *\n"
                + "  FROM [MyProject].[dbo].[Product]\n"
                + "  where categoryID = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<Product> getProductBySearch(String txtSearch) {
        List<Product> list = new ArrayList<>();

        String query = "SELECT *\n"
                + "  FROM [MyProject].[dbo].[Product]\n"
                + "  where productName like ?;";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public Product getElementProductByPid(int pid) {

        String query = "select * from Product\n"
                + "  where Product.productID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, pid);

            rs = ps.executeQuery();

            if (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
                return product;
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return null;
    }

    public int totalProduct() {

        String query = "select count(*) from Product";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return 0;
    }

    public List<Product> getListPageByIndex(int index) {
        List<Product> list = new ArrayList<>();

        String query = "select * from Product\n"
                + "  order by productID\n"
                + "  offset ? rows fetch next 6 rows only;";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public List<Product> getListProductPageByCidAndIndex(int cid, int index) {

        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where Product.categoryID = ?\n"
                + "order by Product.productID\n"
                + "offset ? row fetch next 6 rows only";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, cid);
            ps.setInt(2, (index - 1) * 6);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

    public int totalProductByCategory(int cid) {
        String query = "select COUNT(*) as[total] from Product\n"
                + "where Product.categoryID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, cid);

            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return 0;
    }

    public void insertProduct(String productName, double price, String img, String des, int categoryID, int saleID) {
        String query = "INSERT INTO [dbo].[Product]\n"
                + "           ([productName]\n"
                + "           ,[price]\n"
                + "           ,[img]\n"
                + "           ,[description]\n"
                + "           ,[categoryID]\n"
                + "           ,[saleID])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, productName);
            ps.setDouble(2, price);
            ps.setString(3, img);
            ps.setString(4, des);
            ps.setInt(5, categoryID);
            ps.setInt(6, saleID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public List<Product> getListProductByName(String productName) {
        List<Product> listP = new ArrayList<>();

        String query = "SELECT *\n"
                + "  FROM [MyProject].[dbo].[Product]\n"
                + "  where productName like ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, "%" + productName + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                listP.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return listP;
    }

    public List<String> getAllNameCate() {
        List<String> listNameCate = new ArrayList<>();

        String query = "select categoryName from Category";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                listNameCate.add(rs.getString(1));
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return listNameCate;
    }

    public int getCountCateByName(String nameCate) {
        int count = 0;

        String query = "select count(Product.productID)  from Product\n"
                + "  join Category on Product.categoryID = Category.categoryID\n"
                + "  where Category.categoryName = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, nameCate);

            rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return count;
    }

    public void updateProductByProductID(String productName, double price,
            String img, String des, int categoryID, int saleID, int productID) {

        String query = "UPDATE [dbo].[Product]\n"
                + "   SET [productName] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[categoryID] = ?\n"
                + "      ,[saleID] = ?\n"
                + " WHERE Product.productID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setString(1, productName);
            ps.setDouble(2, price);
            ps.setString(3, img);
            ps.setString(4, des);
            ps.setInt(5, categoryID);
            ps.setInt(6, saleID);
            ps.setInt(7, productID);

            ps.executeUpdate();

        } catch (SQLException exception) {
            System.out.println(exception);
        }

    }

    public void deleteProductByProductID(int productID) {
        String sql = "delete from OrderItem\n"
                + "  where ProductID = ?";

        try {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, productID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }

        String query = "DELETE FROM [dbo].[Product]\n"
                + "      WHERE Product.productID = ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, productID);

            ps.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public List<Product> getProductByPrice(int start, int end) {

        List<Product> list = new ArrayList<>();

        String query = "SELECT [productID]\n"
                + "      ,[productName]\n"
                + "      ,[price]\n"
                + "      ,[img]\n"
                + "      ,[description]\n"
                + "      ,[categoryID]\n"
                + "      ,[saleID]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where price > ? and price < ?";

        try {
            ps = connection.prepareStatement(query);

            ps.setInt(1, start);
            ps.setInt(2, end);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }

        return list;
    }

}
