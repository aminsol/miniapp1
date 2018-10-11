package com.aminsoltani.mini_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import java.math.BigDecimal;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputFileSize, inputInternetSpeed;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputFileSize = findViewById(R.id.input_file_size);
        inputInternetSpeed = findViewById(R.id.input_internet_speed);
        resultText = findViewById(R.id.text_result);
        inputFileSize.addTextChangedListener(calculateUploadTime);
        inputInternetSpeed.addTextChangedListener(calculateUploadTime);
    }
    private final TextWatcher calculateUploadTime = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                resultText.setText(R.string.placeholder_result);
            } else{
                if(inputFileSize.getText().toString().length() > 0 && inputInternetSpeed.getText().toString().length() > 0){
                    Integer fileSize = Integer.parseInt(inputFileSize.getText().toString());
                    Integer internetSpeed = Integer.parseInt(inputInternetSpeed.getText().toString());
                    Double result = (double)(fileSize * 1024 * 1024 * 8)/(1000 *1000 * internetSpeed);
                    result =  BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    String textResult = result + " Seconds";
                    resultText.setText(textResult);
                }
            }
        }
    };
}
