package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Cell {
    private boolean bomb;
    private boolean revieled;
    private int neighbors;

    public Cell(){
        revieled = true;
        bomb = false;
    }

    public boolean isBomb() {
        return bomb;
    }

    public boolean isRevieled() {
        return revieled;
    }

    public void setRevieled(boolean revieled) {
        this.revieled = revieled;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public int getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(int neighbors) {
        this.neighbors = neighbors;
    }

    public Color setColor(){
        switch (getNeighbors()){
            case 1: return Color.GREEN;
            case 2: return Color.DEEPSKYBLUE;
            case 3: return Color.BLUE;
            case 4: return Color.YELLOW;
            case 5: return Color.ORANGE;
            case 6: return Color.RED;
            case 7: return Color.PURPLE;
        }
        return Color.PINK;
    }

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract void draw(GraphicsContext gc);
}
