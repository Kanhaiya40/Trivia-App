package com.alibi.triviaapp.fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.alibi.triviaapp.databinding.FragmentFlagColoursBinding;
import com.alibi.triviaapp.util.UserDetailsPrefrennce;

import java.util.HashSet;
import java.util.Set;


public class FlagColoursFragment extends Fragment {

    private FragmentFlagColoursBinding flagColoursBinding;
    private NavController navController;
    private Set<String> colors;
    private UserDetailsPrefrennce userDetailsPrefrennce;

    public FlagColoursFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        flagColoursBinding = FragmentFlagColoursBinding.inflate(inflater, container, false);
        return flagColoursBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        colors = new HashSet<>();
        navController = Navigation.findNavController(view);
        userDetailsPrefrennce = new UserDetailsPrefrennce(requireContext());

        flagColoursBinding.next.setOnClickListener(v -> {
            if (!flagColoursBinding.white.isChecked() && !flagColoursBinding.yellow.isChecked() &&
                    !flagColoursBinding.orange.isChecked() && !flagColoursBinding.green.isChecked()) {
                Toast.makeText(requireContext(), "Please Check atleast one option !", Toast.LENGTH_SHORT).show();
            } else {
                if (flagColoursBinding.white.isChecked()) {
                    colors.add(flagColoursBinding.white.getText().toString());
                } else {
                    colors.remove(flagColoursBinding.white.getText().toString());
                }
                if (flagColoursBinding.yellow.isChecked()) {
                    colors.add(flagColoursBinding.yellow.getText().toString());
                } else {
                    colors.remove(flagColoursBinding.yellow.getText().toString());
                }
                if (flagColoursBinding.orange.isChecked()) {
                    colors.add(flagColoursBinding.orange.getText().toString());
                } else {
                    colors.remove(flagColoursBinding.orange.getText().toString());
                }
                if (flagColoursBinding.green.isChecked()) {
                    colors.add(flagColoursBinding.green.getText().toString());
                } else {
                    colors.remove(flagColoursBinding.green.getText().toString());
                }
                Log.d("Colours", "onClick: " + colors);
                userDetailsPrefrennce.saveListOfString("colors", colors);
                navController.navigate(R.id.action_flagColoursFragment_to_summaryFragment);
            }
        });
    }
}