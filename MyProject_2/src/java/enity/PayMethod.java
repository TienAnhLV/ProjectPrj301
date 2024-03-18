/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author admin
 */
public class PayMethod {

    private int payID;
    private String payName;

    public PayMethod() {
    }

    public PayMethod(int payID, String payName) {
        this.payID = payID;
        this.payName = payName;
    }

    public int getPayID() {
        return payID;
    }

    public void setPayID(int payID) {
        this.payID = payID;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    @Override
    public String toString() {
        return "PayMethod{" + "payID=" + payID + ", payName=" + payName + '}';
    }

}
