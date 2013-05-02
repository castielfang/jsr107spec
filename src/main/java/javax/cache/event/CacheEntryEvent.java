/**
 *  Copyright (c) 2011 Terracotta, Inc.
 *  Copyright (c) 2011 Oracle and/or its affiliates.
 *
 *  All rights reserved. Use is subject to license terms.
 */

package javax.cache.event;

import javax.cache.Cache;
import java.util.EventObject;

/**
 * A Cache event base class
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of cached values
 * @since 1.0
 */
public abstract class CacheEntryEvent<K, V> extends EventObject implements Cache.Entry<K, V> {

    /**
     * Constructs a cache entry event from a given cache as source
     * @param source the cache that originated the event
     */
    public CacheEntryEvent(Cache source) {
        super(source);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Cache getSource() {
        return (Cache) super.getSource();
    }

    /**
     * Returns the value of the cache entry with the event
     * @return the value
     * @throws UnsupportedOperationException if the old value is not available
     */
    public abstract V getOldValue() throws UnsupportedOperationException;


    /**
     * Whether the old value is available
     * @return true if the old value is populated
     */
    public abstract boolean isOldValueAvailable();
}
