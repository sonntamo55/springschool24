package com.festo.warehouse;

public class Square {
    private 
        String square_type = "Undefined"; // ramp or shelf
        String item_type = "";
        int storage_capacity = 0;
        int item_quantity = 0;
        boolean east = false;
        boolean west = false;
        boolean north = false;
        boolean south = false;

    
        public void set_squaretype(String _square_type) {
            square_type = _square_type;
        }
        
        public String get_squaretype() {
            return square_type;
        }

        public void set_itemtype(String _item_type) {
            item_type = _item_type;
        }

        public String get_itemtype() {
            return item_type;
        }

        public void set_storagecapacity(int _sotrate_capacity) {
            storage_capacity = _sotrate_capacity;
        }

        public int get_storagecapacity() {
            return storage_capacity;
        }

        public String add_item() {
            if (item_quantity <= storage_capacity) {
                item_quantity++;
                return "Item placed succesfully";
            } else {
                return "Item ";
            }
        }
    
}
