/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import enity.PayMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class PayDAO extends DBcontext.DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<PayMethod> getAllPayMethod() {
        
        List<PayMethod> list = new ArrayList<>();
        
        String query = "SELECT *\n"
                + "  FROM [MyProject].[dbo].[PayMethod]";
        
        try{
            ps = connection.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new PayMethod(rs.getInt(1), rs.getString(2)));
            }
            
        }catch(SQLException exception){
            System.out.println(exception);
        }
        
        return list;
    }
}
