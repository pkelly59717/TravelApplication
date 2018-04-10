package com.example.pkelly.travelapplication.adapters;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import com.example.pkelly.travelapplication.model.ChatMessage;
        import com.example.pkelly.travelapplication.R;

        import java.util.ArrayList;
        import java.util.List;

        /*
Created by Paul Kelly
Matriculation Number:40282331
SOC10101 Honours Project
2017-2018
*/

public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    //text views
    private TextView chatText;

    //lists
    private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();

    //variables
    private Context context;

    //method used to add message to chat list
    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        super.add(object);
    }

    //chat array adapter used to set context
    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    //returns the messages store in the chat list
    public int getCount() {
        return this.chatMessageList.size();
    }

    //get method for chat message
    public ChatMessage getItem(int index) {
        return this.chatMessageList.get(index);
    }

    //sets the view for the chat screen
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.left) {
            row = inflater.inflate(R.layout.right, parent, false);
        }else{
            row = inflater.inflate(R.layout.left, parent, false);
        }
        chatText = (TextView) row.findViewById(R.id.msgr);
        chatText.setText(chatMessageObj.message);
        return row;
    }
}