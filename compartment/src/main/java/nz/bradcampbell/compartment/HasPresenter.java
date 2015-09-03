package nz.bradcampbell.compartment;

public interface HasPresenter<P extends Presenter> {
    P getPresenter();
}
