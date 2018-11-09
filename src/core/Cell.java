package core;

import javafx.scene.canvas.GraphicsContext;

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

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract void draw(GraphicsContext gc);
}
