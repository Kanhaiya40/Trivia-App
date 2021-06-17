package com.alibi.triviaapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.alibi.triviaapp.R;
import com.alibi.triviaapp.databinding.FragmentBestCricketerBinding;
import com.alibi.triviaapp.util.UserDetailsPrefrennce;


/**
 *
 */
public class BestCricketerFragment extends Fragment {


    private FragmentBestCricketerBinding bestCricketerBinding;
    private NavController navController;
    private UserDetailsPrefrennce userDetailsPrefrennce;

    public BestCricketerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bestCricketerBinding = FragmentBestCricketerBinding.inflate(inflater, container, false);
        return bestCricketerBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        userDetailsPrefrennce = new UserDetailsPrefrennce(requireContext());
        bestCricketerBinding.next.setOnClickListener(v -> {
            if (!bestCricketerBinding.sachin.isChecked() && !bestCricketerBinding.virat.isChecked() &&
                    !bestCricketerBinding.adam.isChecked() && !bestCricketerBinding.jack.isChecked()) {
                Toast.makeText(requireContext(), "Please Check Atleast One Option !", Toast.LENGTH_SHORT).show();
            } else {
                if (bestCricketerBinding.sachin.isChecked()) {
                    userDetailsPrefrennce.saveStringData("bestCricketer", bestCricketerBinding.sachin.getText().toString());
                } else if (bestCricketerBinding.virat.isChecked()) {
                    userDetailsPrefrennce.saveStringData("bestCricketer", bestCricketerBinding.virat.getText().toString());
                } else if (bestCricketerBinding.adam.isChecked()) {
                    userDetailsPrefrennce.saveStringData("bestCricketer", bestCricketerBinding.adam.getText().toString());
                } else {
                    userDetailsPrefrennce.saveStringData("bestCricketer", bestCricketerBinding.jack.getText().toString());
                }
                navController.navigate(R.id.action_bestCricketerFragment_to_flagColoursFragment);
            }
        });
    }
}