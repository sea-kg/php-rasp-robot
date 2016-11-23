package com.seakg.rasprobotcli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.tubesock.WebSocket;
import com.firebase.tubesock.WebSocketEventHandler;
import com.firebase.tubesock.WebSocketException;
import com.firebase.tubesock.WebSocketMessage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Semaphore;

public class ControlsActivity extends AppCompatActivity implements WebSocketEventHandler {
    private static final String TAG = ControlsActivity.class.getSimpleName();
    private String mIP = "";
    private TextView mStatus = null;
    private Button mBtnForward;
    private Button mBtnBackward;
    private Button mBtnLeft;
    private Button mBtnRight;
    private WebSocket mWebSocket;
    private boolean mOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_controls);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        mIP = intent.getStringExtra("ip");
        mStatus = (TextView) findViewById(R.id.textView_status);
        mStatus.setText("Connecting to ws://" + mIP + ":1234/");

        mBtnForward = (Button) findViewById(R.id.btn_forward);
        mBtnBackward = (Button) findViewById(R.id.btn_backward);
        mBtnLeft = (Button) findViewById(R.id.btn_left);
        mBtnRight = (Button) findViewById(R.id.btn_right);

        mBtnForward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();
                if(eventaction == MotionEvent.ACTION_DOWN) {
                    sendCommand("forward");
                    return true;
                }else if(eventaction == MotionEvent.ACTION_UP){
                    sendCommand("stop");
                }
                return false;
            }
        });

        mBtnBackward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();
                if(eventaction == MotionEvent.ACTION_DOWN) {
                    sendCommand("backward");
                    return true;
                }else if(eventaction == MotionEvent.ACTION_UP){
                    sendCommand("stop");
                }
                return false;
            }
        });

        mBtnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();
                if(eventaction == MotionEvent.ACTION_DOWN) {
                    sendCommand("turnleft");
                    return true;
                }else if(eventaction == MotionEvent.ACTION_UP){
                    sendCommand("stop");
                }
                return false;
            }
        });

        mBtnRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventaction = event.getAction();
                if(eventaction == MotionEvent.ACTION_DOWN) {
                    sendCommand("turnright");
                    return true;
                }else if(eventaction == MotionEvent.ACTION_UP){
                    sendCommand("stop");
                }
                return false;
            }
        });

        String url1 = "ws://" + mIP + ":1234/";
        Log.i(TAG, "Try connect to " + url1);
        URI uri = null;
        try {
            uri = new URI(url1);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        mWebSocket = new WebSocket(uri);
        mWebSocket.setEventHandler(this);
        mWebSocket.connect();
    }

    private void sendCommand(String cmd){
        Log.i(TAG, "send_command " + cmd);
        JSONObject jsonCmd = new JSONObject();
        try {
            jsonCmd.put("cmd", cmd);
            if(mOpened)
                mWebSocket.send(jsonCmd.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateStatus(final String s){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStatus.setText(s);
            }
        });
    }

    @Override
    public void onOpen() {
        Log.i(TAG, "Opened socket");
        mOpened = true;
        updateStatus("Connected to ws://" + mIP + ":1234/");
        // mWebSocket.close();
    }

    @Override
    public void onMessage(WebSocketMessage message) {
        Log.i(TAG, "Message: " + message);
    }

    @Override
    public void onClose() {
        Log.i(TAG, "Closed socket");
        updateStatus("Closed connection");
        mOpened = false;
    }

    @Override
    public void onError(WebSocketException e) {
        updateStatus("Could not connect.");
        Log.e(TAG, e.getMessage());
        e.printStackTrace();
    }

    @Override
    public void onLogMessage(String msg) {
        Log.i(TAG, "LogMsg:" + msg);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mOpened)
            mWebSocket.close();
    }
}
