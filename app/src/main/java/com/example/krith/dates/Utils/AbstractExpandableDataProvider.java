package com.example.krith.dates.Utils;

/**
 * Created by krith on 07/08/16.
 */
public abstract class AbstractExpandableDataProvider {

    public static abstract class GroupData {
        public abstract String getText();

        public abstract void setPinned(boolean pinned);

        public abstract boolean isPinned();

        public abstract boolean isSectionHeader();

        public abstract long getGroupId();

        public abstract int getAvailableSlots();
    }

    public static abstract class ChildData {

        public abstract String getText();

        public abstract void setPinned(boolean pinned);

        public abstract boolean isPinned();

        public abstract long getChildId();

        public abstract boolean isAvailable();
    }

    public abstract int getGroupCount();

    public abstract int getChildCount(int groupPosition);

    public abstract GroupData getGroupItem(int groupPosition);

    public abstract ChildData getChildItem(int groupPosition, int childPosition);

    public abstract void moveGroupItem(int fromGroupPosition, int toGroupPosition);

    public abstract void moveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition);

    public abstract void removeGroupItem(int groupPosition);

    public abstract void removeChildItem(int groupPosition, int childPosition);

    public abstract long undoLastRemoval();
}
