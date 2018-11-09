package controllers;

import core.Main;

import java.io.IOException;

public class TitleController {

    public void handleStartClassic(){
        try{
            System.out.println("Starting classic game");
            Main.changeScene("classicview.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleStartTrio(){
        try{
            System.out.println("Starting trio game");
            Main.changeScene("trioview.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleStartHex(){
        try{
            System.out.println("Starting hex game");
            Main.changeScene("hexview.fxml");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
