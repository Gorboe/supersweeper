package celltypes;

import core.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        gc.setFill(Color.BLACK);
        gc.fillRect(posX, posY, width, height);
    }
}
