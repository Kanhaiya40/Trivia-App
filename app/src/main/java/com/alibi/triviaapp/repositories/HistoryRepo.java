package com.alibi.triviaapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.alibi.triviaapp.model.GameDetails;

import java.util.ArrayList;
import java.util.List;

public class HistoryRepo {

    private final MutableLiveData<List<GameDetails>> mutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<Integer> gameNumber = new MutableLiveData<>();

    public LiveData<List<GameDetails>> getHistoryData() {
        if (mutableLiveData.getValue() == null) {
            initHistorySection();
        }
        return mutableLiveData;
    }

    public void initHistorySection() {
        mutableLiveData.setValue(new ArrayList<>());
    }

    public void addGameDetails(GameDetails gameDetails) {
        if (gameNumber.getValue() == null) {
            initGameNumber();
        }
        gameNumber.setValue(gameNumber.getValue() + 1);
        if (mutableLiveData.getValue() == null) {
            initHistorySection();
        }
        List<GameDetails> gamesPlayed = new ArrayList<>(mutableLiveData.getValue());
        gameDetails.setGameNumber(gameNumber.getValue());
        gamesPlayed.add(gameDetails);
        mutableLiveData.setValue(gamesPlayed);
    }

    private void initGameNumber() {
        gameNumber.setValue(0);
    }

    public void resettingHistorySection() {
        initHistorySection();
        initGameNumber();
    }
}
