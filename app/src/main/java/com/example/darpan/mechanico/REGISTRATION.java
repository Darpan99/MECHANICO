package com.example.darpan.mechanico;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class REGISTRATION extends AppCompatActivity  {
    public EditText name, number, emailId, passwd;
    Button btnSignUp;
    TextView signIn, partner;
    FirebaseAuth firebaseAuth;
    SignInButton googlebtn;
    public static String id;
    public static FirebaseDatabase database;
    public static DatabaseReference ref;
    FirebaseAuth.AuthStateListener firebaseAuthListner;
    FirebaseUser firebaseUser;
    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN=2;
  public static  Realtime_database_users rtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();
        firebaseAuth = FirebaseAuth.getInstance();
        Realtime_database_users rtos= new Realtime_database_users();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Realtime_database_users");
        emailId = findViewById(R.id.editText4);
        passwd = findViewById(R.id.editText5);
        name = findViewById(R.id.editText);
        number= findViewById(R.id.editText3);
        googlebtn = findViewById(R.id.button2);
        btnSignUp = findViewById(R.id.button);
        partner= findViewById(R.id.TVpartner);
        signIn = findViewById(R.id.TVSignIn);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailID = emailId.getText().toString();
                String paswd = passwd.getText().toString();
                final String uname=name.getText().toString();
                final String num=number.getText().toString();

                if (emailID.isEmpty()) {
                    emailId.setError("Provide your Email first!");
                    emailId.requestFocus();
                } else if (paswd.isEmpty()) {
                    passwd.setError("Set your password");
                    passwd.requestFocus();
                } else if (emailID.isEmpty() && paswd.isEmpty()) {
                    Toast.makeText(REGISTRATION.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if(!isValidMobile(number.getText().toString()))
                {
                    Toast.makeText(REGISTRATION.this,"Invalid number",Toast.LENGTH_LONG).show();
                }
                else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(REGISTRATION.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(REGISTRATION.this.getApplicationContext(),
                                        "Registration unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                                id=firebaseUser.getUid();
                              Realtime_database_users rtos=new Realtime_database_users(uname,num,emailID);
                                 ref.child(id).child("name").setValue(name.getText().toString());
                                ref.child(id).child("number").setValue(number.getText().toString());
                                ref.child(id).child("email_id").setValue(emailId.getText().toString());
                                Toast.makeText(REGISTRATION.this,"Data inserted",Toast.LENGTH_LONG).show();

                                Intent i = new Intent("com.example.darpan.mechanico.page3");
                                startActivity(i);
                            }
                        }
                    });
                }

                else {
                    Toast.makeText(REGISTRATION.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.example.darpan.mechanico.login3");
                startActivity(i);
            }
        });

        firebaseAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null) {
                    startActivity(new Intent(REGISTRATION.this,PAGE3.class));
                }
            }
        };
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("339393537405-ju75mn5th26t2c4ef9h2cfneinsbnleh.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        partner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(REGISTRATION.this,partnerlogin.class));
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("TAG", "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            startActivity(new Intent(REGISTRATION.this,PAGE3.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });


    }
    private boolean isValidMobile(String number)
    {
        return Patterns.PHONE.matcher(number).matches();
    }


}


