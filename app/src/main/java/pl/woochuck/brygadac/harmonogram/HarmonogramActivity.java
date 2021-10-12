package pl.woochuck.brygadac.harmonogram;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import pl.woochuck.brygadac.R;

public class HarmonogramActivity extends AppCompatActivity {

    private DayDAO dayDAO;
    private List<Day> days;
    private String jsonList;

    private DayAdapter dayAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ProgressBar progressBarHarmonogram;

    private TextView txtEmp1;
    private TextView txtEmp2;
    private TextView txtEmp3;
    private TextView txtEmp4;
    private TextView txtEmp5;
    private TextView txtEmp6;
    private TextView txtEmp7;
    private TextView txtEmp8;
    private TextView txtEmp9;
    private TextView txtEmp10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harmonogram);

        txtEmp1 = findViewById(R.id.txtEmp1);
        txtEmp2 = findViewById(R.id.txtEmp2);
        txtEmp3 = findViewById(R.id.txtEmp3);
        txtEmp4 = findViewById(R.id.txtEmp4);
        txtEmp5 = findViewById(R.id.txtEmp5);
        txtEmp6 = findViewById(R.id.txtEmp6);
        txtEmp7 = findViewById(R.id.txtEmp7);
        txtEmp8 = findViewById(R.id.txtEmp8);
        txtEmp9 = findViewById(R.id.txtEmp9);
        txtEmp10 = findViewById(R.id.txtEmp10);

        fillEmployeesNames();

        progressBarHarmonogram = findViewById(R.id.progressBarHarmonogram);
        recyclerView = (RecyclerView) findViewById(R.id.dayRecycler);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        dayDAO = new DayDAO(this);

        fillRecyclerView();
    }

    public void onClickBtnUpdate (View view) {
        progressBarHarmonogram.setVisibility(View.VISIBLE);

        ConnectionRunnable connectionRunnable = new ConnectionRunnable();

        Thread thread = new Thread(connectionRunnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jsonList = connectionRunnable.getJsonList();
        parseJsonToList(jsonList);

        for (Day day : days) {
            dayDAO.updateById(day);
        }

        fillRecyclerView();
    }

    private void parseJsonToList (String jsonList) {
        Gson gson = new Gson();
        Type listOfDays = new TypeToken<ArrayList<Day>>() {}.getType();
        days = gson.fromJson(jsonList, listOfDays);
    }

    private void fillRecyclerView() {
        List<Day> daysFromDb = dayDAO.findAll();
        dayAdapter = new DayAdapter(daysFromDb);
        recyclerView.setAdapter(dayAdapter);
        recyclerView.setLayoutManager(layoutManager);
        int position = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        recyclerView.getLayoutManager().scrollToPosition(position * 7 - 4);
        progressBarHarmonogram.setVisibility(View.GONE);
    }

    private void fillEmployeesNames() {
        Properties properties = new Properties();
        AssetManager assetManager = getApplicationContext().getAssets();
        try {
            properties.load(assetManager.open("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        txtEmp1.setText((String) properties.get("txtEmp1"));
        txtEmp2.setText((String) properties.get("txtEmp2"));
        txtEmp3.setText((String) properties.get("txtEmp3"));
        txtEmp4.setText((String) properties.get("txtEmp4"));
        txtEmp5.setText((String) properties.get("txtEmp5"));
        txtEmp6.setText((String) properties.get("txtEmp6"));
        txtEmp7.setText((String) properties.get("txtEmp7"));
        txtEmp8.setText((String) properties.get("txtEmp8"));
        txtEmp9.setText((String) properties.get("txtEmp9"));
        txtEmp10.setText((String) properties.get("txtEmp10"));
    }

    class ConnectionRunnable implements Runnable {

        String jsonList;

        public String getJsonList() {
            return jsonList;
        }

        @Override
        public synchronized void run() {
            try {
                Properties properties = new Properties();
                AssetManager assetManager = getApplicationContext().getAssets();
                properties.load(assetManager.open("config.properties"));
                String harmonogramUrl = (String) properties.get("harmonogramUrl");
                URL url = new URL(harmonogramUrl );
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoInput(true);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonList = response.toString();

//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
////                        textViewTest.append(jsonList);
//                    }
//                });
            } catch (IOException e) {
                Log.e("ErrorIO", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
