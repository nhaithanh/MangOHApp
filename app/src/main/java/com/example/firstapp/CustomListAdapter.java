package com.example.firstapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<Sensors> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Sensors> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.flagView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.sensorName = (TextView) convertView.findViewById(R.id.tvSensor);
            holder.sensorValue = (TextView) convertView.findViewById(R.id.tvValue);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Sensors sensors = this.listData.get(position);
        holder.sensorName.setText(sensors.getSensorName());
        holder.sensorValue.setText("" + sensors.getValueSensor());

        int imageId = this.getMipmapResIdByName(sensors.getFlagName());

        holder.flagView.setImageResource(imageId);

        return convertView;
    }

    // Find ID of the Image in mipmap folder
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Return 0 if not found
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView flagView;
        TextView sensorName;
        TextView sensorValue;
    }
}