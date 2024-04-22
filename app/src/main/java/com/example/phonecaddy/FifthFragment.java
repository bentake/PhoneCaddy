package com.example.phonecaddy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the fifth fragment, which is responsible for displaying a chat interface
 * where users can interact with the OpenAI GPT model via a RecyclerView.
 * This class handles initializing the UI components,capturing user input, sending API requests,
 * and processing responses to display chat messages.
 */
public class FifthFragment extends Fragment {
    private RecyclerView mRecyclerView; // RecyclerView for displaying messages
    private MessageAdapter mAdapter; // Adapter for managing and displaying messages in RecyclerView
    private EditText mEditText; // EditText for user to enter input
    private Button mButton; // Send Button to trigger API requests
    private Button bButton; // Back Button to go back to the home page
    private String apiUrl = "https://api.openai.com/v1/chat/completions"; // URL for the OpenAI API
    private String accessToken = "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"; // Access token for API authentication
    private List <Message> mMessages; // List to store and manage messages displayed in the RecyclerView

    /**
     * Inflates the layout for this fragment, initializes UI components, and sets up the RecyclerView.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return Returns the View for the fragment's UI, or null.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mEditText = view.findViewById(R.id.edit_text);
        mButton = view.findViewById(R.id.button); // Send button
        bButton = view.findViewById(R.id.button_back); // Back button
        mMessages = new ArrayList<>();
        mAdapter = new MessageAdapter(mMessages);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        // Set up the send button to trigger API requests
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAPI();
            }
        });

        // Set up the back button to go back to the home page
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });

        return view;
    }

    /**
     * Navigate back to the first fragment i.e. the home page when the user triggers the function call
     */
    private void navigateToHome() {
        if (getActivity() != null) {
            NavHostFragment.findNavController(FifthFragment.this)
                    .navigate(R.id.action_FifthFragment_to_FirstFragment);
        }
    }

    /**
     * Calls the OpenAI API using Volley to get chat completions based on the user's input.
     * It constructs a JSON request body and sends it using a POST request. Responses are handled
     * by updating the RecyclerView with the new messages.
     */
    private void callAPI() {
        String text = mEditText.getText().toString();
        mMessages.add(new Message(text, true));
        mAdapter.notifyItemInserted(mMessages.size() - 1);
        mEditText.getText().clear();

        JSONObject requestBody = new JSONObject();
        try {
            JSONArray messages = new JSONArray();
            JSONObject message = new JSONObject();
            message.put("role", "user");
            message.put("content", text);
            messages.put(message);
            requestBody.put("messages", messages);
            requestBody.put("model", "gpt-4-turbo"); // latest GPT model available to public
            requestBody.put("max_tokens", 100); // limit length of response to 100 tokens
            requestBody.put("temperature", 1); // modifies model behavior
        } catch (JSONException e) {
            Log.e("JSON Error", "Failed to create JSON: " + e.getMessage());
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, apiUrl, requestBody, new Response.Listener <JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray choicesArray = response.getJSONArray("choices");
                    JSONObject choiceObject = choicesArray.getJSONObject(0);
                    String textResponse = choiceObject.getString("message");
                    mMessages.add(new Message(textResponse.trim(), false));
                    mAdapter.notifyItemInserted(mMessages.size() - 1);
                } catch (JSONException e) {
                    Log.e("JSON Error", "Error parsing JSON: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API Error", error.toString());
            }
        }) {
            @Override
            public Map <String, String> getHeaders() throws AuthFailureError {
                Map <String, String> headers = new HashMap <>();
                headers.put("Authorization", "Bearer " + accessToken);
                headers.put("Content-Type", "application/json");
                return headers;
            }
            @Override
            protected Response <JSONObject> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                try {
                    jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                Log.d("Raw API Response", jsonString);  // Log the raw JSON response from the server
                try {
                    return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));
                } catch (JSONException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        int timeoutMs = 25000; // 25 seconds timeout
        RetryPolicy policy = new DefaultRetryPolicy(timeoutMs, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        // Add the request to the RequestQueue
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }
}
