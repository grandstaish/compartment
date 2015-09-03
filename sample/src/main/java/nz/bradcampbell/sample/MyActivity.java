package nz.bradcampbell.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
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
