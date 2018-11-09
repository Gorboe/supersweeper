package core;

import celltypes.Square;
import javafx.scene.canvas.GraphicsContext;

public class CellMap {
    private int width;
    private int height;
    private Cell[][] cells;

    public CellMap(int width, int height, String type){
        this.width = width;
        this.height = height;

        if(type.equals("square")){
            cells = new Square[width][height];
        }

        createMap();
        /*
        * square, trio or hex??? what [][] to create
        * */
    }

    private void createMap(){
        int y = 0;
        int x;
        for(int i = 0; i < height; i++){
            x = 0;
            for(int j = 0; j < width; j++){
                cells[j][i] = new Square(x, y);
                x += cells[0][0].getWidth()+1;
            }
            y += cells[0][0].getHeight()+1;
        }
    }

    public void draw(GraphicsContext gc){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                cells[j][i].draw(gc);
            }
        }
    }
}
