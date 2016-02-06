package nz.bradcampbell.compartment;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Deprecated in favour of ComponentCacheActivity
 */
@Deprecated
public class ComponentCacheApplication extends Application implements ComponentCache {
    private final AtomicLong nextId = new AtomicLong();
    private Map<Long, Object> components = new HashMap<>();

    @Override public long generateId() {
        return nextId.getAndIncrement();
    }

    @SuppressWarnings("unchecked")
    @Override public <C> C getComponent(long index) {
        return (C) components.get(index);
    }

    @Override public <C> void setComponent(long index, C component) {
        components.put(index, component);
    }
}
