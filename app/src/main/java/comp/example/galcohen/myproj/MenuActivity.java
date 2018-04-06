package comp.example.galcohen.myproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MenuActivity extends AppCompatActivity {


    TextView tvTitle;
    Spinner spDiffLevel;
    GameLevel gmLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String strTitle = getIntent().getStringExtra("userName") + " " +
                getIntent().getStringExtra("userAge");

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        spDiffLevel = (Spinner) findViewById(R.id.spDiffLevel);
        tvTitle.setText(strTitle);

        spDiffLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String stSpinnerCh = parentView.getItemAtPosition(position).toString();
                gmLevel = new GameLevel(stSpinnerCh);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    //Login button clicked
    public void onPlayClicked(View v) {
        Intent menuActivityIntent = new Intent(this, MainActivity.class);

        if (gmLevel == null) {
            //sent alert
        }
        else {
            menuActivityIntent.putExtra("gameLevel", gmLevel );
            startActivity(menuActivityIntent);
        }

        }

    }
