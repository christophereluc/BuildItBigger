package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.chris.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * Created by Chris on 6/4/2016.
 */
public class JokeTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private final SoftReference<OnJokeRetrievedListener> mListener;

    public JokeTask(OnJokeRetrievedListener listener) {
        mListener = new SoftReference<>(listener);
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                                                      new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (isCancelled()) {
            return;
        }
        OnJokeRetrievedListener listener = mListener.get();
        if (listener != null) {
            listener.onJokeRetrieved(result);
        }
    }

    public interface OnJokeRetrievedListener {
        void onJokeRetrieved(String joke);
    }
}