package nz.bradcampbell.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import nz.bradcampbell.compartment.PresenterControllerFragment;

public class MyFragment extends PresenterControllerFragment<MyPresenterComponent, MyPresenter> implements MyView {

    private TextView mContent;

    @Override protected MyPresenterComponent onCreateNonConfigurationComponent() {
        return new MyPresenterComponent();
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_layout, container, false);
        mContent = ((TextView) rootView.findViewById(R.id.content));
        return rootView;
    }

    @Override public void doSomething() {
        MyPresenter p = getPresenter();
        mContent.setText(p.toString());

        // Print the memory location in logcat so see if it is the same instance
        // on config changes
        Log.d("TEST", p.toString());
    }
}
