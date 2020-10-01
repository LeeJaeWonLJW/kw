package optatio.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textViewExpression;
    private TextView textViewResult;
    private EditText editTextResult;

    private int num1 = 0;
    private int num2 = 0;
    private boolean plus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewExpression = findViewById(R.id.textViewExpression);
        textViewResult = findViewById(R.id.textViewResult);
        editTextResult = findViewById(R.id.editTextResult);

        setNewExpression();
    }

    private void setNewExpression() {
        num1 = (int) (Math.random() * (99 - 1 + 1) + 1);
        num2 = (int) (Math.random() * (99 - 1 + 1) + 1);
        plus = new Random().nextBoolean();



        textViewExpression.setText(String.format ("%d%s%d", num1, (plus ? '+' : '-'), num2));
    }

    private void solveExpression() {
        try {
            int data = Integer.parseInt(editTextResult.getText().toString());

            int answer;
            if (plus)   answer = num1 + num2;
            else        answer = num1 - num2;

            if (data == answer) {
                textViewResult.setText("맞았습니다.");
            } else {
                textViewResult.setText("틀렸습니다.");
            }
        } catch (NumberFormatException error) {
            Toast.makeText(this.getApplicationContext(), "답을 입력하세요.", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickSolve(View view) {
        solveExpression();
    }

    public void onClickNewExpression(View view) {
        setNewExpression();
    }

    public void onClickExit(View view) {
        finish();
    }
}
