package nz.bradcampbell.sample;

import android.os.Bundle;

import nz.bradcampbell.compartment.ComponentCacheActivity;

public class MyActivity extends ComponentCacheActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root, new MyFragment())
                    .commit();
        }
    }
}
