package com.example.roman.bikerstrip;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.DataAll;
import com.example.Pot;

/**
 * Created by Roman on 1. 05. 2016.
 */
public class AdapterPot extends RecyclerView.Adapter<AdapterPot.ViewHolder> {
    public static final String PARAMETER_POSITION_1 = "POSITION_POT";
    private DataAll mDataset;
    Activity ac;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtHeader1;
        public TextView txtFooter;
        public TextView txtTip;
        public ImageView iv;
        public LinearLayout btnAction;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtHeader1 = (TextView) v.findViewById(R.id.secLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtTip= (TextView) v.findViewById(R.id.firstLineTip);
            iv = (ImageView)v.findViewById(R.id.icon);
            btnAction = (LinearLayout) v.findViewById(R.id.btnAction);
        }
    }

 /*   public void add(int position,Pot item) {
        mDataset.dodaj().add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    */


    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterPot(DataAll myDataset, Activity ac) {
        this.ac = ac;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPot.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Pot trenutni = mDataset.getPot(position);
        final String name = trenutni.getKrajOd();
        holder.txtHeader.setText(trenutni.getKrajOd());

        final String name1 = trenutni.getKrajDo();
        holder.txtHeader1.setText(trenutni.getKrajDo());

        final String zn = trenutni.getM().getZnamka();
        holder.txtTip.setText(trenutni.getM().getZnamka());

        /*
        holder.txtTip.setText(trenutni.getM().getTip());
        if (DataAll.picture(trenutni.getM().getTip())==1)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.sport));
        if (DataAll.picture(trenutni.getM().getTip())==2)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.chopper));
        if (DataAll.picture(trenutni.getM().getTip())==3)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.tourer));
        if (DataAll.picture(trenutni.getM().getTip())==4)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.naked));
        if (DataAll.picture(trenutni.getM().getTip())==5)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.enduro));
        if (DataAll.picture(trenutni.getM().getTip())==6)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.scooter));
        if (DataAll.picture(trenutni.getM().getTip())==7)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.moped));
        if (DataAll.picture(trenutni.getM().getTip())==8)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.atv));
        if (DataAll.picture(trenutni.getM().getTip())==9)
            holder.iv.setImageDrawable(this.  ac.getDrawable(R.drawable.supermoto));*/
        /*holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dva = new Intent(ac, MainActivity.class);
                dva.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(dva);
                System.out.println(name);
                System.out.println(name1);

            }*/
        holder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dva = new Intent(ac, MainActivity.class);
                dva.putExtra(PARAMETER_POSITION_1,position);
                ac.startActivity(dva);
                System.out.println(name);
                System.out.println(name1);

            }
        });

        if (holder.txtFooter != null){
            holder.txtFooter.setText("Znamka: "+trenutni.getM().getZnamka()+"Model :"+trenutni.getM().getModel());
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.sizePot();
    }

}