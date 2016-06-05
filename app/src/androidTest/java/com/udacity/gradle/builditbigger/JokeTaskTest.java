package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Chris on 6/4/2016.
 */
public class JokeTaskTest extends AndroidTestCase {

    public void test_get_data() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);

        new JokeTask(new JokeTask.OnJokeRetrievedListener() {
            @Override
            public void onJokeRetrieved(String joke) {
                if (TextUtils.isEmpty(joke)) {
                    fail();
                }
                latch.countDown();
            }
        }).execute();
        latch.await();
    }
}
