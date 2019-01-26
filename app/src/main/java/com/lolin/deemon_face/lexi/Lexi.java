package com.lolin.deemon_face.lexi;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

public class Lexi extends Application {

    @Override
    public void onCreate() {
        super.onCreate ();

        Firebase.setAndroidContext (this);
    }
}
