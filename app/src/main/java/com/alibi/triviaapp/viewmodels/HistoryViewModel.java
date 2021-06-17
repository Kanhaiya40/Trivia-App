package com.alibi.triviaapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.alibi.triviaapp.model.GameDetails;
import com.alibi.triviaapp.repositories.HistoryRepo;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    HistoryRepo historyRepo = new HistoryRepo();

    public LiveData<List<GameDetails>> getHistory() {
        return historyRepo.getHistoryData();
    }


    public void addGameDetailsToHistoryRepo(GameDetails gameDetails) {
        historyRepo.addGameDetails(gameDetails);
    }

    public void reSetHistorySection() {
        historyRepo.resettingHistorySection();
    }
}
