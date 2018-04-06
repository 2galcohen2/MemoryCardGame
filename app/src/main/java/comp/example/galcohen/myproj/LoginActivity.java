package comp.example.galcohen.myproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName;
    EditText etUserAge;
    TextView tvTitle;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = (EditText)findViewById(R.id.etUserName);
        etUserAge = (EditText)findViewById(R.id.etUserAge);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        btLogin = (Button)findViewById(R.id.btLogin);
    }

    //Login button clicked
    public void onLoginClicked(View v){
        Intent menuActivityIntent = new Intent(this, MenuActivity.class);

        //Passing information of the user to the next activity
        menuActivityIntent.putExtra("userName", etUserName.getText().toString());
        menuActivityIntent.putExtra("userAge", etUserAge.getText().toString());
        startActivity(menuActivityIntent);
    }
}

