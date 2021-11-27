package jackey.mca.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class appleactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appleactivity);

        String name = getIntent().getStringExtra("name").toLowerCase();
        int pos = getIntent().getIntExtra("pos",0);

        ImageView iv = findViewById(R.id.imageView);
        int iid = getResources().getIdentifier(name,"drawable",getPackageName());
        iv.setImageResource(iid);

        TextView tv = findViewById(R.id.textView);
        String[] mobile = getResources().getStringArray(R.array.apple);
        tv.setText(mobile[pos]);

    }
}