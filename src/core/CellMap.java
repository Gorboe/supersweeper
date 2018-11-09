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
        setBombs();
        setNumbers();
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

    private void setBombs(){
        int bombs = 0;
        while(bombs < 20){
            int randomX = (int)(Math.random() * cells.length);
            int randomY = (int)(Math.random() * cells.length);
            if(!cells[randomX][randomY].isBomb()){
                cells[randomX][randomY].setBomb(true);
                bombs++;
            }
        }
    }

    private void setNumbers(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int neighborCount = 0;
                if(i-1 >= 0 && j-1 >= 0 && cells[j-1][i-1].isBomb()){ // -1 | -1
                    neighborCount++;
                }
                if(i-1 >= 0 && cells[j][i-1].isBomb()){ // 0 | -1
                    neighborCount++;
                }
                if(i-1 >= 0 && j+1 < width && cells[j+1][i-1].isBomb()){ // 1 | -1
                    neighborCount++;
                }
                if(j-1 >= 0 && cells[j-1][i].isBomb()){ // -1 | 0
                    neighborCount++;
                }
                if(j+1 < width && cells[j+1][i].isBomb()){ // 1 | 0
                    neighborCount++;
                }
                if(j-1 >= 0 && i+1 < height && cells[j-1][i+1].isBomb()){ // -1 | 1
                    neighborCount++;
                }
                if(i+1 < height && cells[j][i+1].isBomb()){ // 0 | 1
                    neighborCount++;
                }
                if(i+1 < height && j+1 < width && cells[j+1][i+1].isBomb()){ // 1 | 1
                    neighborCount++;
                }
                cells[j][i].setNeighbors(neighborCount);
            }
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
