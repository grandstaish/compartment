package nz.bradcampbell.sample;

import nz.bradcampbell.compartment.HasPresenter;

public class MyPresenterComponent implements HasPresenter<MyPresenter> {
    private MyPresenter presenter = new MyPresenter();

    @Override public MyPresenter getPresenter() {
        return presenter;
    }
}
