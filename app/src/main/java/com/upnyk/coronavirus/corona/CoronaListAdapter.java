package com.upnyk.coronavirus.corona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.coronavirus.R;
import com.upnyk.coronavirus.pojo.corona.ContentItem;
import com.upnyk.coronavirus.pojo.corona.CoronaResponse;

import java.util.List;

public class CoronaListAdapter extends RecyclerView.Adapter<CoronaListAdapter.ViewHolder> {

    private Context context;
    private List<ContentItem> coronaList;

    public CoronaListAdapter(Context context, List<ContentItem> coronaList) {
        this.context = context;
        this.coronaList = coronaList;
    }

    public void setCoronaList(List<ContentItem> coronaList) {
        this.coronaList = coronaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.corona_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return coronaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDate, tvConfirmed, tvRecovered, tvDied;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_date_list_item);
            tvConfirmed = itemView.findViewById(R.id.tv_confirmed_list_item);
            tvRecovered = itemView.findViewById(R.id.tv_recovered_list_item);
            tvDied = itemView.findViewById(R.id.tv_died_list_item);
        }

        public void bind(int position) {
            tvDate.setText(coronaList.get(position).getTanggal());
            tvConfirmed.setText(String.valueOf(coronaList.get(position).getConfirmationDiisolasi()));
            tvRecovered.setText(String.valueOf(coronaList.get(position).getConfirmationSelesai()));
            tvDied.setText(String.valueOf(coronaList.get(position).getConfirmationMeninggal()));
        }
    }
}
