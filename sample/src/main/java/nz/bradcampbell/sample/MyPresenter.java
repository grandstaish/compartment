package nz.bradcampbell.sample;

import nz.bradcampbell.compartment.BasePresenter;

public class MyPresenter extends BasePresenter<MyView> {
    @Override public void bindView(MyView view) {
        super.bindView(view);
        view.doSomething();
    }
}
