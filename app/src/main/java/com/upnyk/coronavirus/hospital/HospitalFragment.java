package com.upnyk.coronavirus.hospital;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.upnyk.coronavirus.R;
import com.upnyk.coronavirus.corona.CoronaViewModel;

import java.util.ArrayList;

public class HospitalFragment extends Fragment {

    private TextView tvLoading;
    private HospitalViewModel hospitalViewModel;
    private RecyclerView rvHospital;
    private HospitalListAdapter hospitalListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLoading = view.findViewById(R.id.tv_loading_hospital);
        rvHospital = view.findViewById(R.id.rv_hospital);
        hospitalListAdapter = new HospitalListAdapter(getActivity(), new ArrayList<>());
        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);

        rvHospital.setAdapter(hospitalListAdapter);
        rvHospital.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvHospital.setHasFixedSize(true);

        hospitalViewModel.getHospitalList().observe(requireActivity(), dataItems -> {
            hospitalListAdapter.setHospitalList(dataItems);
            hospitalListAdapter.notifyDataSetChanged();

            if (dataItems.size() > 0) {
                tvLoading.setVisibility(View.INVISIBLE);
            } else {
                tvLoading.setVisibility(View.VISIBLE);
            }
        });

        hospitalViewModel.getData();
    }
}