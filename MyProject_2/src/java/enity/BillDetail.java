/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author admin
 */
public class BillDetail {

    private int orderDetailID;
    private String productName;
    private double price;
    private int quanity;
    private double total;
    private String orderDate;

    public BillDetail() {
    }

    public BillDetail(int orderDetailID, String productName, double price, int quanity, double total, String orderDate) {
        this.orderDetailID = orderDetailID;
        this.productName = productName;
        this.price = price;
        this.quanity = quanity;
        this.total = total;
        this.orderDate = orderDate;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "orderDetailID=" + orderDetailID + ", productName=" + productName + ", price=" + price + ", quanity=" + quanity + ", total=" + total + ", orderDate=" + orderDate + '}';
    }

}
