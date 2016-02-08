package nz.bradcampbell.sample;

import android.os.Bundle;

import nz.bradcampbell.compartment.ComponentCacheActivity;

/**
 * Launcher Activity for Compartment Sample
 * Instantiates a new {@link MyFragment} and adds it to the layout.
 *
 * @see ComponentCacheActivity
 */
public class MyActivity extends ComponentCacheActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Initialize layout
        setContentView(R.layout.my_activity);

        if (savedInstanceState == null) {
            // Instantiate a new MyFragment.class and add it to the root layout
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root, new MyFragment())
                    .commit();
        }
    }
}
