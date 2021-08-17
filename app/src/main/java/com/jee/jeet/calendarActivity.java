package com.jee.jeet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calendarActivity extends AppCompatActivity {

    EditText title;
    EditText description;
    EditText emailId;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        emailId = findViewById(R.id.email);
        submitButton = findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty() && !description.getText().toString().isEmpty() && !emailId.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(calendarActivity.this, "YOU DONT HAVE AN APP WHICH CAN PERFORM THE ACTION", Toast.LENGTH_SHORT).show();
                    }


                }
                else {
                    Toast.makeText(calendarActivity.this, "PLEASE FILL ALL DETAILS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}