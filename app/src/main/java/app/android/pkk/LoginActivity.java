package app.android.pkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername , ePassword;
    Button btnLogin;
    ProgressBar loading;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eUsername = (EditText) findViewById(R.id.txt_username);
        ePassword = (EditText) findViewById(R.id.txt_password);
        btnLogin  = (Button) findViewById(R.id.btn_login);
        loading = (ProgressBar) findViewById(R.id.loading);
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = eUsername.getText().toString().trim()+"@gmail.com";
                if (username.length()<=20){
                    loginAccountSiswa();
                }else if (username.length()>=21){
                    loginAccountGuru();
                }

            }
        });
    }

    private void loginAccountGuru() {
        String username = eUsername.getText().toString().trim()+"@gmail.com";
        String password = ePassword.getText().toString().trim();

        if (username.isEmpty()){
            eUsername.setError("Username Tidak Boleh Kosong");
            eUsername.requestFocus();
            return;
        }

        if (password.isEmpty()){
            ePassword.setError("Password Tidak Boleh Kosong");
            ePassword.requestFocus();
            return;
        }
        loading.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(username , password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            loading.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void loginAccountSiswa() {
        String username = eUsername.getText().toString().trim()+"@gmail.com";
        String password = ePassword.getText().toString().trim();

        if (username.isEmpty()){
            eUsername.setError("Username Tidak Boleh Kosong");
            eUsername.requestFocus();
            return;
        }

        if (password.isEmpty()){
            ePassword.setError("Password Tidak Boleh Kosong");
            ePassword.requestFocus();
            return;
        }
        loading.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(username , password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            loading.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

}
