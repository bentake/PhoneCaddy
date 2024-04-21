package com.example.phonecaddy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adapter for managing and binding messages within a RecyclerView. This class handles
 * the display of user-sent messages and bot responses in a chat interface.
 *
 * The adapter uses different layouts for user messages and bot messages to visually
 * distinguish between the two types of messages.
 */
public class MessageAdapter extends RecyclerView.Adapter <MessageAdapter.MessageViewHolder> {
    private static final int VIEW_TYPE_USER = 0; // View type for user messages
    private static final int VIEW_TYPE_BOT = 1; // View type for bot messages
    private List <Message> mMessages; // List of messages to be displayed in the RecyclerView

    /**
     * Constructs a new MessageAdapter.
     *
     * @param messages The list of Message objects that the adapter will manage and display.
     */
    public MessageAdapter(List <Message> messages) {
        mMessages = messages;
    }

    /**
     * Creates new views (invoked by the layout manager). Depending on the viewType,
     * this inflates different layouts for user messages and bot messages.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return A new MessageViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == VIEW_TYPE_USER) {
            view = inflater.inflate(R.layout.item_message_user, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_message_bot, parent, false);
        }
        return new MessageViewHolder(view);
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager).
     *
     * @param holder The MessageViewHolder which should be updated to represent the
     *               contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mMessages.get(position);
        holder.bind(message);
    }

    /**
     * Returns the size of the dataset (invoked by the layout manager).
     *
     * @return The number of messages in the dataset.
     */
    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    /**
     * Returns the view type of the item at the given position for the purposes of view recycling.
     *
     * @param position The position of the item within the adapter's data set.
     * @return VIEW_TYPE_USER if the message was sent by the user, VIEW_TYPE_BOT otherwise.
     */
    @Override
    public int getItemViewType(int position) {
        Message message = mMessages.get(position);
        return message.isSentByUser() ? VIEW_TYPE_USER : VIEW_TYPE_BOT;
    }

    /**
     * ViewHolder for message items in the list. This class holds the TextView that will display
     * the message text.
     */
    static class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        /**
         * Constructs a new MessageViewHolder.
         *
         * @param itemView The View that you may inflate in the corresponding MessageAdapter.
         */
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_message_user);
        }

        /**
         * Binds a message to this view holder. Sets the text of the TextView to the message's text.
         * Updates the TextView reference based on whether the message is sent by the user or bot.
         *
         * @param message The message object to bind in this ViewHolder.
         */
        public void bind(Message message) {
            if (message.isSentByUser()) {
                mTextView = itemView.findViewById(R.id.text_message_user);
                mTextView.setText(message.getText());
            } else {
                mTextView = itemView.findViewById(R.id.text_message_bot);
                mTextView.setText(message.getText());
            }
        }
    }
}
