package ro.pub.cs.systems.practicaltest01var06;
import java.util.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
/**
 * Created by robert on 4/1/16.
 */
public class ProcessingThread  extends Thread {




    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    String url;
    private double geometricMean;

    public ProcessingThread(Context context, String url ) {
        this.context = context;
        this.url=url;

    }

    @Override
    public void run() {
        Log.d("[ProcessingThread]", "Thread has started!");
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d("[ProcessingThread]", "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.putExtra("URL", this.url);
        intent.setAction(Intent.ACTION_SEND);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}

