package com.upnyk.coronavirus.hospital;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.coronavirus.R;
import com.upnyk.coronavirus.corona.CoronaListAdapter;
import com.upnyk.coronavirus.pojo.hospital.DataItem;

import java.util.List;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.ViewHolder> {

    private Context context;
    private List<DataItem> hospitalList;

    public HospitalListAdapter(Context context, List<DataItem> hospitalList) {
        this.context = context;
        this.hospitalList = hospitalList;
    }

    public void setHospitalList(List<DataItem> hospitalList) {
        this.hospitalList = hospitalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hospital_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAddress;
        private Button btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name_hospital_list);
            tvAddress = itemView.findViewById(R.id.tv_address_hospital_list);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

        public void bind(int position) {
            tvName.setText(hospitalList.get(position).getNama());
            tvAddress.setText(hospitalList.get(position).getAlamat());
            btnMaps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", hospitalList.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
