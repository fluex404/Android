package com.fluex404.myservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MyService extends Service implements DummyAsyncCallback{
    public static final String TAG = MyService.class.getSimpleName();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
//        return super.onStartCommand(intent, flags, startId);

        DummyAsync dummyAsync = new DummyAsync(this);
        dummyAsync.execute();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void preAsync() {
        Log.d(TAG, "preAsync: Mulai...");
    }
    @Override
    public void postAsync(){
        Log.d(TAG, "postAsync: Selesai...");
        stopSelf();
    }
    private static class DummyAsync extends AsyncTask<Void, Void, Void>{
        private final WeakReference<DummyAsyncCallback> callback;
        public DummyAsync(DummyAsyncCallback dummyAsyncCallback){
            this.callback = new WeakReference<>(dummyAsyncCallback);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(TAG, "onPreExecute: ");
            callback.get().preAsync();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "doInBackground: ");
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: ");
            callback.get().postAsync();
        }
    }
}

interface DummyAsyncCallback{
    void preAsync();
    void postAsync();
}
