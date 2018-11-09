package celltypes;

import core.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Square extends Cell {
    private int width;
    private int height;
    private int posX;
    private int posY;

    public Square(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        width = 40;
        height = 40;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(GraphicsContext gc){
        if(!isRevealed()){
            gc.setFill(Color.BLACK);
            gc.fillRect(posX, posY, width, height);
            return;
        }
        if(!isBomb()){
            //display number
            gc.setFill(Color.GREY);
            gc.fillRect(posX, posY, width, height);
            gc.setFill(setColor());
            gc.setFont(Font.font("Verdana", 30));
            if(getNeighbors()!=0){
                gc.fillText(""+getNeighbors(), posX+(double)width/2-7, posY+(double)height/2+8);
            }
            return;
        }
        //display bomb
        gc.setFill(Color.GREY);
        gc.fillRect(posX, posY, width, height);
        gc.setFill(Color.BLACK);
        gc.fillOval(posX + (double)width/4, posY + (double)height/4, 20, 20);
    }
}
