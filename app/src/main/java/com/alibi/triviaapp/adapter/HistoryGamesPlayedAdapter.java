package com.alibi.triviaapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.alibi.triviaapp.databinding.HistoryViewBinding;
import com.alibi.triviaapp.model.GameDetails;

/**
 * This class is actually binding our data to given view
 * Here in this project we have created history view
 * and we are binding data through ListAdapter Class
 */
public class HistoryGamesPlayedAdapter extends ListAdapter<GameDetails, HistoryGamesPlayedAdapter.ViewHolder> {


    /*
     * By implementing this code we need not to
     * call notify related function to adapter
     * and that is the main advantage to ListAdapter
     * over normal Recycler View Adapter
     */
    public HistoryGamesPlayedAdapter() {
        super(GameDetails.itemCallback);
    }


    /*
     * This function is use to create view holder which holding our view
     */
    @NonNull
    @Override
    public HistoryGamesPlayedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        HistoryViewBinding historyViewBinding = HistoryViewBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(historyViewBinding);
    }

    /*
     * This is function is use to bind our data to view
     */
    @Override
    public void onBindViewHolder(@NonNull HistoryGamesPlayedAdapter.ViewHolder holder, int position) {
        GameDetails gameDetails = getItem(position);
        holder.historyViewBinding.setGameDetails(gameDetails);
        holder.historyViewBinding.executePendingBindings();
    }

    /**
     * This is viewHolder class which is detecting our controlers
     * and use to control all the operation related to model class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        HistoryViewBinding historyViewBinding;

        public ViewHolder(@NonNull HistoryViewBinding historyViewBinding) {
            super(historyViewBinding.getRoot());
            this.historyViewBinding = historyViewBinding;
        }
    }
}
