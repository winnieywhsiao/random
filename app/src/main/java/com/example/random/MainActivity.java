package com.example.random;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    API api;
    ArrayList<Resau> arr = new ArrayList<>();

    private String re_name;
    private TextView mtextshow;

    List<String> list;
    ListView listview;
    List<Boolean> listShow;    // 這個用來記錄哪幾個 item 是被打勾的

    //ArrayAdapter建立的只有一維資訊的ListView
    //版面內容是會變動的或是無法預先偵測數量的
    //Adapter 要接的資料
    //直接繼承BaseAdapter來建立自己的Adapter完成的全自訂ListView  (ListAdapter)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mtextshow = (TextView) findViewById(R.id.textshow);

        listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1); //list_item
                chkItem.setChecked(!chkItem.isChecked()); //預設不打勾
                //Toast.makeText(MainActivity.this, "您點選了第 "+(position+1)+" 項", Toast.LENGTH_SHORT).show();
                listShow.set(position, chkItem.isChecked()); //set打勾
            }
         }
        );

        try {
            getreslist();
        } catch (Exception e) {
            mtextshow.setText(e.toString()+ " hello");
            Log.e("todaywannaeat", e.getMessage());
        }

        //listShow = new ArrayList<Boolean>();
        //list = new ArrayList<String>(); //加入check的value

        //for(int x=1;x<5;x++){
            //list.add("項目"+1);
            //mtextshow.append(list + "\n");
            //listShow.add(true);
        //}
        //String resname = getresau();

        //list.add(resname);
        //mtextshow.append(resname + "\n");
        //ListAdapter adapterItem = new ListAdapter(this, list);
        //listview.setAdapter((android.widget.ListAdapter) adapterItem);
    }

    public void getreslist() {
        api = RetrofitManager.getInstance().getAPI();
        Call<Resau> call = api.getResau();

        call.enqueue(new Callback<Resau>() {//成功透過onresponse回傳 失敗用onfailure回傳
            @Override
            public void onResponse(Call<Resau> call, Response<Resau> response) {
                listShow = new ArrayList<Boolean>();
                list = new ArrayList<String>(); //加入check的value

                //re_name = response.body().getfieldsName(1);
                for (int i = 0; i < response.body().getarr2().length; i++) {
                    re_name = response.body().getfieldsName(i);
                    list.add(re_name);
                    //mtextshow.append(list + "\n");
                    //mtextshow.append(re_name + "\n");
                    listShow.add(true);
                }
                ListAdapter adapterItem = new ListAdapter(MainActivity.this, list);
                listview.setAdapter((android.widget.ListAdapter) adapterItem);

            }

            @Override
            public void onFailure(Call<Resau> call, Throwable t) {
                mtextshow.setText(t.getMessage());
            }
        });
        //return re_name;
    }


}
