package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    //private String[] situated = {"Switzerland, Italy","France, Italy","USA"};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData;
    private ArrayList<Mountain> waqarsBerg=new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = new ArrayList<>(Arrays.asList(mountainNames));
        waqarsBerg.add(new Mountain("Matterhorn","Alps",4478));
        waqarsBerg.add(new Mountain("Mont Blanc", "Alps", 4808));
        waqarsBerg.add(new Mountain("Denali", "Alaska", 6190));
        Log.d("WAQAR",waqarsBerg.get(0).getName());
        /*
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
        //String waq = new String("Berg");
        //String[] stirngArray = new String[] { "berg" };
        //Toast.makeText(getApplicationContext(), waq, Toast.LENGTH_SHORT).show();

       //String[] stirngArray = new String[] { "berg" };
        String[] waq = new String[] {"All","is","well!"};
        Toast.makeText(getApplicationContext(), Arrays.toString(waq), Toast.LENGTH_SHORT).show();
        Log.d("EMIL", Arrays.toString(waq));
        Button b =(Button) findViewById(R.id.toasterButton);
        /*
        b.setOnClickListner(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myEdtBox =(EditText) findViewById(R.id.toasterText);
                Toast.makeText(getApplicationContext(), myEditBox.getText(), Toast.LENGTH_SHORT).show();
            }

            };
*/
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText myEdtBox =(EditText) findViewById(R.id.editText);
                Toast.makeText(getApplicationContext(), myEdtBox.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        // String mystring = "[" + waq[0] + ", " + waq[1] + ", " + waq[2] + "]";
        //Log.d("EMIL", mystring);

        /*
        FloatingActionButton fab =(FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListner ((view) {
            Snackbar.make(view, "Hellooooooo !!!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });
        */

        //Log.d("Potatis", waq);

        // The onCreate method is run when the app is created.
        // Before you can implement this you need to create the layout xml files that
        // will hold/show your data created here. You need three create things:
        // * my_listview - the ID to the actual layout element that is our ListView.
        //                 This my_listview element is created in the activity_main.xml file
        // * list_item_textview - This is a new layout xml file that holds the layout for an
        //                        individual item in the ListView we are creating
        // * my_item_textview - This is the ID to the actual TextView that will contain the text for
        //                      an individual item in the ListView we are creating.
        // Here you should enter your code that fills the ListView
        // 1. Create an array
        // 2. Create a List object with your array from step 1 as in-data
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.list_item_textview,listData);
        ArrayAdapter<Mountain> adapter=new ArrayAdapter<Mountain>(this,R.layout.list_item_textview,R.id.list_item_textview,waqarsBerg);
        // 3. Create an ArrayAdapter object that connects
        ListView my_listview=(ListView) findViewById(R.id.my_listview);
        //    * list_item_textview
        //    * my_item_textview
        //    * List object created in step 2
        // 4. Find the ListView layout element "my_listview" and create an object instance
        my_listview.setAdapter(adapter);
        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
           /* public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //listData.add(new String("Tomten!"));
                Toast.makeText(getApplicationContext(),"Name:  "+mountainNames[i] + "\n" + "Höjd:  " + mountainHeights[i] + "\n" + "Location:  " + mountainLocations[i] /*+ "\n" + "Land:  " + situated[i], Toast.LENGTH_SHORT).show();
            }*/
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //listData.add(new String("Tomten!"));
                Toast.makeText(getApplicationContext(),waqarsBerg.get(position).info(), Toast.LENGTH_SHORT).show();
            }
        });


        //my_listview.setAdapter(ListAdapter adapter);
        // 5. Connect the ArrayAdapter from step 3 with ListView object created in step 4
        // 6. Style the ListView items according to Material Design
        //    See: https://material.io/guidelines/components/lists.html#lists-specs
        //    Look for "singel line specs" for "text only" lists and modify the list_item_textview
        //    accordingly
    }
}
