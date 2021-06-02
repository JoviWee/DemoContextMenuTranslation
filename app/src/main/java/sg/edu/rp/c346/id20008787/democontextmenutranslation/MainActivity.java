package sg.edu.rp.c346.id20008787.democontextmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewTranslatedText;
    TextView textViewTraslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(textViewTranslatedText);
        textViewTraslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(textViewTraslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == textViewTranslatedText){
            wordClicked = "hello";
        } else if(v == textViewTraslatedText2) {
            wordClicked = "bye";
        }

        menu.add(0,0,0,"English");
        menu.add(0,1,1, "Italian");



    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == 0){
            Toast.makeText(MainActivity.this, "English Selected", Toast.LENGTH_LONG).show();
            if(wordClicked.equalsIgnoreCase("hello")){
                textViewTranslatedText.setText("hello");
            } else if(wordClicked.equalsIgnoreCase("bye")){
                textViewTranslatedText.setText("bye");
            }
            return true;
    }
        else if(item.getItemId() == 1){
            Toast.makeText(MainActivity.this, "Italian Selected", Toast.LENGTH_SHORT).show();
            if(wordClicked.equalsIgnoreCase("hello")){
                textViewTranslatedText.setText("hello");
            } else if(wordClicked.equalsIgnoreCase("ciao")){
                textViewTranslatedText.setText("addio");
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }
}