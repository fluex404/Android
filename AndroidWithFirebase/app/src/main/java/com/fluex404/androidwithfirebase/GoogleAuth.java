package com.fluex404.androidwithfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class GoogleAuth extends AppCompatActivity
implements GoogleApiClient.OnConnectionFailedListener{

    //Deklerasi Variable
    private ProgressDialog progressDialog; //membuat proeses ketika login
    private SignInButton googleButton; //sebuah tombol khusus untuk login
    private GoogleSignInOptions GSO; //untuk configure google signin
    private GoogleApiClient googleApiClient; //membuat API untuk client
    private FirebaseAuth firebaseAuth; //untuk authentication
    private FirebaseAuth.AuthStateListener authStateListener; //untuk menangani Kejadian saat authentication
    private final int RC_SIGN_IN = 9001; // kode unik untuk sign in
    private final String TAG = "SignInActivity"; // untuk Log debugging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_auth);

        googleButton = findViewById(R.id.login_google);
        FirebaseConnect();
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });
    }

    //kumpulan konfigurasi untuk membangun dengan firebase
    private void FirebaseConnect(){
        final FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this); // menghubungkan dengan firebase Analytics
        firebaseAuth= FirebaseAuth.getInstance(); //menghubungkan dengan firebase authentication
        progressDialog = new ProgressDialog(this); // sebuah progressdialog untuk menandakan program sedang dieksekusi

        //Authentication Listener
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    /*
                    * Jika User sebelumnya telah masuk/login dan blum keluar/logout, secara otomatis
                    * Saat aplikasi dibuka kembali, Activity ini langsung dialihkan pada Activity MainMenu
                     */
                    if(firebaseAuth.getCurrentUser() != null) {
                        startActivity(new Intent(GoogleAuth.this, MainMenu.class));
                        finish();
                    }
            }
        };

        //konfigurasi googlesign in, dengan cara bagaimana user akan masuk
        GSO = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                
    }

    //konfigurasi untuk masuk ke akun google
    private void SignIn(){
        //statement
    }

    // untuk menangani kejadian saat pengguna berhasil login
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

    }

    // menangani kejadian saat gagal koneksi
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
