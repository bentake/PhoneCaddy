package com.example.phonecaddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.phonecaddy.databinding.FragmentThirdBinding;

/**
 * Class that represents the third fragment, which handles user inputs specific for the player's swing, which are
 * distance, weather, and dominant hand.
 */
public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;
    private GolferViewModel viewModel;

    /**
     * Initializes the binding and inflates the layout for the fragment
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return view of the UI of the fragment
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GolferViewModel.class);
        return binding.getRoot();
    }

    /**
     * Sets how the back button lets user navigate to second fragment and the recommend button, given
     * that the inputs are valid, saves the input and navigate to the third fragment.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment)
        );

        binding.buttonRecommend.setOnClickListener(v -> {
            boolean isValid = validateInputs();
            if (isValid == true) {
                setInputsInViewModel();
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FourthFragment);
            }
        });
    }

    /**
     * Method that validates whether the user input for distance is valid and not empty.
     * Distance should be a positive integer input.
     * @return true if distance input is a positive integer and false otherwise.
     */
    private boolean validateInputs(){
        boolean isValid = true;

        String distanceText = binding.edittextDistance.getText().toString();
        if (distanceText.isEmpty()) {
            binding.edittextDistance.setError("Please enter the distance!");
            isValid = false;
        } else {
            try {
                int distance = Integer.parseInt(distanceText);
                if (distance <= 0) {
                    binding.edittextDistance.setError("Please enter a valid distance!");
                    isValid = false;
                }
            } catch (IllegalArgumentException e) {
                binding.edittextDistance.setError("Please round to the nearest integer!");
                isValid = false;
            }
        }

        return isValid;
    }

    /**
     * Method to save the user inputs.
     */
    private void setInputsInViewModel() {
        viewModel.setDistance(Integer.parseInt(binding.edittextDistance.getText().toString()));
        viewModel.setWeatherCondition(binding.spinnerWeather.getSelectedItem().toString());
        viewModel.setDominantHand(binding.spinnerHand.getSelectedItem().toString());
    }

    /**
     * Sets the binding to be null when view is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
