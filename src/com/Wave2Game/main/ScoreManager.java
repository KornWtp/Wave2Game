package com.Wave2Game.main;

import java.io.*;

public class ScoreManager {

//    private Score score;
    private final String HIGHSCORE_FILE = "highscore.dat";

    public boolean updateScore(Score score){
        if(score.getScore() > readHighScore().getScore()){
            writeScore(score);
            return true;
        } else
            return false;
    }

    public int getHighScore(){
        return readHighScore().getScore();
    }

    private Score readHighScore(){
        Score tempScore = new Score(0);
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            tempScore = (Score)in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return tempScore;
    }

    private void writeScore(Score score){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            out.writeObject(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
