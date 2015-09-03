package nz.bradcampbell.compartment;

public interface ComponentCache {
    long generateId();
    <C> C getComponent(long index);
    <C> void setComponent(long index, C component);
}
