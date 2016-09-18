package com.example.uptop.pandorikatest.adapter;import android.content.Context;import android.support.v7.widget.RecyclerView;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.TextView;import com.bumptech.glide.Glide;import com.example.uptop.pandorikatest.R;import com.example.uptop.pandorikatest.database.models.Recordings;import java.util.List;public class AllRecordingsAdapter extends RecyclerView.Adapter<AllRecordingsAdapter.ViewHolder> {    private List<Recordings> mDataset;    private Recordings recordings;    Context context;    public class ViewHolder extends RecyclerView.ViewHolder{        public TextView artistName;        public TextView musicName;        public ImageView imageView;        public ViewHolder(View v) {            super(v);            artistName = (TextView) v.findViewById(R.id.record_artistname);            musicName = (TextView) v.findViewById(R.id.record_musicname);            imageView = (ImageView) v.findViewById(R.id.record_image);        }    }    public AllRecordingsAdapter(List<Recordings> myDataset, Context context) {        mDataset = myDataset;        this.context = context;    }    @Override    public AllRecordingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,                                                              int viewType) {        View v = LayoutInflater.from(parent.getContext())        .inflate(R.layout.record_item, parent, false);        ViewHolder vh = new ViewHolder(v);        return vh;    }    @Override    public void onBindViewHolder (ViewHolder holder, int position) {        recordings = mDataset.get(position);        holder.artistName.setText(recordings.getArtistName());        holder.musicName.setText(recordings.getMusicName());        Glide.with(context).load(recordings.getImgUrl()).into(holder.imageView);    }    public void refresh(List<Recordings> data) {        mDataset.clear();        mDataset.addAll(data);        notifyDataSetChanged();    }    @Override    public int getItemCount() {        return mDataset.size();    }}