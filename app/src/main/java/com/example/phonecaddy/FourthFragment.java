package com.example.phonecaddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.phonecaddy.databinding.FragmentFourthBinding;
import androidx.lifecycle.ViewModelProvider;

/**
 * This class represents the fourth fragment, which based on the user input, shows the recommended club and the
 * picture of the club recommended.
 */
public class FourthFragment extends Fragment {
    private FragmentFourthBinding binding;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFourthBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(GolferViewModel.class);
        return binding.getRoot();
    }

    /**
     * Sets how the new swing button navigates user back to the third fragment for a new swing
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        generateRecommendation();

        binding.buttonNewSwing.setOnClickListener(v ->
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_FourthFragment_to_ThirdFragment)
        );
    }

    /**
     * Return the resource ID for the image of the golf club based on the club that is inputted
     *
     * @param club the club of which resource ID is being sought
     * @return resource ID of the image of the respective club
     */
    private int setClubImages(String club) {
        switch (club) {
            case "Driver":
                return R.drawable.driver;
            case "4 Wood":
                return R.drawable.wood4;
            case "4 Hybrid":
                return R.drawable.hybrid3;
            case "4 iron":
                return R.drawable.iron4;
            case "5 iron":
                return R.drawable.iron5;
            case "6 iron":
                return R.drawable.iron6;
            case "7 iron":
                return R.drawable.iron7;
            case "8 iron":
                return R.drawable.iron8;
            case "9 iron":
                return R.drawable.iron9;
            case "Pitching Wedge":
                return R.drawable.pw;
            case "Sand Wedge":
                return R.drawable.sw;
        }
        return 0;
    }

    /**
     * Based on the user inputs in the second and the third fragment, generates a club recommendation,
     * and sets the text to show the club recommendation and shows the image of the club corresponding
     * to the resource ID of the club that is recommended.
     */
    private void generateRecommendation() {
        String firstName = viewModel.getFirstName();
        String lastName = viewModel.getLastName();
        int age = viewModel.getAge();
        Gender gender = Gender.valueOf(viewModel.getGender().toUpperCase());
        Person person = new Person(firstName, lastName, age, gender);

        TypeOfGolfer skillLevel = TypeOfGolfer.valueOf(viewModel.getExperienceLevel().toUpperCase());
        DominantHand dominantHand = DominantHand.valueOf(viewModel.getDominantHand().toUpperCase());
        Golfer newGolfer = new Golfer(person, skillLevel, dominantHand);

        int distance = viewModel.getDistance();
        TypeOfCondition condition = TypeOfCondition.valueOf(viewModel.getWeatherCondition().toUpperCase());
        String clubRecommendationGenerated = newGolfer.recommendClub(distance, condition);

        int clubImageOnFile = setClubImages(clubRecommendationGenerated);
        binding.imageClub9.setImageResource(clubImageOnFile);

        binding.textviewClub.setText("Caddy Recommends: " + clubRecommendationGenerated);
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