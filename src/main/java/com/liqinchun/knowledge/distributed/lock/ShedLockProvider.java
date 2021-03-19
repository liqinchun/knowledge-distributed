package com.liqinchun.knowledge.distributed.lock;

import net.javacrumbs.shedlock.core.*;

import java.time.Duration;
import java.util.Optional;

/**
 * @author liqinchun
 */
public class ShedLockProvider extends AbstractSimpleLock implements LockProvider {
    protected ShedLockProvider(LockConfiguration lockConfiguration) {
        super(lockConfiguration);
    }

    @Override
    public Optional<SimpleLock> lock(LockConfiguration lockConfiguration) {
        LockAssert.assertLocked();
        return Optional.empty();
    }

    @Override
    protected void doUnlock() {

    }

    @Override
    public Optional<SimpleLock> extend(Duration lockAtMostFor, Duration lockAtLeastFor) {
        return super.extend(lockAtMostFor, lockAtLeastFor);
    }
}
