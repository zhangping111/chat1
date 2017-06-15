package com.example.chat_;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14 0014.
 */

public class Server {
    ServerSocket ss=null;
    List<Socket> sockets;
    public void start(){
        try {
            ss=new ServerSocket(5000);
            sockets=new ArrayList<Socket>();
            while (true){
                Socket s=ss.accept();
                sockets.add(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
