package com.example.homeservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ConfirmServiceProvider extends AppCompatActivity {

        String SPname,SPmobile,SPaddress;
    String Bname,Bnumber,Baddress;
    TextView t1;
        EditText bookiename,bookienumber,bookieaddress;
        String Bmessage="",SPmessage="";
        Button book;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        t1=findViewById(R.id.head);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_service_provider);
        bookiename=findViewById(R.id.bookiename);
        bookienumber=findViewById(R.id.bookienumber);
        bookieaddress=findViewById(R.id.bookieaddress);
        book=findViewById(R.id.booking);
        Bundle bundle = getIntent().getExtras();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CUSTOMERS");
        DatabaseReference Ref1= database.getReference("SERVICE_PROVIDERS");
        SPname=bundle.getString("SPname");
        SPaddress=bundle.getString("SPaddress");
        SPmobile=bundle.getString("SPmobile");
        book.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                 Bname=""+bookiename.getText().toString();
                 Bnumber=""+bookienumber.getText().toString();
                 Baddress=""+bookieaddress.getText().toString();
                 SPmessage="Hello Mr. Service Provider\nNew Booking For You\nBookie Details:\nName : "+Bname+"\nNumber : "+Bnumber+"\nAddress : "+Baddress;
                Bmessage="Hello Mr. Bookie\nYour Booking is Confirmed\nService Provider Details:\nName : "+SPname+"\nNumber : "+SPmobile+"\nAddress : "+SPaddress;

//                db=FirebaseDatabase.getInstance().getReference().child("data");

                if(Bname.length()!=0&&Bnumber.length()!=0&&Baddress.length()!=0)
                {
                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(""+SPmobile, null, SPmessage, null,null);
                    sms.sendTextMessage(""+Bnumber, null, Bmessage, null,null);

                    insertion_data();



                    Intent i=new Intent(ConfirmServiceProvider.this, pay1.class);
                    Bundle b=new Bundle();
                    b.putString("SPname",SPname);
                    b.putString("SPmobile",SPmobile);
                    b.putString("SPaddress",SPaddress);
                    b.putString("Bnumber",Bnumber);
                    b.putString("Baddress",Baddress);
                    b.putString("Bname",Bname);
                    i.putExtras(b);
                    startActivity(i);
                    Toast.makeText(ConfirmServiceProvider.this, "CONFIRMED & RECORDED", Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(ConfirmServiceProvider.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
            }
            private void insertion_data(){
                String name=bookiename.getText().toString();
                String number=bookienumber.getText().toString();
                String address=bookieaddress.getText().toString();
                HashMap<String, String> userData = new HashMap<>();
                userData.put("Booked_SP : ",SPmobile);
                userData.put("BookieName : ",name);
                userData.put("BookieNum : ",number);
                userData.put("Bookieaddress : ",address);
                HashMap<String, String> admindata = new HashMap<>();
                admindata.put("Booked by : ",Bnumber);
                admindata.put("SPname : ",SPname);
                admindata.put("SPnumber : ",SPmobile);
                admindata.put("SPaddress : ",SPaddress);

                myRef.child(number).setValue(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ConfirmServiceProvider.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ConfirmServiceProvider.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                    }
                });

                Ref1.child(SPmobile).setValue(admindata).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ConfirmServiceProvider.this, "", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ConfirmServiceProvider.this, "Data insertion failed", Toast.LENGTH_SHORT).show();
                    }
                });
//              CUSTOMERS dl=new CUSTOMERS(name,number,address);
//               db.push().setValue(dl);





            }
        });

    }
}