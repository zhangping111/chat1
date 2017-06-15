package com.example.chat_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView=null;
    List<String> chats;
    ArrayAdapter<String> adapter=null;
    EditText edNickname;
    EditText edContent;

    TextView tvEmpty;

    LinearLayout llContent;
    LinearLayout llchat;

    Socket socket=null;
    BufferedReader br;
    PrintWriter pw;

    boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalUI();
    }

    private void initalUI() {
        listView= (ListView) findViewById(R.id.lv_main_chats);
        chats=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,chats);
        listView.setAdapter(adapter);

        edNickname= (EditText) findViewById(R.id.et_main_nickname);
        edContent= (EditText) findViewById(R.id.et_main_content);

        tvEmpty= (TextView) findViewById(R.id.tv_empty);
        listView.setEmptyView(tvEmpty);

        llchat= (LinearLayout) findViewById(R.id.ll_main_chat);
        llContent= (LinearLayout) findViewById(R.id.ll_main_connect);

    }
    public void connect(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {


        try {
            socket=new Socket("176.121.33.43",5000);
            br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (flag){
                            final String resp=br.readLine();
                            if (resp==null){
                                throw new RuntimeException("服务器端已关闭");
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    chats.add(resp);
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    llContent.setVisibility(View.GONE);
                    llchat.setVisibility(View.VISIBLE);
                }
            });

        }catch (IOException e){
            e.printStackTrace();
        }
            }
        }).start();
    }
    public void send(View view){
        final String line=edContent.getText().toString();
        if (TextUtils.isEmpty(line)){
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                String nickName=edNickname.getText().toString();
                if (TextUtils.isEmpty(nickName)){
                    nickName="1703学员";
                }
                pw.println(nickName+":"+line);
                pw.flush();
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            socket.close();
            flag=false;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
