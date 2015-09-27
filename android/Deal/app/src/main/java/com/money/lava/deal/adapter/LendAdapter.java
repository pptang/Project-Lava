package com.money.lava.deal.adapter;

import android.app.Activity;
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
import com.money.lava.deal.model.LendItem;
import com.money.lava.deal.view.BorrowerFormFragment;

import java.util.List;


public class LendAdapter extends RecyclerView.Adapter<LendAdapter.ViewHolder> {

    private List<LendItem> lendItems;
    private Context context;
    private FragmentManager fragmentManager;
    public LendAdapter(Context context, List<LendItem> lendItems, FragmentManager fm) {
        this.lendItems = lendItems;
        this.context = context;
        this.fragmentManager = fm;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvAmount;
        public TextView tvRate;
        public Button btnBorrow;
        public ViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvAmount = (TextView) v.findViewById(R.id.tvAmount);
            tvRate = (TextView) v.findViewById(R.id.tvRate);
            btnBorrow = (Button) v.findViewById(R.id.btnBorrow);
        }
    }

    @Override
    public LendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lend_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LendAdapter.ViewHolder holder, int position) {
        LendItem item = lendItems.get(position);
        holder.tvName.setText("姓名： " + item.getName());
        holder.tvAmount.setText("金額： " + item.getAmount() + "元");
        holder.tvRate.setText("利率： " + item.getRate() + "%");
        holder.btnBorrow.setOnClickListener(v -> {
            DialogFragment fragment = new BorrowerFormFragment();
            fragment.show(fragmentManager, "fragment_borrower_form");
        });
    }

    @Override
    public int getItemCount() {
        return lendItems.size();
    }

    public void addItem(LendItem item) {

        lendItems.add(0, item);
        notifyDataSetChanged();

    }
}
