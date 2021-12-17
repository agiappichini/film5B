package itts.voltapg.film5b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Film[] = {"Spiderman", "Titanic", "Balle spaziali"};
    ListView lvFilm;
    Button btnEsci;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFilm = (ListView)findViewById(R.id.lvFilm);
        btnEsci = (Button)findViewById(R.id.btnEsci);

        ArrayAdapter<String> aaFilm = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,Film);
        lvFilm.setAdapter(aaFilm);

        btnEsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Stai per uscire",
                        Toast.LENGTH_LONG).show();
            }
        });

        lvFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String titolo = (String)lvFilm.getItemAtPosition(i);
                //Toast.makeText(getApplicationContext(), titolo,
                        //Toast.LENGTH_LONG).show();
                Log.d("elemento_selezione", "Hai cliccato sul "
                        + i + " elemento");

                Intent secAct = new Intent(getApplicationContext(),
                        dettaglioFilm.class);
                secAct.putExtra("titolo", titolo);
                startActivity(secAct);


            }
        });


    }
}