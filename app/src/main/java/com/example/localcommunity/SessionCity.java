package com.example.localcommunity;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionCity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionCity(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(City city){
        //save session of user whenever user is logged in
        String id = city.getId();

        editor.putString(SESSION_KEY,id).commit();
    }

    public String getSession(){
        //return user id whose session is saved
        return sharedPreferences.getString(SESSION_KEY, "");
    }

    public void removeSession(){
        editor.putString(SESSION_KEY,"").commit();
    }
}
