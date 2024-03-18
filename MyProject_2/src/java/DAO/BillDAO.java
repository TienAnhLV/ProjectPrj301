/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.BillDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BillDAO extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<BillDetail> getBillByID(int orderDetailId) {
        List<BillDetail> list = new ArrayList<>();

        String query = "  select \n"
                + "  OrderItem.OrderDetailD,Product.productName,Product.price,OrderItem.Quanity,\n"
                + "  (Product.price * OrderItem.Quanity) as[Money], OrderDetail.OrderDate from OrderItem\n"
                + "  join Product on OrderItem.ProductID = Product.productID\n"
                + "  join OrderDetail on OrderItem.OrderDetailD = OrderDetail.OrderDetaiID\n"
                + "  where OrderDetail.OrderDetaiID = ?";
        
        try{
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, orderDetailId);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                BillDetail billDetail = new BillDetail(rs.getInt(1), rs.getString(2), 
                        rs.getDouble(3), rs.getInt(4), rs.getDouble(5), rs.getString(6));
                
                list.add(billDetail);
            }
        }catch(SQLException exception){
            System.out.println(exception);
        }

        return list;
    }

}
