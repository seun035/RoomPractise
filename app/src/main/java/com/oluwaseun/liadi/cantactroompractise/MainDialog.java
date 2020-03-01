package com.oluwaseun.liadi.cantactroompractise;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.oluwaseun.liadi.cantactroompractise.database.AppDatabase;
import com.oluwaseun.liadi.cantactroompractise.database.Contact;
import com.oluwaseun.liadi.cantactroompractise.database.DatabaseLab;

public class MainDialog extends DialogFragment {
    private TextInputEditText mNameInput;
    private TextInputEditText mPhoneInput;
    private TextInputEditText mEmailInput;
    private AppDatabase db;

    private static final String TAG = "MainDialog";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = DatabaseLab.get(getActivity().getApplicationContext()).getRoomInstance();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.main_dialog, null, false);
        mNameInput = view.findViewById(R.id.contact_name);
        mPhoneInput = view.findViewById(R.id.contact_phone);
        mEmailInput = view.findViewById(R.id.contact_email);
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setTitle("Add Contact")
                .setView(view)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       long result = db.contactDao()
                                .createContact(new Contact(mNameInput.getText().toString(),mPhoneInput.getText().toString(),mEmailInput.getText().toString()));
                        Log.i(TAG, "onClick: "+ result);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create();

//        alertDialog.getButton(alertDialog..BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                alertDialog.dismiss();
//            }
//        });

        return alertDialog;
    }
}
