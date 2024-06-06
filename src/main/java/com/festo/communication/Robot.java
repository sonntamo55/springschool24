package com.festo.communication;

public class Robot {
        String name = "john";
        boolean robothasitem;
    
        public void setname(String _name) {
            name = _name;
        }
    
        public String getname () {
            return name;
        }
        public void placeitem(){
            robothasitem = false;
        }
        public void pickitem(){
            robothasitem= true;
        }

        public boolean get_robothasitem(){
            return robothasitem;
        }
    }
    