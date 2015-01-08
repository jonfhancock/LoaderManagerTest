package com.jonfhancock.loadermanagertest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.util.Log;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private static final String TAG = "LoaderManagerTest";
    private LoaderManager mLoaderManager1;
    private LoaderManager mLoaderManager2;


    private String mThisFragmentInternalId1;
    private String mThisFragmentInternalId2;



    public BlankFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoaderManager1 = getLoaderManager();
        mThisFragmentInternalId1 = this.toString();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoaderManager2 = getLoaderManager();
        mThisFragmentInternalId2 = this.toString();

        Log.d(TAG,"mThisFragmentInternalId1 = " + mThisFragmentInternalId1);
        Log.d(TAG,"mThisFragmentInternalId2 = " + mThisFragmentInternalId2);

        Log.d(TAG,"mLoaderManager1 == mLoaderManager2 = " + (mLoaderManager1 == mLoaderManager2));
    }
}
