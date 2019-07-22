package app.android.pkk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionActivity extends AppCompatActivity {

    Button btn_siswa,btn_guru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btn_siswa = (Button) findViewById(R.id.btn_siswa);
        btn_guru = (Button) findViewById(R.id.btn_guru);

        btn_siswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OptionActivity.this , LoginActivity.class));
            }
        });

        btn_guru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OptionActivity.this , LoginActivity.class));
            }
        });

    }
}
