package com.example.dialogfragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;


public class MyDialogFragment extends DialogFragment {

    private static final String TAG = "MyDialogFragment";


    private EditText mInput;

    public interface OnInputListener{
        void sendInput(String input);
    }
    private OnInputListener mOnInputListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        mInput = view.findViewById(R.id.input);
        TextView mActionOk = view.findViewById(R.id.action_ok);
        TextView mActionCancel = view.findViewById(R.id.action_canel);

        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getDialog()).dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mInput.getText().toString();
                mOnInputListener.sendInput(input);
                Objects.requireNonNull(getDialog()).dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mOnInputListener =(OnInputListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach:ClassCastException " + e.getMessage() );
        }
    }
}
