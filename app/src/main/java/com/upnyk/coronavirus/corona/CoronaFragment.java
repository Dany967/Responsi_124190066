package com.upnyk.coronavirus.corona;

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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.upnyk.coronavirus.R;

import java.util.ArrayList;

public class CoronaFragment extends Fragment {

    private TextView tvLoading;
    private CoronaViewModel coronaViewModel;
    private RecyclerView rvCorona;
    private CoronaListAdapter coronaListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_corona, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvLoading = view.findViewById(R.id.tv_loading_corona);
        rvCorona = view.findViewById(R.id.rv_corona);
        coronaListAdapter = new CoronaListAdapter(getActivity(), new ArrayList<>());
        coronaViewModel = new ViewModelProvider(this).get(CoronaViewModel.class);

        rvCorona.setAdapter(coronaListAdapter);
        rvCorona.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, true));
        rvCorona.setHasFixedSize(true);

        coronaViewModel.getCoronaList().observe(requireActivity(), contentItems -> {
            coronaListAdapter.setCoronaList(contentItems);
            coronaListAdapter.notifyDataSetChanged();
            rvCorona.scrollToPosition(coronaListAdapter.getItemCount()-1);

            if (contentItems.size() > 0) {
                tvLoading.setVisibility(View.INVISIBLE);
            } else {
                tvLoading.setVisibility(View.VISIBLE);
            }
        });

        coronaViewModel.getData();
    }
}