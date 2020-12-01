package edu.cnm.deepdive.scalescroller.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.scalescroller.databinding.FragmentSettingsBinding;

/**
 * Contains options for settings and high scores.
 */
public class SettingsFragment extends Fragment {

  private FragmentSettingsBinding binding;
  private NavController navController;

  /**
   * Initializes navigation.
   *
   * @param inflater A {@code LayoutInflater}.
   * @param container A {@code ViewGroup}.
   * @param savedInstanceState A {@code Bundle}.
   * @return A {@code View}.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentSettingsBinding.inflate(inflater);
    navController = NavHostFragment.findNavController(this);
    binding.settingsBackButton.setOnClickListener((v) -> {
      navController.navigate(SettingsFragmentDirections.openTitle());
    });
    return binding.getRoot();
  }

}
