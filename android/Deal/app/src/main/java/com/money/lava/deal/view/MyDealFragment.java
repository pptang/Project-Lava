package com.money.lava.deal.view;


import android.app.FragmentManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.money.lava.deal.R;
import com.money.lava.deal.adapter.DealAdapter;
import com.money.lava.deal.model.DealInfo;

import java.util.ArrayList;
import java.util.List;

public class MyDealFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;

    public MyDealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_deal, container, false);
        context = getActivity();
        getActivity().setTitle("My Deal");
        findWidgets(view);
        getMyDeals();
        return view;
    }
    private void findWidgets(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    private void getMyDeals() {
        new AsyncTask<Void, Void, Void>() {

            List<DealInfo> dealInfos = new ArrayList<DealInfo>();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {

//                LendTable lendTable = new LendTable(context);
//                lendItems = lendTable.getAll();

                DealInfo info1 = new DealInfo("Bible", "5年1個月", "購置土地", "定期定額", "薪資收入",
                        "是");
                DealInfo info2 = new DealInfo("Mark", "半年", "公司週轉", "一次償還", "投資收入",
                        "否");
                DealInfo info3 = new DealInfo("Kevin", "4年", "家庭週轉", "定期定額", "執行業務收入",
                        "是");
                dealInfos.add(info1);
                dealInfos.add(info2);
                dealInfos.add(info3);


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter = new DealAdapter(context, dealInfos);
                recyclerView.setAdapter(adapter);
            }
        }.execute();
    }

}
