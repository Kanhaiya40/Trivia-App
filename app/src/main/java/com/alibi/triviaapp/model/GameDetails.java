package com.alibi.triviaapp.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class GameDetails {
    public static DiffUtil.ItemCallback<GameDetails> itemCallback = new DiffUtil.ItemCallback<GameDetails>() {
        @Override
        public boolean areItemsTheSame(GameDetails oldItem, GameDetails newItem) {
            return oldItem.getDate().equals(newItem.getDate());
        }

        @Override
        public boolean areContentsTheSame(GameDetails oldItem, @NonNull GameDetails newItem) {
            return oldItem.equals(newItem);
        }
    };
    int gameNumber;
    String date;
    String name;
    String bestCricketer;
    String flagColors;

    public GameDetails(int gameNumber, String date, String name, String bestCricketer, String flagColors) {
        this.gameNumber = gameNumber;
        this.date = date;
        this.name = name;
        this.bestCricketer = bestCricketer;
        this.flagColors = flagColors;
    }

    @NonNull
    @Override
    public String toString() {
        return "GameDetails{" +
                "gameNumber=" + gameNumber +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", bestCricketer='" + bestCricketer + '\'' +
                ", flagColors='" + flagColors + '\'' +
                '}';
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBestCricketer() {
        return bestCricketer;
    }

    public void setBestCricketer(String bestCricketer) {
        this.bestCricketer = bestCricketer;
    }

    public String getFlagColors() {
        return flagColors;
    }

    public void setFlagColors(String flagColors) {
        this.flagColors = flagColors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDetails that = (GameDetails) o;
        return getDate().equals(that.getDate());
    }
}
