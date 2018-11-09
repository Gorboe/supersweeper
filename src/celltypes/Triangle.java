package celltypes;

import core.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Cell {
    private int posX;
    private int posY;
    private int width;
    private int height;
    private boolean reversed;
    private double[] xPoints = new double[3];
    private double[] yPoints = new double[3];

    public Triangle(int posX, int posY, boolean reversed){
        this.posX = posX;
        this.posY = posY;
        this.reversed = reversed;
        width = 40;
        height = 40;
        setPoints();
    }

    public void setPoints(){
        if(!isReversed()){
            xPoints[0] = posX;
            xPoints[1] = posX;
            xPoints[2] = posX+width;
            yPoints[0] = posY;
            yPoints[1] = posY+height;
            yPoints[2] = posY+height;
        }else{
            xPoints[0] = posX;
            xPoints[1] = posX+width;
            xPoints[2] = posX+width;
            yPoints[0] = posY;
            yPoints[1] = posY;
            yPoints[2] = posY+height;
        }
    }

    public boolean isReversed() {
        return reversed;
    }

    public double[] getxPoints() {
        return xPoints;
    }

    public double[] getyPoints() {
        return yPoints;
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
