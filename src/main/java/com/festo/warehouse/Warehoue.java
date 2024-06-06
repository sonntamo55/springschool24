package com.festo.warehouse;

public class Warehoue {

    Square [][] map = new Square [2][2];
    
    public void createwarehouse() {

    Square tempsqr = new Square();
    tempsqr.set_squaretype("Corner");
    tempsqr.set_storagecapacity(9);
    map[0][0] = tempsqr;

    tempsqr.set_squaretype("Hallway");
    tempsqr.set_storagecapacity(8);
    map[0][1] = tempsqr;

    tempsqr.set_squaretype("Corner");
    tempsqr.set_storagecapacity(9);
    map[0][2] = tempsqr;

    tempsqr.set_squaretype("Corner");
    tempsqr.set_storagecapacity(9);
    map[1][0] = tempsqr;

    tempsqr.set_squaretype("T-Crossing");
    tempsqr.set_storagecapacity(6);
    map[1][1] = tempsqr;

    tempsqr.set_squaretype("Corner");
    tempsqr.set_storagecapacity(9);
    map[1][2] = tempsqr;

    tempsqr.set_squaretype("Ramp");
    tempsqr.set_storagecapacity(0);
    map[2][1] = tempsqr;
    
    }

    public int getcapacity(){
        int capa = 0;
        for (int x = 0 ; x<=2; x++) {
            for (int y= 0; y<=2;y++) {
                capa = capa + map[x][y].get_storagecapacity();
            }
        }
        return capa;
    }
    
}
