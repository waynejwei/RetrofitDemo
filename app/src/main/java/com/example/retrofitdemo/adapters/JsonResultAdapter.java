package com.example.retrofitdemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.domain.JsonResult;

import java.util.ArrayList;
import java.util.List;

public class JsonResultAdapter extends RecyclerView.Adapter<JsonResultAdapter.innerHolder> {

    private List<JsonResult.DataBean> data = new ArrayList<>();

    /**
     * 绑定布局
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public innerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_text_item, parent, false);
        return new innerHolder(inflate);
    }

    /**
     * 绑定控件
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull innerHolder holder, int position) {
        JsonResult.DataBean dataBean = data.get(position);
        View itemView = holder.itemView;
        //标题
        TextView titleText = itemView.findViewById(R.id.title_item);
        titleText.setText(dataBean.getTitle());

        //作者
        TextView userName = itemView.findViewById(R.id.username_item);
        userName.setText(dataBean.getUserName());

        //封面（使用Glide加载图片）
        ImageView cover = itemView.findViewById(R.id.cover);
        Glide.with(itemView.getContext()).load("http://10.0.2.2:9102"+dataBean.getCover()).into(cover);

        //阅览数
        TextView readCount = itemView.findViewById(R.id.viewCount);
        readCount.setText(String.valueOf(dataBean.getViewCount()));

        //评论数
        TextView commentTime = itemView.findViewById(R.id.commentCount);
        commentTime.setText(String.valueOf(dataBean.getCommentCount()));

        //发布时间
        TextView publishTime = itemView.findViewById(R.id.publishTime);
        publishTime.setText(dataBean.getPublishTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * 设置数据
     * @param jsonResult
     */
    public void setData(JsonResult jsonResult) {
        data.clear();
        data.addAll(jsonResult.getData());
        notifyDataSetChanged();
    }

    public class innerHolder extends RecyclerView.ViewHolder {

        public innerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
