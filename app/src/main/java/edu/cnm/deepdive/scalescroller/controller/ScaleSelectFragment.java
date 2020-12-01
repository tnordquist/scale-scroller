package edu.cnm.deepdive.scalescroller.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.scalescroller.adapter.ScaleRecyclerAdapter;
import edu.cnm.deepdive.scalescroller.databinding.FragmentScaleSelectBinding;
import edu.cnm.deepdive.scalescroller.viewmodel.MainViewModel;

/**
 * Allows the user to select a scale from a RecyclerView for Learn mode.
 */
public class ScaleSelectFragment extends Fragment {

  private FragmentScaleSelectBinding binding;
  private NavController navController;

  /**
   * Sets up navigation and the RecyclerView adapter.
   *
   * @param inflater           A {@code LayoutInflater}.
   * @param container          A {@code ViewGroup}.
   * @param savedInstanceState A {@code Bundle}.
   * @return A {@code View}.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentScaleSelectBinding.inflate(inflater);
    navController = NavHostFragment.findNavController(this);
    binding.scaleSelectBackButton.setOnClickListener((v) -> {
      navController.navigate(ScaleSelectFragmentDirections.openTitle());
    });
    // TODO Set listener for the elements in the recycler view
    return binding.getRoot();
  }

  // TODO javadoc
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    viewModel.getScales().observe(getViewLifecycleOwner(), (scales) -> {
      //noinspection ConstantConditions
      ScaleRecyclerAdapter adapter = new ScaleRecyclerAdapter(getContext(), scales, (scale) ->
          navController.navigate(ScaleSelectFragmentDirections.openLearnModeGame(scale.getTonic(), scale.getMode())));
      binding.scaleRecycler.setAdapter(adapter);
    });
  }
}
