package com.example.androidwork5_21;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class FileUtils {

    static final String LOG = "myLogs";


    public static void writeFile(Context context, String datal, String datap) {
        try  {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(context.openFileOutput("login", MODE_PRIVATE)));
            writer.write(datal + "\n" + datap);
            writer.close();
            Log.d(LOG, "Файл записан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public String readFile(Context context) {
        String line = "";
        String result = "";
        try  {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput("login")));
            while ((line = reader.readLine()) != null) {
                result = result + line + ";";
                Log.d(LOG, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

