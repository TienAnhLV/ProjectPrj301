/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author admin
 */
public class OrderCart {

    private int orderDeitalID;

    private String nameUser;

    private String locationOrder;

    private double total;

    private int status;

    private String comment;

    public OrderCart() {
    }

    public OrderCart(int orderDeitalID, String nameUser, String locationOrder, double total, int status, String comment) {
        this.orderDeitalID = orderDeitalID;
        this.nameUser = nameUser;
        this.locationOrder = locationOrder;
        this.total = total;
        this.status = status;
        this.comment = comment;
    }

    public int getOrderDeitalID() {
        return orderDeitalID;
    }

    public void setOrderDeitalID(int orderDeitalID) {
        this.orderDeitalID = orderDeitalID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLocationOrder() {
        return locationOrder;
    }

    public void setLocationOrder(String locationOrder) {
        this.locationOrder = locationOrder;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    @Override
    public String toString() {
        return "OrderCart{" + "orderDeitalID=" + orderDeitalID + ", nameUser=" + nameUser + ", locationOrder=" + locationOrder + ", total=" + total + ", status=" + status + ", comment=" + comment + '}';
    }

}
