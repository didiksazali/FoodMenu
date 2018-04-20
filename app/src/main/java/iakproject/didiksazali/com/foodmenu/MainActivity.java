package iakproject.didiksazali.com.foodmenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtJlhMakanan, edtJlhMinuman;
    Spinner spinnerMakanan, spinnerMinuman;
    RadioButton radioYa, radioTidak;
    Button btnKirimPesanan;
    TextView txtOrderMakanan, txtOrderJumlahMakanan, txtOrderMinuman, txtOrderJumlahMinuman, txtOrderDiscount, txtOrderTotal;

    String[] itemsMakanan = { "== Pilih Makanan ==", "Sate Kambing (Rp. 25.000,-)", "Gulai Baung (Rp. 45.000,-)", "Ayam Bakar (Rp. 35.000,-)" };
    String[] itemsMinuman = { "== Pilih Minuman ==", "Laksamana Mengamuk (Rp. 10.000,-)", "Jus Alpukat (Rp. 12.000,-)", "Kopi Gayo (Rp. 15.000,-)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsMakanan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMakanan = (Spinner) findViewById(R.id.spinnerMakanan);
        spinnerMakanan.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, itemsMinuman);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMinuman = (Spinner) findViewById(R.id.spinnerMinuman);
        spinnerMinuman.setAdapter(adapter2);

        edtJlhMakanan = (EditText)findViewById(R.id.edtJlhMakanan);
        edtJlhMinuman = (EditText)findViewById(R.id.edtJlhMinuman);

        radioYa = (RadioButton)findViewById(R.id.radioYa);
        radioTidak = (RadioButton)findViewById(R.id.radioTidak);

        btnKirimPesanan = (Button)findViewById(R.id.btnKirimPesanan);
        btnKirimPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerMakanan.getSelectedItem().toString().equals("== Pilih Makanan ==") || spinnerMinuman.getSelectedItem().toString().equals("== Pilih Minuman ==") || edtJlhMakanan.getText().toString().equals("") || edtJlhMinuman.getText().toString().equals("")){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Warning!");
                    alertDialog.setMessage("Mohon Lengkapi Pesanan Anda.");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                        }
                    });

                    alertDialog.show();

                } else {
                    AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);
                    alertDialog2.setTitle("Information!");
                    alertDialog2.setMessage("Apakah Anda Yakin Dengan Pesanan Anda?");
                    alertDialog2.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {

                            txtOrderMakanan = (TextView)findViewById(R.id.txtOrderMakanan);
                            txtOrderJumlahMakanan = (TextView)findViewById(R.id.txtOrderJumlahMakanan);
                            txtOrderMinuman = (TextView)findViewById(R.id.txtOrderMinuman);
                            txtOrderJumlahMinuman = (TextView)findViewById(R.id.txtOrderJumlahMinuman);
                            txtOrderDiscount = (TextView)findViewById(R.id.txtOrderDiscount);
                            txtOrderTotal = (TextView)findViewById(R.id.txtOrderTotal);

                            // TODO Auto-generated method stub
//                            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
//                            startActivity(intent);
                            String pilihMakanan = (String) spinnerMakanan.getSelectedItem();
                            txtOrderMakanan.setText(pilihMakanan);

                            int jlhMakanan = Integer.parseInt(edtJlhMakanan.getText().toString());
                            txtOrderJumlahMakanan.setText(jlhMakanan + "");

                            String pilihMinuman = (String) spinnerMinuman.getSelectedItem();
                            txtOrderMinuman.setText(pilihMinuman);

                            int jlhMinuman = Integer.parseInt(edtJlhMinuman.getText().toString());
                            txtOrderJumlahMinuman.setText(jlhMinuman + "");

                            if (radioYa.isChecked()) {
                                txtOrderDiscount.setText("10%");
                                if (spinnerMakanan.getSelectedItem().toString().equals("Sate Kambing (Rp. 25.000,-)")){
                                    int hargaMakananPesan = 25000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }

                                }
                                else if (txtOrderMakanan.getText().toString().equals("Gulai Baung (Rp. 45.000,-)")){
                                    int hargaMakananPesan = 45000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                }
                                else if (txtOrderMakanan.getText().toString().equals("Ayam Bakar (Rp. 35.000,-)")){
                                    int hargaMakananPesan = 35000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        int diskon = totalPesanan - (totalPesanan * 10 /100);
                                        txtOrderTotal.setText("Rp. " + diskon + ",-");
                                    }
                                }
                            }
                            if (radioTidak.isChecked()) {
                                txtOrderDiscount.setText("0%");
                                if (spinnerMakanan.getSelectedItem().toString().equals("Sate Kambing (Rp. 25.000,-)")){
                                    int hargaMakananPesan = 25000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }

                                }
                                else if (txtOrderMakanan.getText().toString().equals("Gulai Baung (Rp. 45.000,-)")){
                                    int hargaMakananPesan = 45000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                }
                                else if (txtOrderMakanan.getText().toString().equals("Ayam Bakar (Rp. 35.000,-)")){
                                    int hargaMakananPesan = 35000;
                                    int totalMakanan = hargaMakananPesan * jlhMakanan;
                                    if (spinnerMinuman.getSelectedItem().toString().equals("Laksamana Mengamuk (Rp. 10.000,-)")){
                                        int hargaMinumanPesan = 10000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Jus Alpukat (Rp. 12.000,-)")){
                                        int hargaMinumanPesan = 12000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                    else if (spinnerMinuman.getSelectedItem().toString().equals("Kopi Gayo (Rp. 15.000,-)")){
                                        int hargaMinumanPesan = 15000;
                                        int totalMinuman = hargaMinumanPesan * jlhMinuman;
                                        int totalPesanan = totalMakanan + totalMinuman;
                                        txtOrderTotal.setText("Rp. " + totalPesanan + ",-");
                                    }
                                }
                            }




                        }
                    });

                    alertDialog2.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            // TODO Auto-generated method stub
                        }
                    });

                    alertDialog2.show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog(){
        AlertDialog.Builder quitDialog
                = new AlertDialog.Builder(MainActivity.this);
        quitDialog.setTitle("Yakin ingin keluar?");

        quitDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }});

        quitDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }});

        quitDialog.show();
    }

}
