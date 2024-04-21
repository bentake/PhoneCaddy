package com.example.phonecaddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.phonecaddy.databinding.FragmentSecondBinding;

/**
 * This class represents the second fragment, which is the second page of the app. This class lets user
 * input name, age, and experience level
 */
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
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
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GolferViewModel.class);
        return binding.getRoot();
    }

    /**
     * Sets how the back button and the submit button will respectively let the user move either to the first
     * or the third fragment. Submit button only does this with valid inputs and if the inputs are valid, saves
     * the input of the user.
     *
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );

        binding.buttonSubmit.setOnClickListener(v -> {
            boolean isValid = ValidateInputs();
            if (isValid == true) {
                setInputsInViewModel();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });
    }

    /**
     * Method that validates whether the user input for name and age are valid and not empty.
     * Age input that is over 100 returns false. Returns true if valid.
     *
     * @return ture if user inputs for name and age field are valid, false in cases where there is no input
     * or the age input is over 100.
     */
    private boolean ValidateInputs() {
        boolean isValid = true;

        String firstName = binding.edittextFirstName.getText().toString();
        if (firstName.isEmpty()) {
            binding.edittextFirstName.setError("Please enter your first name!");
            isValid = false;
        }

        String lastName = binding.edittextLastName.getText().toString();
        if (lastName.isEmpty()) {
            binding.edittextLastName.setError("Please enter your last name!");
            isValid = false;
        }

        String ageText = binding.edittextAge.getText().toString();
        if (ageText.isEmpty()) {
            binding.edittextAge.setError("Please enter your age!");
        }
        else if (isAgeUnder100(ageText) == false) {
            binding.edittextAge.setError("Please enter a valid age!");
            isValid = false;
        }

        return isValid;
    }

    /**
     * Method to save the user inputs.
     */
    private void setInputsInViewModel() {
        viewModel.setFirstName(binding.edittextFirstName.getText().toString());
        viewModel.setLastName(binding.edittextLastName.getText().toString());
        viewModel.setAge(Integer.parseInt(binding.edittextAge.getText().toString()));  // Make sure age has been validated as integer
        viewModel.setGender(binding.spinnerGender.getSelectedItem().toString());
        viewModel.setExperienceLevel(binding.spinnerExperience.getSelectedItem().toString());
    }

    /**
     * Method to validate that the age input is between 0 and 100
     *
     * @param str user input for age
     * @return true if age is between 0 and 100, false otherwise
     */
    private boolean isAgeUnder100(String str) {
        int age = Integer.parseInt(str);
        if (age >= 0 && age <= 100){
            return true;
        } return false;
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
