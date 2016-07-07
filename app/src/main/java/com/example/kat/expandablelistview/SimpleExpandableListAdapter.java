package com.example.kat.expandablelistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by KAT on 2016/7/7.
 */
public class SimpleExpandableListAdapter implements ExpandableListAdapter {

    private class ViewHolder {
        private TextView label;
    }

    public SimpleExpandableListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    private String[] fileNames = new String[]{
            "WORD", "EXCEL", "EMAIL", "PPT"
    };

    private String[][] functions = new String[][]{
            {"文档编辑", "文档排版", "文档处理", "文档打印"},
            {"表格编辑", "表格排版", "表格处理", "表格打印"},
            {"收发邮件", "管理邮箱", "登录登出", "注册绑定"},
            {"演示编辑", "演示排版", "演示处理", "演示打印"},
    };

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return fileNames.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return functions[groupPosition].length;
    }

    @Override
    public String getGroup(int groupPosition) {
        return fileNames[groupPosition];
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return functions[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.elistitem_group, null);
            viewHolder = new ViewHolder();
            viewHolder.label = (TextView)convertView.findViewById(R.id.tv_group_label);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.label.setText(getGroup(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.elistitem_child, null);
            viewHolder = new ViewHolder();
            viewHolder.label = (TextView)convertView.findViewById(R.id.tv_child_label);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.label.setText(getChild(groupPosition, childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private LayoutInflater layoutInflater;
}
