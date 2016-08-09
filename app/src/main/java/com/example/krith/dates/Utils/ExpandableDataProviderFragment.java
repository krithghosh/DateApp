package com.example.krith.dates.Utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.krith.dates.TransferObjects.Sessions;
import com.example.krith.dates.Utils.AbstractExpandableDataProvider;
import com.example.krith.dates.Utils.ExpandableDataProvider;

import java.io.Serializable;

/**
 * Created by krith on 08/08/16.
 */
public class ExpandableDataProviderFragment extends Fragment {
    private ExpandableDataProvider mDataProvider;

    public ExpandableDataProviderFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public AbstractExpandableDataProvider getDataProvider(Sessions sessions) {
        Log.d("Session morning", Integer.toString(sessions.getMorning().size()));
        mDataProvider = new ExpandableDataProvider(sessions);
        return mDataProvider;
    }
}
