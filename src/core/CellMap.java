package core;

import celltypes.Square;
import celltypes.Triangle;
import controllers.TrioController;
import javafx.scene.canvas.GraphicsContext;

public class CellMap {
    private int width;
    private int height;
    private String type;
    private Cell[][] cells;

    public CellMap(int width, int height, String type){
        this.width = width;
        this.height = height;
        this.type = type;

        if(type.equals("square")){
            cells = new Square[width][height];
        }else if(type.equals("triangle")){
            cells = new Triangle[width][height];
        }

        createMap();
        setBombs();
        setNumbers();
    }

    public String getType() {
        return type;
    }

    public Cell[][] getCells() {
        return cells;
    }

    private void createMap(){
        int y = 0;
        int x;
        if(type.equals("square")){
            for(int i = 0; i < height; i++){
                x = 0;
                for(int j = 0; j < width; j++){
                    cells[j][i] = new Square(x, y);
                    x += cells[0][0].getWidth()+1;
                }
                y += cells[0][0].getHeight()+1;
            }
        }else if(type.equals("triangle")){
            for(int i = 0; i < height; i++){
                x = 0;
                for(int j = 0; j < width; j++){
                    if(j % 2 == 0){
                        cells[j][i] = new Triangle(x, y, false);
                        x+=1;
                    }else{
                        cells[j][i] = new Triangle(x, y, true);
                        x += cells[0][0].getWidth()+1;
                    }
                }
                y += cells[0][0].getHeight()+1;
            }
        }

    }

    private void setBombs(){
        int bombs = 0;
        while(bombs < 20){
            int randomX = (int)(Math.random() * TrioController.getCellWidth());
            int randomY = (int)(Math.random() * TrioController.getCellHeight());
            if(!cells[randomX][randomY].isBomb()){
                cells[randomX][randomY].setBomb(true);
                bombs++;
            }
        }
    }

    private void setNumbers(){
        int neighborCount = 0;
        if(type.equals("square")){
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
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
        }else if(type.equals("triangle")){
            for(int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    neighborCount = 1;
                    cells[j][i].setNeighbors(neighborCount);
                }
            }
        }
    }

    public void flowEmptyTiles(int j, int i){

        if(cells[j][i].isBomb()) return;

        if(i-1 >= 0 && j-1 >= 0 && !cells[j-1][i-1].isRevealed()){ // -1 | -1
            cells[j-1][i-1].setRevealed(true);
            if(cells[j-1][i-1].getNeighbors() == 0){
                flowEmptyTiles(j-1, i-1);
            }
        }
        if(i-1 >= 0 && !cells[j][i-1].isRevealed()){ // 0 | -1
            cells[j][i-1].setRevealed(true);
            if(cells[j][i-1].getNeighbors() == 0){
                flowEmptyTiles(j, i-1);
            }
        }
        if(i-1 >= 0 && j+1 < width && !cells[j+1][i-1].isRevealed()){ // 1 | -1
            cells[j+1][i-1].setRevealed(true);
            if(cells[j+1][i-1].getNeighbors() == 0){
                flowEmptyTiles(j+1, i-1);
            }
        }
        if(j-1 >= 0 && !cells[j-1][i].isRevealed()){ // -1 | 0
            cells[j-1][i].setRevealed(true);
            if(cells[j-1][i].getNeighbors() == 0){
                flowEmptyTiles(j-1, i);
            }
        }
        if(j+1 < width && !cells[j+1][i].isRevealed()){ // 1 | 0
            cells[j+1][i].setRevealed(true);
            if(cells[j+1][i].getNeighbors() == 0){
                flowEmptyTiles(j+1, i);
            }
        }
        if(j-1 >= 0 && i+1 < height && !cells[j-1][i+1].isRevealed()){ // -1 | 1
            cells[j-1][i+1].setRevealed(true);
            if(cells[j-1][i+1].getNeighbors() == 0){
                flowEmptyTiles(j-1, i+1);
            }
        }
        if(i+1 < height && !cells[j][i+1].isRevealed()){ // 0 | 1
            cells[j][i+1].setRevealed(true);
            if(cells[j][i+1].getNeighbors() == 0){
                flowEmptyTiles(j, i+1);
            }
        }
        if(i+1 < height && j+1 < width && !cells[j+1][i+1].isRevealed()){ // 1 | 1
            cells[j+1][i+1].setRevealed(true);
            if(cells[j+1][i+1].getNeighbors() == 0){
                flowEmptyTiles(j+1, i+1);
            }
        }
    }

    public void handleGameOver(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                cells[j][i].setRevealed(true);
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
