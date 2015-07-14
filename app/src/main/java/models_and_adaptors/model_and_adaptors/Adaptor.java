package models_and_adaptors.model_and_adaptors;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dhampir.indlabdevelopexample.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhampir on 7/13/2015.
 */
public class Adaptor<E> extends ArrayAdapter<E> {
    public Activity context;
    String comment_direction;

    public Adaptor(Activity context) {
        super(context, R.layout.conversation_sender_item);
        this.comment_direction = "Sender";
        this.context = context;
    }


    public void setComment_direction(String direction){
        if (direction == "Sender" ||direction == "Reciever"){
            this.comment_direction = direction;
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ListViewItem data = (ListViewItem)this.getItem(position);

        LayoutInflater inflater = context.getLayoutInflater();
        View item;

        if (data.getSender()){
            item = inflater.inflate(R.layout.conversation_sender_item, null);
        }
        else {
            item = inflater.inflate(R.layout.conversation_reciever_layout, null);
        }

        TextView date = (TextView)item.findViewById(R.id.date_time_text);
        date.setText(data.getDatetime());

        TextView comment = (TextView)item.findViewById(R.id.comment_body);
        comment.setText(data.getComment());
        return item;

    }
}

