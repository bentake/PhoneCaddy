package com.example.phonecaddy;

/**
 * Represents a single message in the chat interface. This class holds the data
 * for one message, including the message text and an indicator of whether the message
 * was sent by the user or received from another source.
 * <p>
 * The Message class is used throughout the application to manage the messages
 * displayed in the chat UI, facilitating the differentiation between user-sent and
 * received messages.
 */
public class Message {
    private String mText; // The text content of the message
    private boolean mIsSentByUser; // Flag indicating whether the message was sent by the user

    /**
     * Constructs a new Message object with the specified text and sender indicator.
     *
     * @param text The text content of the message. This should not be null.
     * @param isSentByUser True if the message is sent by the user, false otherwise.
     */
    public Message(String text, boolean isSentByUser) {
        mText = text;
        mIsSentByUser = isSentByUser;
    }

    /**
     * Returns the text of the message.
     *
     * @return The text content of the message.
     */
    public String getText() {
        return mText;
    }

    /**
     * Indicates whether this message was sent by the user.
     *
     * @return True if the message was sent by the user, false otherwise.
     */
    public boolean isSentByUser() {
        return mIsSentByUser;
    }
}
