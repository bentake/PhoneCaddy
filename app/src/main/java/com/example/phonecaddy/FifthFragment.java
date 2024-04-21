package com.example.phonecaddy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
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
 * This class extends AppCompatActivity and handles the user interactions
 * and API requests to fetch chat completions from OpenAI's API.
 *
 * This class manages the setup and interactions of a RecyclerView for displaying messages,
 * and uses Volley for network requests to OpenAI's API.
 */
public class FifthFragment extends AppCompatActivity {
    private RecyclerView mRecyclerView; // RecyclerView for displaying messages
    private MessageAdapter mAdapter; // Adapter for managing data in RecyclerView
    private EditText mEditText; // EditText for user to enter input
    private Button mButton; // Button to trigger API requests
    private String apiUrl = "https://api.openai.com/v1/chat/completions"; // API URL for requests
    private String accessToken = "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"; // Access token for API authentication
    private List <Message> mMessages; // List to hold Message objects for RecyclerView

    /**
     * Overrides the onCreate method from AppCompatActivity to setup the UI and interactions.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mEditText = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.button);
        mMessages = new ArrayList <>();
        mAdapter = new MessageAdapter(mMessages);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAPI();
            }
        });
    }

    /**
     * Calls the OpenAI API to get chat completions based on the user's input.
     * Constructs a JSON request body and sends it using a POST request.
     * Handles responses and errors by updating the RecyclerView and logging errors respectively.
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
        MySingleton.getInstance(this).addToRequestQueue(request);
    }
}
