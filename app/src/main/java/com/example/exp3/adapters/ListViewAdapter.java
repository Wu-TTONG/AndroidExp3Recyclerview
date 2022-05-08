package com.example.exp3.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exp3.R;
import com.example.exp3.beans.ItemBean;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    public ListViewAdapter(List<ItemBean> data){
        this.mData = data;
    }

    /**
     * 这个方法用于创建条目的View
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ListViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    /**
     * 这个方法是用于绑定holder，一般用来设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHolder holder, int position) {
        //设置数据
        holder.setData(mData.get(position));
    }

    /**
     * 返回条目个数
     * @return
     */

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;
        private final TextView mPrice;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            //找到条目的控件
            mIcon = (ImageView) itemView.findViewById(R.id.listViewIcon);
            mTitle = (TextView) itemView.findViewById(R.id.listTitle);
            mPrice = (TextView) itemView.findViewById(R.id.listPrice);
        }

        public void setData(ItemBean itemBean) {
            //设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
            mPrice.setText(String.valueOf(itemBean.price) + "￥");
        }
    }


}
