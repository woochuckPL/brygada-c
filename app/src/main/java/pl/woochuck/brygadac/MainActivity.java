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

import pl.woochuck.brygadac.harmonogram.HarmonogramActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPassword;
    private TextView txtTest;
    private ProgressBar progressBar;

    private String name;
    private String password;

    private final static String LOGIN_WRONG_USER = "Cannot find user";
    private final static String LOGIN_WRONG_PASSWORD = "Login failed";
    private final static String LOGIN_SUCCESS = "Login successful";

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
            editName.setError("Musisz poda?? imi??");
            return false;
        }
        return true;
    }

    private boolean checkIfNotEmptyPassword (String password) {
        if (password.equals("")) {
            editPassword.setError("Musisz poda?? numer kontrolny");
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

                    switch (response) {
                        case LOGIN_WRONG_USER:
                            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "U??ytkownik o podanej nazwie nie istnieje", Toast.LENGTH_SHORT).show());
                            break;
                        case LOGIN_WRONG_PASSWORD:
                            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Nieprawid??owy numer kontrolny. Spr??buj ponownie", Toast.LENGTH_SHORT).show());
                            break;
                        case LOGIN_SUCCESS:
                            runOnUiThread(() -> {
                                Intent intent = new Intent(getApplicationContext(), HarmonogramActivity.class);
                                startActivity(intent);
                            });
                            break;
                        default:
                            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Co?? posz??o nie tak" + response, Toast.LENGTH_SHORT).show());
                    }



                } catch (MalformedURLException e) {
                    runOnUiThread(() -> txtTest.setText("Malformed" + e.getMessage()));
                } catch (UnsupportedEncodingException e) {
                    runOnUiThread(() -> txtTest.setText("Unsupported" + e.getMessage()));
                } catch (IOException e) {
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Nie uda??o si?? po????czy?? z serwerem logowania. Poinformuj administratora.", Toast.LENGTH_SHORT).show());
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
            byte[] hashedBytes = messageDigest.digest(password.trim().getBytes("UTF-8"));

            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            txtTest.setText(e.getMessage());
        }

        return stringBuilder.toString();
    }
}