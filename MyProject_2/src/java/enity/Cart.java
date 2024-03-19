/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Cart {

    private List<Item> listItem;
    
    

    public Cart() {
        listItem = new ArrayList<>();
    }

    public void add(Product product) {
        for (Item item : listItem) {
            if (item.getProduct().getProductID() == product.getProductID()) {
                item.addQuanity(1);
                return;
            }
        }
        listItem.add(new Item(product, 1));
    }

    public void updateQuantity(int id) {
        for (Item item : listItem) {
            if (item.getProduct().getProductID() == id) {
                
                item.addQuanity(1);
                        
                return;
            }
        }
    }

    public void deleteQuantity(int id) {
        for (Item item : listItem) {
            if (item.getProduct().getProductID() == id) {
                item.deleteQuanity(1);
                return;
            }
        }
    }
    
    public void deleteProduct(int id) {
        
        int indexRemove = -1;
        
        for (int i = 0; i < listItem.size(); i++) {
            if(listItem.get(i).getProduct().getProductID() == id){
                indexRemove = i;
                break;
            }
        }
        
        listItem.remove(indexRemove);
    }
    
    public double totalPrice() {

        double sum = 0;

        for (Item item : listItem) {
            sum += (item.getQuanity() * item.getProduct().getPrice());
        }
        return sum;
    }

    public int getSize() {
        
        int count = 0;
        
        for (Item item : listItem) {
            count += item.getQuanity();
        }
        
        return count;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public void setListItem(List<Item> listItem) {
        this.listItem = listItem;
    }

    
    

}
