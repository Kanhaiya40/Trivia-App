package com.alibi.triviaapp.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.alibi.triviaapp.R;
import com.alibi.triviaapp.databinding.FragmentSummaryBinding;
import com.alibi.triviaapp.model.GameDetails;
import com.alibi.triviaapp.util.UserDetailsPrefrennce;
import com.alibi.triviaapp.viewmodels.HistoryViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SummaryFragment extends Fragment {


    private FragmentSummaryBinding summaryBinding;
    private NavController navController;
    private List<String> months;

    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        summaryBinding = FragmentSummaryBinding.inflate(inflater, container, false);
        return summaryBinding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        UserDetailsPrefrennce userDetailsPrefrennce = new UserDetailsPrefrennce(requireContext());
        HistoryViewModel historyViewModel = new ViewModelProvider(requireActivity()).get(HistoryViewModel.class);
        months = new ArrayList<>();

        addMonths();

        String name = userDetailsPrefrennce.getStringData("name");
        String bestCricketer = userDetailsPrefrennce.getStringData("bestCricketer");
        Set<String> colors = userDetailsPrefrennce.getSetData("colors");

        summaryBinding.name.setText(name);
        summaryBinding.cricketer.setText(bestCricketer);
        String combinedColors = colors.toString();
        combinedColors = combinedColors.replace("[", "");
        combinedColors = combinedColors.replace("]", "");
        summaryBinding.colors.setText(combinedColors);

        LocalDateTime localDateTime = LocalDateTime.now();

        //formating system date-time to our qwn format
        String date = formatDate(localDateTime);

        // creating details related to history page
        GameDetails gameDetails = new GameDetails(1, date, name, bestCricketer, combinedColors);
        historyViewModel.addGameDetailsToHistoryRepo(gameDetails);

        // onClick of finish button
        summaryBinding.finish.setOnClickListener(v -> {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setMessage("You wanna Start game again ?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                navController.navigate(R.id.action_summaryFragment_to_nameFragment);
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                            dialog.dismiss();
//                            }
//                        }).show();
            navController.navigate(R.id.action_summaryFragment_to_nameFragment);
        });


        // onClick of history button
        summaryBinding.history.setOnClickListener(v -> navController.navigate(R.id.action_summaryFragment_to_historyFragment));

        summaryBinding.setHistoryViewModel(historyViewModel);

    }

    // Disables back button on current fragment
    @Override
    public void onResume() {
        super.onResume();
        this.requireView().setFocusableInTouchMode(true);
        this.requireView().requestFocus();
        this.requireView().setOnKeyListener((v, keyCode, event) -> keyCode == KeyEvent.KEYCODE_BACK);
    }

    /*
     * It Contains all months from jan to des
     */
    private void addMonths() {
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("Sept");
        months.add("Oct");
        months.add("Nov");
        months.add("Dec");
    }

    /*
     * Formating Date as our requirement
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String formatDate(LocalDateTime localDateTime) {
        String currentDate = "";
        int date = localDateTime.getDayOfMonth();
        int month = localDateTime.getMonthValue();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();

        if (hour >= 12) {
            hour = hour % 12;
            currentDate = currentDate + date + "th " + months.get(month) + " " + hour + ":" + minute + " " + "pm";
        } else if (hour == 0) {
            hour = 12;
            currentDate = currentDate + date + "th " + months.get(month) + " " + hour + ":" + minute + " " + "am";
        } else {
            currentDate = currentDate + date + "th " + months.get(month) + " " + hour + ":" + minute + " " + "am";
        }
        return currentDate;
    }
}