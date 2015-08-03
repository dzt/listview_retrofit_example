package com.under_rated.listofflowers;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.under_rated.listofflowers.API.FlowerHelper;
import com.under_rated.listofflowers.Model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    List<Flower> flowerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RestAdapter restadapter = new RestAdapter.Builder().setEndpoint("http://services.hanselandpetal.com").build();
        FlowerHelper flowerHelper = restadapter.create(FlowerHelper.class);

        flowerHelper.getFlowers(new Callback<List<Flower>>() {
            @Override
            public void success(List<Flower> flowers, Response response) {
                flowerList = flowers;
                ListView listView = (ListView) findViewById(R.id.list);
                FlowersListAdapter adapt = new FlowersListAdapter(getApplicationContext(), R.layout.listview_entry, flowerList);
                listView.setAdapter(adapt);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
