package com.example.ekse.DB

import android.app.Application
import com.example.splashscreen.R
import com.parse.Parse

class AppDb : Application() {
    override fun onCreate() {
        super.onCreate()
        //initialize parse object
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }
}