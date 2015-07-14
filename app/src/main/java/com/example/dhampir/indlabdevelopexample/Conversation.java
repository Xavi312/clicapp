package com.example.dhampir.indlabdevelopexample;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Date;

import models_and_adaptors.model_and_adaptors.Adaptor;
import models_and_adaptors.model_and_adaptors.ListViewItem;


public class Conversation extends AppCompatActivity {

    Adaptor<ListViewItem> conversationAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv_activity);
        Button set_comment_btn = (Button)findViewById(R.id.submit_button);


        conversationAdaptor = new Adaptor(this);
        final ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(conversationAdaptor);

        final RadioButton sender_radio_btn = (RadioButton)findViewById(R.id.senderRadioB);

        set_comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AutoCompleteTextView tv = (AutoCompleteTextView) findViewById(R.id.autocomplete);
                Context c = v.getContext();
                Date now = new Date();
                conversationAdaptor.insert(new ListViewItem(now.toString(), tv.getText().toString(),sender_radio_btn.isChecked()), 0);
            }
        });

        final AutoCompleteTextView new_comment = (AutoCompleteTextView)findViewById(R.id.autocomplete);
        new_comment.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               String txt = new_comment.getText().toString();
                                               if (txt.compareTo("Write a comment here") == 0){
                                                   new_comment.setText("");
                                               }
                                           }
                                       }

        );


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conversation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
