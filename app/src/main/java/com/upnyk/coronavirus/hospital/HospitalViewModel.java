package com.upnyk.coronavirus.hospital;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.coronavirus.pojo.hospital.DataItem;
import com.upnyk.coronavirus.pojo.hospital.HospitalResponse;
import com.upnyk.coronavirus.service.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {

    private MutableLiveData<List<DataItem>> hospitalList;

    public HospitalViewModel() {
        hospitalList = new MutableLiveData<>();
    }

    public MutableLiveData<List<DataItem>> getHospitalList() {
        return hospitalList;
    }

    public void getData(){
        APIService apiService = new APIService();
        apiService.getAPI().getHospital().enqueue(new Callback<HospitalResponse>() {
            @Override
            public void onResponse(Call<HospitalResponse> call, Response<HospitalResponse> response) {
                hospitalList.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<HospitalResponse> call, Throwable t) {

            }
        });
    }
}
