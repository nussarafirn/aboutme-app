package edu.tacoma.uw.baifirn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button textBtn;
    private Button imagBtn;
    private Button webBtn;
    private Button toastBtn;
    private Button diaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText();
        displayImg();
        displayWeb();
        displayToast();
        displayDialog();
    }

    private void displayText() {
        textBtn = findViewById(R.id.txtBtn);

        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateActivity(DisplayTextActivity.class);
            }
        });
    }

    private void displayImg() {
        imagBtn = findViewById(R.id.imgBtn);

        imagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateActivity(DisplayImageActivity.class);
            }
        });
    }

    private void displayWeb() {
        webBtn = findViewById(R.id.webBtn);

        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://developer.android.com/index.html"));
                startActivity(intent);
            }
        });
    }

    private void displayToast() {
        toastBtn = findViewById(R.id.toaBtn);

        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Pikka Boo!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(MainActivity.this, text, duration);
                toast.show();
            }
        });
    }

    private void displayDialog() {
        diaBtn = findViewById(R.id.diaBtn);

        diaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alrt = new AlertDialog.Builder(MainActivity.this);
                alrt.setMessage("Congrats! You are finished!");
                alrt.setCancelable(true);

                AlertDialog dialog = alrt.create();
                dialog.show();
            }
        });
    }

    private void activateActivity(Class ActivityClass) {
        Intent intent = new Intent(this, ActivityClass);
        startActivity(intent);
    }
}

