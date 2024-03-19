/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

/**
 *
 * @author admin
 */
public class Item {

    private Product product;
    private int quanity;

    public Item() {
    }

    public Item(Product product, int quanity) {
        this.product = product;
        this.quanity = quanity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    @Override
    public String toString() {
        return "Item{" + "product=" + product + ", quanity=" + quanity + '}';
    }

    void addQuanity(int i) {
        this.quanity += i;
    }

    void deleteQuanity(int i) {
        this.quanity -= i;
    }

}
