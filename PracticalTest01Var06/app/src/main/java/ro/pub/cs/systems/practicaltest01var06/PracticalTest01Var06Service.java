package ro.pub.cs.systems.practicaltest01var06;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var06Service extends Service {
    public PracticalTest01Var06Service() {
    }


    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String url = intent.getStringExtra("URL");

        processingThread = new ProcessingThread(this, url);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}
