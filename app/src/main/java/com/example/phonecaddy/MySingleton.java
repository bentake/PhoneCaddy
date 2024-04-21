package com.example.phonecaddy;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Singleton class for managing a single instance of a {@link RequestQueue} used for
 * all network requests in the application using Volley's request queue mechanism.
 * This ensures that all network requests are queued and executed through a single
 * instance of the request queue throughout the application.
 *
 * Usage of a single instance for the request queue improves performance and avoids
 * creating multiple instances of network threads and queues throughout the app lifecycle.
 */
public class MySingleton {
    private static MySingleton instance; // Singleton instance of this class
    private RequestQueue requestQueue; // Volley RequestQueue for managing network requests
    private static Context context; // Application context used to create the request queue

    /**
     * Private constructor to create a new MySingleton instance. This constructor initializes
     * the request queue for the application's context.
     *
     * @param ctx The application context which is needed to create the request queue.
     */
    private MySingleton(Context ctx) {
        context = ctx; // Use application context to prevent memory leaks
        requestQueue = getRequestQueue(); // Initialize the request queue
    }

    /**
     * Returns the single instance of {@link MySingleton} class, creating it if necessary.
     * This method provides a global point of access to the MySingleton instance.
     *
     * @param context The Context to which the singleton will be attached; used only for the first instantiation.
     * @return The single, shared instance of the MySingleton class.
     */
    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }

    /**
     * Retrieves the instance of the {@link RequestQueue} that will be used for all network requests.
     * If no RequestQueue has been instantiated yet, this method will create one.
     *
     * @return The single instance of {@link RequestQueue} for handling network requests.
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    /**
     * Adds a {@link Request} to the {@link RequestQueue}. This method ensures that all network
     * requests are queued and processed through the same RequestQueue instance.
     *
     * @param req The request to add to the queue.
     * @param <T> The type of the result expected from the Request.
     */
    public <T> void addToRequestQueue(Request <T> req) {
        getRequestQueue().add(req);
    }
}
