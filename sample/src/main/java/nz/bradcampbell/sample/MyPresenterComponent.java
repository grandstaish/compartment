package nz.bradcampbell.sample;

import nz.bradcampbell.compartment.HasPresenter;

/**
 * Implementation of {@link HasPresenter} related to {@link MyFragment}
 * Creates and provides a {@link MyPresenter} instance
 */
public class MyPresenterComponent implements HasPresenter<MyPresenter> {
    /**
     * Presenter instance used during the lifecycle of the related {@link nz.bradcampbell.compartment.ComponentControllerFragment}
     */
    private MyPresenter presenter = new MyPresenter();

    @Override
    public MyPresenter getPresenter() {

        return presenter;
    }
}
