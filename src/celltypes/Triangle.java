package celltypes;

import core.Cell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
        if(!isRevealed()){
            gc.setFill(Color.BLACK);
            gc.fillPolygon(xPoints, yPoints, 3);
            return;
        }
        if(!isBomb()){
            //display number
            gc.setFill(Color.GREY);
            gc.fillPolygon(xPoints, yPoints, 3);
            gc.setFill(setColor());
            gc.setFont(Font.font("Verdana", 25));
            if(getNeighbors() != 0){
                if(!reversed){
                    gc.fillText(""+getNeighbors(), posX+5, posY+35);
                }else{
                    gc.fillText(""+getNeighbors(), posX+20, posY+20);
                }
            }
            return;
        }

        //display bomb
        gc.setFill(Color.GREY);
        gc.fillPolygon(xPoints, yPoints, 3);
        gc.setFill(Color.BLACK);
        if(!reversed){
            gc.fillOval(posX+5, posY+20, 15, 15);
        }else{
            gc.fillOval(posX+20, posY+5, 15, 15);
        }
    }
}
