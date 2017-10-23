package com.example.android.postsdemo;

import android.os.Bundle;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by danielbeleza on 20/10/2017.
 */

// Singleton class for all presenters, to save presenters state so we can restore it later, every time we re-create the activity
public class PresenterManager {

    // Singleton purpose
    private static PresenterManager instance;

    private static final String PRESENTER_ID_KEY = "presenter_id";

    private HashMap<Long, BasePresenter> presenters;

    private final AtomicLong currentID;

    public static PresenterManager getInstance(){
        if(instance == null){
            instance = new PresenterManager();
        }
        return instance;
    }

    private PresenterManager(){
        currentID = new AtomicLong();
        presenters = new HashMap<>();
    }

    public BasePresenter restorePresenter(Bundle saveInstanceState){
        if(saveInstanceState != null){
            Long presenterID = saveInstanceState.getLong(PRESENTER_ID_KEY);
            BasePresenter basePresenter = presenters.get(presenterID);

            // We restore the presenter succesfully, and we don't wan't it to remain in our hashap.
            presenters.remove(presenterID);
            return basePresenter;
        }
        return null;
    }

    public void savePresenter(BasePresenter basePresenter, Bundle outState){
        Long presenterID = basePresenter.getPresenterID();

        if(presenterID==null){
            presenterID = currentID.incrementAndGet();
            basePresenter.setPresenterID(presenterID);
        }

        presenters.put(presenterID, basePresenter);
        outState.putLong(PRESENTER_ID_KEY, presenterID);
    }

    public void removePresenter(BasePresenter presenter){
        Long presenterID = presenter.getPresenterID();
        presenters.remove(presenterID);
    }
}
