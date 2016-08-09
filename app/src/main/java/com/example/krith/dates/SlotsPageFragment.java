package com.example.krith.dates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krith.dates.TransferObjects.Sessions;
import com.example.krith.dates.Utils.ExpandableDataProviderFragment;
import com.example.krith.dates.Utils.ExpandableFragment;

/**
 * Created by krith on 07/08/16.
 */
public class SlotsPageFragment extends Fragment {

    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";
    public Sessions sessions;
    public String title;

    public SlotsPageFragment() {
        super();
    }

    public static SlotsPageFragment newInstance() {

        SlotsPageFragment slotsFragment = new SlotsPageFragment();
        return slotsFragment;
    }

    public void setSessionAndTitle(Sessions session, String title) {
        this.sessions = session;
        this.title = title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sessions = (Sessions) getArguments().getSerializable("session");
            title = getArguments().getString("title");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getChildFragmentManager().beginTransaction()
                .add(R.id.container, ExpandableFragment.newInstance(sessions), FRAGMENT_LIST_VIEW)
                .commit();
    }
}
