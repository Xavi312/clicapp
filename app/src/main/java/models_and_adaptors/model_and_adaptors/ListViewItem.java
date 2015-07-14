package models_and_adaptors.model_and_adaptors;

/**
 * Created by Dhampir on 7/13/2015.
 */
public class ListViewItem {
    private String datetime;
    private String comment;
    private Boolean sender;

    public ListViewItem(String dattime, String commentBody, Boolean sendr){
        datetime = dattime;
        comment = commentBody;
        sender = sendr;
    }

    public String getDatetime(){
        return datetime;
    }

    public String getComment(){
        return comment;
    }

    public Boolean getSender(){
        return sender;
    }
}
