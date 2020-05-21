package com.example.asynctask;

import android.content.Intent;
import android.view.View;

public class OpenActivity  implements View.OnClickListener{

    private Class b;

    public OpenActivity(Class b)
    {
        this.b=b;

    }

    @Override
    public void onClick(View v) {

        Intent i=new Intent(v.getContext(),b);
        v.getContext().startActivity(i);
    }
}