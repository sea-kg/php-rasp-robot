package com.seakg.rasprobotcli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.getSimpleName();
    private static final Pattern IP_PATTERN = Pattern.compile("[^0-9]*(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}).*");
    private String ip = "";
    private List<String> mIPs;
    private Spinner mSpinnerIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mSpinnerIp = (Spinner) findViewById(R.id.spinner_ips);

        Button btn_search = (Button)findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIPs = getIPs();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,mIPs);
                mSpinnerIp.setAdapter(adapter);
            }
        });

        Button btn_connect = (Button)findViewById(R.id.btn_connect);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ControlsActivity.class);
                String ip = mSpinnerIp.getSelectedItem().toString();
                Log.i(TAG, "mSpinnerIp.getSelectedItem().toString(): " + ip);
                intent.putExtra("ip", ip);
                startActivity(intent);
            }
        });



    }

    private List<String> getIPs(){

        // File sdcard = Environment.getExternalStorageDirectory();
        ArrayList<String> ips = new ArrayList();
        // ips.add("192.168.1.4");

        //Get the text file
        File file = new File("/proc/net/arp");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                Matcher matcher = IP_PATTERN.matcher(line);
                if (matcher.matches()) {
                    ip = matcher.group(1);
                    ips.add(ip);
                    Log.i(TAG, "updateRobotIP: " + ip);
                }
            }
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
        }
        return ips;
    }
}
