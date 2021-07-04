package com.upnyk.coronavirus.corona;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.upnyk.coronavirus.pojo.corona.ContentItem;
import com.upnyk.coronavirus.pojo.corona.CoronaResponse;
import com.upnyk.coronavirus.service.APIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaViewModel extends ViewModel {
    private MutableLiveData<List<ContentItem>> coronaList;

    public CoronaViewModel() {
        coronaList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ContentItem>> getCoronaList() {
        return coronaList;
    }

    public void getData(){
        APIService apiService = new APIService();
        apiService.getAPI().getCorona().enqueue(new Callback<CoronaResponse>() {
            @Override
            public void onResponse(Call<CoronaResponse> call, Response<CoronaResponse> response) {
                coronaList.setValue(response.body().getData().getContent());
            }

            @Override
            public void onFailure(Call<CoronaResponse> call, Throwable t) {

            }
        });
    }
}
