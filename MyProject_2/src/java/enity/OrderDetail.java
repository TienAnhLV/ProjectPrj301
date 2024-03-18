/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author admin
 */
public class OrderDetail {

    private int orderDetailID;
    private String orderDate;
    private int userID;
    private String locationOrder;

    private int status;
    private String comment;

    private int payMethod;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailID, String orderDate, int userID, String locationOrder, int status, String comment, int payMethod) {
        this.orderDetailID = orderDetailID;
        this.orderDate = orderDate;
        this.userID = userID;
        this.locationOrder = locationOrder;
        this.status = status;
        this.comment = comment;
        this.payMethod = payMethod;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLocationOrder() {
        return locationOrder;
    }

    public void setLocationOrder(String locationOrder) {
        this.locationOrder = locationOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderDetailID=" + orderDetailID + ", orderDate=" + orderDate + ", userID=" + userID + ", locationOrder=" + locationOrder + ", status=" + status + ", comment=" + comment + ", payMethod=" + payMethod + '}';
    }

}
