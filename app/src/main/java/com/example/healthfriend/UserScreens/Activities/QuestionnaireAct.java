package com.example.healthfriend.UserScreens.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.healthfriend.UserScreens.User;
import com.example.healthfriend.R;
import com.example.healthfriend.UserScreens.FireStoreManager;

public class QuestionnaireAct extends AppCompatActivity {
    User currentUser;
    private FireStoreManager fireStoreManager;
    String selectedGoal;
    private Spinner healthGoalSpinner;
    EditText weight,height,age;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    String gender;
    Button Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        currentUser = User.getInstance();
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        age=findViewById(R.id.age);
        genderRadioGroup = findViewById(R.id.gender_radio_group);
        maleRadioButton = findViewById(R.id.male_radio_button);
        femaleRadioButton = findViewById(R.id.female_radio_button);
        Confirm=findViewById(R.id.confirm);
        // Set listener for radio group to handle selection change
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button is selected
                if (checkedId == R.id.male_radio_button) {
                    gender="Male";
                    // Male option selected
                } else if (checkedId == R.id.female_radio_button) {
                    // Female option selected
                    gender="Female";
                }
            }
        });
        String[] healthGoals = {"Health & Wellness", "Weight Control", "Weight Gain", "Easy Monitoring"};

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, healthGoals);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Get Spinner reference
        healthGoalSpinner = findViewById(R.id.health_goal_spinner);

        // Set ArrayAdapter to Spinner
        healthGoalSpinner.setAdapter(adapter);

        // Optionally, handle item selection using a listener
        healthGoalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGoal = parent.getItemAtPosition(position).toString();
                // Handle the selected goal
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case when nothing is selected
            }
        });
        //edit text data

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double w= Double.parseDouble(weight.getText().toString());
                double h=Double.parseDouble(height.getText().toString());
                int a=Integer.parseInt(age.getText().toString());
                currentUser.setAge(a);
                currentUser.setHeight(h);
                currentUser.setWeight(w);
                currentUser.setPlan(selectedGoal);
                currentUser.setDaily_calories_need();
                currentUser.setGender(gender);
                currentUser.setDaily_water_need();
                currentUser.setDaily_carbs_need();
                currentUser.setDaily_proteins_need();
                currentUser.setDaily_fats_need();
                fireStoreManager = new FireStoreManager();
                fireStoreManager.setUserPersonalInfo(currentUser);
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}