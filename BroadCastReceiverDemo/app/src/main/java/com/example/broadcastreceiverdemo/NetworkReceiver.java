package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

public class NetworkReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 네트워크 상태값 받아오기
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            NetworkInfo.DetailedState state = info.getDetailedState();

            // 네트워크 연결 상태면
            if (state == NetworkInfo.DetailedState.CONNECTED) {
                MainActivity.tvState.setText("연결 상태");
            }
            // 네트워크 연결 끊기면
            else if (state == NetworkInfo.DetailedState.DISCONNECTED) {
                MainActivity.tvState.setText("연결 끊김");
            }
        }

    }

}
