# compartment

## Overview

Compartment is an MVP (Model View Presenter) library for Android. It aims to make scoping really easy for Presenters so that they don't get destroyed on configuration changes. 

## Usage

#### Step 1: create a custom `Application` class and extend `ComponentCacheApplication`:

```
public class MyApp extends ComponentCacheApplication {
    ...
}
```

Remember to add it to your manifest:

```
<application android:name=".MyApp">
        ...
</application>
```

#### Step 2: create a "view" interface (the "V" in MVP):

```
public interface MyView {
  void doSomething();
  void showLoading();
  void hideLoading();
  ...
}
```

#### Step 3: create a presenter that implements `Presenter` or uses the convenience class `BasePresenter`:
```
public class MyPresenter extends BasePresenter<MyView> {
  public void someLongTask() {
    view.showLoading();
    
    new AsyncTask<Void, Void, Void>() {
      public Void doInBackground(Void... args) {
        // Simulate some long task
        Thread.sleep(5000);
      }
      
      public void onPostExecute(Void result) {
        view.doSomething();
        view.hideLoading();
      }
    }.start();
  }
}
```

#### Step 4: create an object to hold a presenter (implements `HasPresenter`):

```
public class MyPresenterComponent implements HasPresenter<MyPresenter> {
  private MyPresenter presenter = new MyPresenter();
  
  @Override MyPresenter getPresenter() {
    return presenter;
  }
}
```

#### Step 5: create a Fragment that extends `PresenterControllerFragment` and imlpements your view interface:

```
public class MyFragment extends PresenterControllerFragment<MyPresenterComponent, MyPresenter> implements MyView {
  @Override protected MyPresenterComponent onCreateNonConfigurationComponent() {
    return new MyPresenterComponent();
  }
  ...
}
```

Your fragment now has an associated presenter that you can access using `getPresenter()`. This presenter will survive configuration changes. 

## Tip

This library works well when combined with Dagger 2 as you can use Dagger 2 components for Step 4.

## Example

https://github.com/grandstaish/hello-mvp-dagger-2

## Gradle 

```
repositories {
  jcenter()
}

dependencies {
  compile 'nz.bradcampbell.compartment:compartment:0.0.2'
}
```
