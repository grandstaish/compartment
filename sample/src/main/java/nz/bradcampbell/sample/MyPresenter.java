package nz.bradcampbell.sample;

import nz.bradcampbell.compartment.BasePresenter;

/**
 * Simple presenter instance used to update the {@link MyFragment}
 */
public class MyPresenter extends BasePresenter<MyView> {
    @Override public void bindView(MyView view) {
        super.bindView(view);
        // Update the view after it is bound to the presenter
        view.doSomething();
    }
}
