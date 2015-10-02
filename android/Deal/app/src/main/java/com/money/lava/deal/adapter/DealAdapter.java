package com.money.lava.deal.adapter;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.money.lava.deal.R;
import com.money.lava.deal.model.DealInfo;
import com.money.lava.deal.view.BorrowerFormFragment;

import java.util.List;

/**
 * Created by Bible on 10/1/15.
 */
public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    private List<DealInfo> dealInfos;
    private Context context;

    public DealAdapter(Context context, List<DealInfo> dealInfos) {
        this.dealInfos = dealInfos;
        this.context = context;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvPeriod;
        public TextView tvPurpose;
        public TextView tvMethod;
        public TextView tvRevenue;
        public TextView tvGurantee;

        public ViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvPeriod = (TextView) v.findViewById(R.id.tvPeriod);
            tvPurpose = (TextView) v.findViewById(R.id.tvPurpose);
            tvMethod = (TextView) v.findViewById(R.id.tvMethod);
            tvRevenue = (TextView) v.findViewById(R.id.tvRevenue);
            tvGurantee = (TextView) v.findViewById(R.id.tvGurantee);

        }
    }

    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deal_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DealAdapter.ViewHolder holder, int position) {
        DealInfo dealInfo = dealInfos.get(position);
        holder.tvName.setText("姓名： " + dealInfo.getBorrowerName());
        holder.tvPeriod.setText("借款期間： " + dealInfo.getPeriod());
        holder.tvPurpose.setText("貸款用途： " + dealInfo.getPurpose());
        holder.tvMethod.setText("還款方式： " + dealInfo.getMethod());
        holder.tvRevenue.setText("收入來源： " + dealInfo.getRevenue());
        holder.tvGurantee.setText("擔保品： " + dealInfo.getGurantee());
    }

    @Override
    public int getItemCount() {
        return dealInfos.size();
    }

}
