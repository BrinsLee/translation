package com.brins.translation.translation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brins.translation.translation.R;
import com.brins.translation.translation.database.CollectionDatabase;
import com.brins.translation.translation.database.CollectionDatabaseHelper;
import com.brins.translation.translation.model.dataSet;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    public List<dataSet> dataSets;
    public CollectionDatabaseHelper database;
    private OnItemClickListener itemClickListener;

    public RecyclerAdapter(List<dataSet> dataSets,CollectionDatabaseHelper database) {
        this.dataSets = dataSets;
        this.database = database;
    }

    @NonNull
    @Override
    public RecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collectionitem,viewGroup,false);
        viewHolder holder = new viewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(v);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.viewHolder holder, final int i) {

        holder.tv_origin.setText(dataSets.get(i).getText());
        holder.tv_target.setText(dataSets.get(i).getTarget());
        holder.iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData(i);
            }
        });
        /*holder.originlan.setText(dataSets.get(i).getSourcelan());
        holder.targetlan.setText(dataSets.get(i).getTargetlan());*/

    }

    @Override
    public int getItemCount() {
        return dataSets.size();
    }

    public void addData(int position, dataSet data) {
        dataSets.add(position,data);
        notifyItemInserted(position);
    }

    // 删除数据
    public void removeData(int position) {
        if (dataSets.size() == 0){
            return;
        }
        database.delete(dataSets.get(position));
        dataSets.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    static class viewHolder extends RecyclerView.ViewHolder{

        TextView tv_origin;
        TextView tv_target;
        ImageView iv_del;
        /*TextView originlan;
        TextView targetlan;*/
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_origin = itemView.findViewById(R.id.tv_origin_text);
            tv_target = itemView.findViewById(R.id.tv_target_text);
            iv_del = itemView.findViewById(R.id.del);
            /*originlan = itemView.findViewById(R.id.originlan);
            targetlan = itemView.findViewById(R.id.targetlan);*/
        }
    }

    public static interface OnItemClickListener {
        void onItemClick(View view);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }
}
