package com.example.asynctask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class LoaderFragment extends DialogFragment {

    private TextView textView;

    public LoaderFragment()
    {

    }
    public static LoaderFragment newInstance(int time)
    {
        return new LoaderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_loader,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);
        textView=view.findViewById(R.id.textView3);
    }

    public void UpdateValue(int value)
    {
        textView.setText("Please wait for "+value+" seconds");
    }

}
