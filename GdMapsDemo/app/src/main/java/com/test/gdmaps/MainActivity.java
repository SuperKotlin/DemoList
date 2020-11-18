package com.test.gdmaps;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        disposable = Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                if (count == 0) {
                    throw new NullPointerException("This is my exception");
                }
                return 100;
            }
        }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        if (++count <= 3) {
                            Log.e("zwx848301", "retry:" + count);
                            return Observable.timer(3, TimeUnit.SECONDS);
                        }
                        return Observable.error(throwable);
                    }
                });
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e("zwx848301", "success value:" + integer);
                if (integer == 100) {
                    Observable.error(new NullPointerException("This is my exception......" + integer));
                }
                if (disposable != null && disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("zwx848301", "failed throwable:" + throwable.getMessage());
                if (disposable != null && disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        });

    }
}