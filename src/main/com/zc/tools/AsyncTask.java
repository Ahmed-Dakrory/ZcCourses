package main.com.zc.tools;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CompletableFuture;

import javax.swing.SwingUtilities;


public abstract class AsyncTask <Params, Progress, Result> {
    protected AsyncTask() {
    }

    protected abstract void onPreExecute();

    protected abstract Result doInBackground(Params params) ;

    protected abstract void onProgressUpdate(Progress progress) ;

    protected abstract void onPostExecute(Result result) ;

    protected final void  publishProgress(Progress values) {
        SwingUtilities.invokeLater(() -> this.onProgressUpdate(values) );
    }

    public void execute(Params params) {
        // Invoke pre execute
        try {
            SwingUtilities.invokeAndWait( this::onPreExecute );
        } catch (InvocationTargetException|InterruptedException e){
            e.printStackTrace();
        }

        // Invoke doInBackground
        CompletableFuture<Result> cf =  CompletableFuture.supplyAsync( () -> doInBackground(params) );

        // Invoke post execute
        cf.thenAccept(this::onPostExecute);
    }
}