package com.example.mcccafe.splashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by MCC CAFE on 3/30/2017.
 */
public class CustomAdapter extends BaseAdapter {



    String[] result;
    String[] result1;
    String[] result2;
    String[] result3;
    Context context;

    public CustomAdapter(Context context, String[] result, String[] result1, String[] result2, String[] result3)
    {
        this.context=context;
        this.result=result;
        this.result1=result1;
        this.result2=result2;
        this.result3=result3;
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return result[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        Button b1;
    }
    @Override
    public View getView(int position, android.view.View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Holder holder=new Holder();
        View rowview;

        rowview=inflater.inflate(R.layout.singlerowplans,null);
        holder.tv=(TextView)rowview.findViewById(R.id.txt_amount_id);
        holder.tv1=(TextView)rowview.findViewById(R.id.txt_validity_id);
        holder.tv2=(TextView)rowview.findViewById(R.id.plan_id);
        holder.tv3=(TextView)rowview.findViewById(R.id.discription_id);
        holder.b1=(Button)rowview.findViewById(R.id.amount_btn);
        holder.tv.setText(result[position]);
        holder.tv1.setText(result1[position]);
        holder.tv2.setText(result2[position]);
        holder.tv3.setText(result3[position]);
        holder.b1.setText(result[position]);

        return rowview;
    }
}
