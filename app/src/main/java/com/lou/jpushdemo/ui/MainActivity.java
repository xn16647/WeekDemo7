package com.jiyun.jpushdemo.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiyun.jpushdemo.Beans.DataBean;
import com.jiyun.jpushdemo.Beans.MyBean;
import com.jiyun.jpushdemo.R;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import org.byteam.superadapter.OnItemClickListener;
import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, BaseRefreshListener {

    private Toolbar m_toolbar;
    private RecyclerView m_recyc;
    private RequestQueue requestQueue;
    private String urlString = "http://v.juhe.cn/toutiao/index?type=top&key=097060266650f67b2cebd2a06aded587";
    private SuperAdapter<DataBean> superAdapter;
    private List<DataBean> data;
    private PullToRefreshLayout pull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolbar();
        initData();
    }


    private void initData() {
        requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(urlString, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                data = new Gson().fromJson(response, MyBean.class).getResult().getData();
                superAdapter = new SuperAdapter<DataBean>(MainActivity.this, data, R.layout.rv_item) {

                    @Override
                    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, DataBean item) {
                        holder.setText(R.id.rv_title, data.get(layoutPosition).getTitle());
                        holder.setText(R.id.rv_msg, data.get(layoutPosition).getAuthor_name());
                        ImageView img = holder.itemView.findViewById(R.id.rv_img);
                        Glide.with(MainActivity.this).load(data.get(layoutPosition).getThumbnail_pic_s()).into(img);
                    }
                };
                m_recyc.setAdapter(superAdapter);
                superAdapter.setOnItemClickListener(MainActivity.this);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
        requestQueue.start();
    }

    private void initToolbar() {
        setSupportActionBar(m_toolbar);
        m_toolbar.setNavigationIcon(R.mipmap.em_mm_title_back);

    }

    private void initView() {
        m_toolbar = (Toolbar) findViewById(R.id.m_toolbar);
        m_recyc = (RecyclerView) findViewById(R.id.m_recyc);
        m_recyc.setLayoutManager(new LinearLayoutManager(this));
        m_recyc.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        pull = (PullToRefreshLayout) findViewById(R.id.pull);
        pull.setRefreshListener(this);
    }

    @Override
    public void onItemClick(View itemView, int viewType, final int position) {
        new AlertDialog.Builder(this).setTitle("你是否要删除该条目？").setNegativeButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                data.remove(position);
                superAdapter.notifyDataSetChanged();
            }
        }).setPositiveButton("否", null)
                .create()
                .show();
    }

    @Override
    public void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pull.finishRefresh();
            }
        },2000);

    }

    @Override
    public void loadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.add(new DataBean("嘿嘿嘿","么么哒","http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg"));
                superAdapter.notifyDataSetChanged();
                pull.finishLoadMore();
            }
        },2000);
    }
}
