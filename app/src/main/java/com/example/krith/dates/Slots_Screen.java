package com.example.krith.dates;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.krith.dates.TransferObjects.Sessions;
import com.example.krith.dates.TransferObjects.Slots;
import com.example.krith.dates.Utils.API_Interface;
import com.example.krith.dates.Utils.AbstractExpandableDataProvider;
import com.example.krith.dates.Utils.ClientBuilder;
import com.example.krith.dates.Utils.Constants;
import com.example.krith.dates.Utils.ExpandableDataProvider;
import com.example.krith.dates.Utils.ExpandableDataProviderFragment;
import com.example.krith.dates.Utils.SlidingTabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Slots_Screen extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView month;
    private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
    private static final String FRAGMENT_LIST_VIEW = "list view";
    private SlidingTabLayout tabLayout;
    private static int screenWidth;
    private HashMap<String, Sessions> sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots__screen);

        String api_key = "a4aeb4e27f27b5786828f6cdf00d8d2cb44fe6d7";
        String vc = "276";
        String username = "alok@x.coz";
        String expert_username = "neha@healthifyme.com";
        String format = "json";

        month = (TextView) findViewById(R.id.month);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        API_Interface builder = ClientBuilder.getClient(Constants.SLOT_URL).create(API_Interface.class);
        Call<Slots> callSlots = builder.getAllSlots(api_key, vc, username, expert_username, format);
        callSlots.enqueue(new Callback<Slots>() {
            @Override
            public void onResponse(Call<Slots> call, Response<Slots> response) {
                HashMap<String, Sessions> sessions = response.body().getDates();

                List<Fragment> fragmentList = new ArrayList<Fragment>();

                for (Map.Entry<String, Sessions> entry : sessions.entrySet()) {
                    String key = entry.getKey();
                    Sessions value = entry.getValue();
                    SlotsPageFragment slotsPageFragment = SlotsPageFragment.newInstance();
                    slotsPageFragment.setSessionAndTitle(value, key);
                    fragmentList.add(slotsPageFragment);

                }

                viewPager.setAdapter(new SlotsPageAdapter(getSupportFragmentManager(), fragmentList, month));
                tabLayout = (SlidingTabLayout) findViewById(R.id.tabLayout);
                tabLayout.setDistributeEvenly(true, getScreenHeightInDp(getApplicationContext()));
                tabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                    @Override
                    public int getIndicatorColor(int position) {
                        return getResources().getColor(R.color.colorPrimary);
                    }
                });
                tabLayout.setViewPager(viewPager);
            }

            @Override
            public void onFailure(Call<Slots> call, Throwable t) {
                Log.d("Logger failure", t.getMessage());
            }
        });
    }

    public AbstractExpandableDataProvider getDataProvider(Sessions sessions) {
        /*final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
        return ((ExpandableDataProviderFragment) fragment).getDataProvider(sessions);*/

        return new ExpandableDataProvider(sessions);
    }

    public static int getScreenHeightInDp(Context context) {
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = pixelsToDp(context, size.x);
        return screenWidth;
    }

    public static int pixelsToDp(Context context, float pixels) {
        float density = context.getResources().getDisplayMetrics().densityDpi;
        return Math.round(pixels / (density / 160f));
    }
}
