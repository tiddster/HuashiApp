package net.muxi.huashiapp.ui.card;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muxistudio.appcommon.data.CardAccount;

import net.muxi.huashiapp.R;

import java.util.ArrayList;
import java.util.List;

public class CardDetailFragment extends Fragment {

    private RecyclerView mList;
    private MyAdapter mAdapter;

    public static CardDetailFragment newInstance() {
        return new CardDetailFragment();
    }

    public void setData(CardAccount cardAccount) {
        mAdapter.refresh(cardAccount.getData().getList());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_detail_list, container, false);
        mList = view.findViewById(R.id.rv_card_detail);
        mAdapter = new MyAdapter(new ArrayList<>());
        mList.setAdapter(mAdapter);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        private List<CardAccount.DataBean.ListBean> mDatas;

        public MyAdapter(List<CardAccount.DataBean.ListBean> dataList) {
            mDatas = dataList;
        }

        public void refresh(List<CardAccount.DataBean.ListBean> dataList) {
            if ( mDatas.size() > 0 ) {
                int pre = mDatas.size();
                mDatas.clear();
                notifyItemRangeRemoved(0, pre);
            }
            mDatas.addAll(dataList);
            notifyItemRangeInserted(0, dataList.size());

        }

        @Override
        public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_detail, parent, false);
            return new MyAdapter.MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            CardAccount.DataBean.ListBean data = mDatas.get(position);
            holder.name.setText(data.getDealName());
            if ( data.getDealName().equals("消费") ) {
                holder.num.setText(String.format("-%s", Double.valueOf(data.getTransMoney()).toString()));
                holder.num.setTextColor(Color.parseColor("#3D9140"));
            } else if ( data.getDealName().contains("充值") || data.getDealName().contains("补助") ) {
                holder.num.setText(String.format("+%s", Double.valueOf(data.getTransMoney()).toString()));
                holder.num.setTextColor(Color.parseColor("#B0171F"));
            } else {
                holder.num.setText(String.format("%s", Double.valueOf(data.getTransMoney()).toString()));
                holder.num.setTextColor(Color.parseColor("#A6A4FF"));
            }
            holder.org.setText(data.getOrgName());
            String date = data.getDealDate().substring(0,10);
            String tim = data.getDealDate().substring(11,19);
            holder.time.setText(date+"\n"+tim);

            AssetManager mgr = getActivity().getAssets();
            Typeface tf = Typeface.createFromAsset(mgr, "font/lao_sangam_mn.ttf");
            holder.num.setTypeface(tf);
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView name, num, org, time;
            public MyHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.tv_card_detail_name);
                num = itemView.findViewById(R.id.tv_card_detail_num);
                org = itemView.findViewById(R.id.tv_card_detail_org);
                time = itemView.findViewById(R.id.tv_card_detail_time);
            }
        }
    }


}
