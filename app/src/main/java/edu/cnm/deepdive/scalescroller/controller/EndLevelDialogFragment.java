package edu.cnm.deepdive.scalescroller.controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.scalescroller.R;
import edu.cnm.deepdive.scalescroller.controller.GameFragment.GameMode;

/**
 * Creates a dialog that pops up at the end of the level (in Learn mode) or game (in Challenge
 * mode). Informs the player of the game status - won or lost for Learn mode, score for Challenge
 * mode.
 */
public class EndLevelDialogFragment extends DialogFragment {

  private AlertDialog dialog;
  private String gameMode;
  private boolean gameWon;
  private int score;

  /**
   * Sets the style for the dialog.
   *
   * @param savedInstanceState A {@code Bundle}
   */
  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
  }

  /**
   * Creates and sets the text for the dialog.
   *
   * @param savedInstanceState A {@code Bundle}
   * @return The dialog that was created.
   */
  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    gameWon = EndLevelDialogFragmentArgs.fromBundle(getArguments()).getGameWon();
    gameMode = EndLevelDialogFragmentArgs.fromBundle(getArguments()).getGameMode();
    score = EndLevelDialogFragmentArgs.fromBundle(getArguments()).getScore();
    String format = (gameMode.equals(GameMode.LEARN.toString())) ? getString(R.string.congratulations_learn)
        : getString(R.string.congratulations_challenge);
    format = (gameWon) ? format : getString(R.string.failure_learn);
    dialog = new AlertDialog.Builder(getActivity())
        .setMessage(String.format(format, score))
        .setPositiveButton(android.R.string.ok, (dialog, which) -> {
        })
        .create();
    return dialog;
  }
}
