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
import com.alibi.triviaapp.databinding.FragmentNameBinding;
import com.alibi.triviaapp.util.UserDetailsPrefrennce;

import java.util.Objects;

public class NameFragment extends Fragment {

    private NavController navController;
    private FragmentNameBinding nameBinding;

    private UserDetailsPrefrennce userDetailsPrefrennce;


    public NameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        nameBinding = FragmentNameBinding.inflate(inflater, container, false);
        return nameBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        userDetailsPrefrennce = new UserDetailsPrefrennce(requireContext());
        nameBinding.next.setOnClickListener(v -> {
            if (Objects.requireNonNull(nameBinding.name.getText()).toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please Enter Your Name !", Toast.LENGTH_SHORT).show();
            } else {
                userDetailsPrefrennce.saveStringData("name", nameBinding.name.getText().toString());
                navController.navigate(R.id.action_nameFragment_to_bestCricketerFragment);
            }
        });

    }

}