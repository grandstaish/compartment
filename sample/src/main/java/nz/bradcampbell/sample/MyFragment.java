package nz.bradcampbell.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nz.bradcampbell.compartment.PresenterControllerFragment;

/**
 * Content fragment used inside {@link MyActivity}
 * Implements the corresponding view interface ({@link MyView}) to expose view related functionality.
 */
public class MyFragment extends PresenterControllerFragment<MyPresenterComponent, MyPresenter> implements MyView {

    /**
     * TextView used to display the memory location of the related {@link MyPresenter}
     */
    private TextView mContent;

    @Override
    protected MyPresenterComponent onCreateNonConfigurationComponent() {

        return new MyPresenterComponent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.my_layout, container, false);

        // Initialize content TextView
        mContent = ((TextView) rootView.findViewById(R.id.content));

        return rootView;
    }

    @Override
    public void doSomething() {

        // Retrieve the presenter related to this MyFragment instance
        MyPresenter p = getPresenter();

        // Retrieve the memory location of the related presenter
        final String memoryLocation = p.toString();

        // Print the memory location in the UI
        mContent.setText(memoryLocation);

        // Print the memory location in logcat so see if it is the same instance on config changes
        Log.d("PRESENTER_CACHE_TEST", memoryLocation);
    }
}
