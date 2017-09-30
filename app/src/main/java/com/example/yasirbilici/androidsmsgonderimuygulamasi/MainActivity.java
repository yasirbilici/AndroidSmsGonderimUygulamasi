package com.example.yasirbilici.androidsmsgonderimuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ben hata durumunda uygulamanın çökmesini engellemek amacıyla
                kodlarımı try catch içersine aldım siz isterseniz try catch
                içerisisne almadanda çalıştırabilirsiniz.
                */
                try {
                    //Edittext alanlarını tanımlıyoruz
                    EditText Phone = (EditText)findViewById(R.id.Ephone);
                    EditText Message = (EditText)findViewById(R.id.message);
                    //Edittext alanına girilen verileri degişkenlere aktardık
                    String phonenumber = Phone.getText().toString();
                    String message = Message.getText().toString();
                    //sms gonderimi için smsmanager methodunu cagırıyoruz
                    SmsManager smsManager = SmsManager.getDefault();
                    //sms goderim için varsayılan alanları çekerek sms gonderiyoruz
                    smsManager.sendTextMessage(phonenumber, null, message, null, null);
                    //telefon numarası ve mesaj alanlaı temizlendi ve gönderimin başarılı oldugu ekrana bastırıldı
                    Phone.setText("");
                    Message.setText("");
                    Toast.makeText(MainActivity.this, "Sms Gönderimi Başarılı", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Sms Gönderimi Başarısız oldu", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
