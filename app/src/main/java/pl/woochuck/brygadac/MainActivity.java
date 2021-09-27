package pl.woochuck.brygadac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPassword;
    private TextView txtTest;
    private ProgressBar progressBar;

    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        txtTest = (TextView) findViewById(R.id.txtTest);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void onClickBtnLogin(View view) {
        name = editName.getText().toString();
        password = editPassword.getText().toString();
        if (checkIfNotEmptyName(name) && checkIfNotEmptyPassword(password)) {
            login(name, hashPassword(password));
        }
    }

    private boolean checkIfNotEmptyName (String name) {
        if (name.equals("")) {
            editName.setError("Musisz podać imię");
            return false;
        }
        return true;
    }

    private boolean checkIfNotEmptyPassword (String password) {
        if (password.equals("")) {
            editPassword.setError("Musisz podać numer kontrolny");
            return false;
        }
        return true;
    }

    private void login (String name, String password) {
        progressBar.setVisibility(View.VISIBLE);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Properties properties = new Properties();
                    AssetManager assetManager = getApplicationContext().getAssets();
                    properties.load(assetManager.open("config.properties"));
                    String loginUrl = (String) properties.get("loginUrl");
                    URL url = new URL(loginUrl + "?username=" + name + "&password=" + password);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    InputStreamReader reader = new InputStreamReader(connection.getInputStream(), "UTF-8");
                    BufferedReader streamReader = new BufferedReader(reader);
                    StringBuilder responseStrBuilder = new StringBuilder();

                    String inputStr;
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseStrBuilder.append(inputStr);
                    }

                    String response = responseStrBuilder.toString();
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show());

                } catch (MalformedURLException e) {
                    runOnUiThread(() -> txtTest.setText("Malformed" + e.getMessage()));
                } catch (UnsupportedEncodingException e) {
                    runOnUiThread(() -> txtTest.setText("Unsupported" + e.getMessage()));
                } catch (IOException e) {
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Nie udało się połączyć z serwerem logowania. Poinformuj administratora.", Toast.LENGTH_SHORT).show());
                }

                runOnUiThread(() -> progressBar.setVisibility(View.GONE));
            }
        });

        thread.start();

//        User searchUser = new User(name, password);
//        User user = DAO.findUserByName(name);
//        if (user != null && searchUser.equals(user)) {
//            txtTest.setText("Zalogowany");
//            Intent intent = new Intent(this, HarmonogramActivity.class);
//            startActivity(intent);
//        } else {
//            txtTest.setText("Niepoprawne dane");
//        }

    }

    private String hashPassword (String password) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes("UTF-8"));

            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            txtTest.setText(e.getMessage());
        }

        return stringBuilder.toString();
    }
}