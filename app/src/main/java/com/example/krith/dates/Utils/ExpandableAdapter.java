package com.example.krith.dates.Utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.krith.dates.R;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

/**
 * Created by krith on 07/08/16.
 */
public class ExpandableAdapter extends AbstractExpandableItemAdapter<ExpandableAdapter.GroupViewHolder, ExpandableAdapter.ChildViewHolder> {
    private static final String TAG = "MyExpandableItemAdapter";
    private AbstractExpandableDataProvider dataProvider;

    private interface Expandable extends ExpandableItemConstants {
    }

    public ExpandableAdapter(AbstractExpandableDataProvider dataProvider) {
        this.dataProvider = dataProvider;
        setHasStableIds(true);
    }

    @Override
    public int getGroupCount() {
        return dataProvider.getGroupCount();
    }

    @Override
    public int getChildCount(int groupPosition) {
        return dataProvider.getChildCount(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return dataProvider.getGroupItem(groupPosition).getGroupId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return dataProvider.getChildItem(groupPosition, childPosition).getChildId();
    }

    @Override
    public GroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(v);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.child_item, parent, false);
        return new ChildViewHolder(v);
    }

    @Override
    public int getGroupItemViewType(int groupPosition) {
        return 0;
    }

    @Override
    public int getChildItemViewType(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public void onBindGroupViewHolder(ExpandableAdapter.GroupViewHolder holder, int groupPosition, int viewType) {
        final AbstractExpandableDataProvider.GroupData item = dataProvider.getGroupItem(groupPosition);

        holder.groupText.setText(item.getText());
        holder.slotText.setText(item.getAvailableSlots() + " Slots available");
        holder.itemView.setClickable(true);

        final int expandState = holder.getExpandStateFlags();
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int groupPosition, int childPosition, int viewType) {

        final AbstractExpandableDataProvider.ChildData item = dataProvider.getChildItem(groupPosition, childPosition);
        holder.childText.setText(item.getText());
        if (!item.isAvailable()) {
            holder.childHolder.setBackgroundResource(R.drawable.disable_bkg);
        }
    }

    @Override
    public boolean onCheckCanExpandOrCollapseGroup(ExpandableAdapter.GroupViewHolder holder, int groupPosition, int x, int y, boolean expand) {

        if (dataProvider.getGroupItem(groupPosition).isPinned()) {
            return false;
        }
        if (!(holder.itemView.isEnabled() && holder.itemView.isClickable())) {
            return false;
        }
        return true;
    }

    public class ChildViewHolder extends AbstractExpandableItemViewHolder {
        public TextView childText;
        private RelativeLayout childHolder;

        public ChildViewHolder(View itemView) {
            super(itemView);
            childHolder = (RelativeLayout) itemView.findViewById(R.id.childHolder);
            childText = (TextView) itemView.findViewById(R.id.childText);
        }
    }

    public class GroupViewHolder extends AbstractExpandableItemViewHolder {
        public ImageView mIndicator;
        public TextView groupText;
        public TextView slotText;

        public GroupViewHolder(View itemView) {
            super(itemView);
            mIndicator = (ImageView) itemView.findViewById(R.id.indicator);
            groupText = (TextView) itemView.findViewById(R.id.groupText);
            slotText = (TextView) itemView.findViewById(R.id.slotText);
        }
    }
}
