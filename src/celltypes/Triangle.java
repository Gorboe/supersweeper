package celltypes;

import core.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Cell {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private double[] xPoints = new double[3];
    private double[] yPoints = new double[3];

    public Triangle(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        width = 50;
        height = 50;
        setPoints();
    }

    public void setPoints(){
        xPoints[0] = posX;
        xPoints[1] = posX;
        xPoints[2] = posX+width;
        yPoints[0] = posY;
        yPoints[1] = posY+height;
        yPoints[2] = posY+height;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width; //base
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillPolygon(xPoints, yPoints, 3);
    }
}
