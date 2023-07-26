package com.example.quiz_assignment;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Utilities_Dialog {

    // Method to show a custom alert dialog
    public static void showAlertDialog(
            Context context,
            String title,
            String message,
            String positiveButton,
            String negativeButton,
            final Runnable positiveCallback,
            final Runnable negativeCallback) {

        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // Set the title and message for the dialog
        builder.setTitle(title)
                .setMessage(message);

        // Set the positive button and its click listener
        builder.setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Handle positive button click
                if (positiveCallback != null) {
                    positiveCallback.run();
                }
            }
        });

        // Set the negative button and its click listener
        builder.setNegativeButton(negativeButton, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Handle negative button click
                if (negativeCallback != null) {
                    negativeCallback.run();
                }
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
