package com.example.krith.dates;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by krith on 06/08/16.
 */
public class SlotsPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    String _months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String _weekdays[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    TextView month;

    public SlotsPageAdapter(FragmentManager fm, List<Fragment> fragmentList, TextView month) {
        super(fm);
        this.fragmentList = fragmentList;
        this.month = month;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String str = "";
        try {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            SlotsPageFragment slotsPageFragment = (SlotsPageFragment) fragmentList.get(position);
            Date date = dt.parse(slotsPageFragment.title.toString());
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            calendar.setTime(date);
            str = calendar.get(Calendar.DAY_OF_MONTH) + "\n" + _weekdays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
            month.setText(_months[calendar.get(Calendar.MONTH)]);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }
}