
        package com.example.homeservices;

        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.HashMap;

public class pay2 extends AppCompatActivity {
    Button dn;
    EditText ed;
    public static final String ID="ID";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        String SPname=bundle.getString("SPname");
        String SPaddress=bundle.getString("SPaddress");
        String SPmobile=bundle.getString("SPmobile");
        String Bname=bundle.getString("Bname");
        String Bnumber=bundle.getString("Bnumber");
        String Baddress=bundle.getString("Baddress");
        String amount=bundle.getString("amount");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);
        dn=findViewById(R.id.done);
        ed=findViewById(R.id.tran);

        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(ed.getText().toString()))
                {
                    Toast.makeText(pay2.this, "Please enter Transaction id", Toast.LENGTH_SHORT).show();
                }
                else if(ed.getText().toString().length()<10)
                {
                    Toast.makeText(pay2.this, "Enter valid transaction id", Toast.LENGTH_SHORT).show();
                }
                else {

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myr = database.getReference("Admin");
                    HashMap<String, Object> userData = new HashMap<>();
                    userData.put("Transaction id",ed.getText().toString() );
                    myr.updateChildren(userData);

                    Intent i=new Intent(pay2.this,payment1.class);
                    i.putExtra("SPname",SPname);
                    i.putExtra("SPmobile",SPmobile);
                    i.putExtra("SPaddress",SPaddress);
                    i.putExtra("Bname",Bname);
                    i.putExtra("Bnumber",Bnumber);
                    i.putExtra("Baddress",Baddress);
                    i.putExtra("amount",amount);
                    startActivity(i);
                }
            }
        });

    }
}