package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable{
	private ArrayList<LineItem> items;

	public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }
    
    public void addItem(LineItem item) {
        String Name = item.getProduct().getName();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getName().equals(Name)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String Name = item.getProduct().getName();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getName().equals(Name)) {
                items.remove(i);
                return;
            }
        }
    }

}
