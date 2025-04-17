package com.bounteous.priority;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Metric {
    public final AtomicInteger consumedCount = new AtomicInteger(0);
    public final AtomicInteger producedCount = new AtomicInteger(0);
    public final AtomicLong totalProcessingTime = new AtomicLong(0);

    public double getAverageProcessingTime(){
        int count = consumedCount.get();
        return count == 0 ? 0 : (totalProcessingTime.get()/1_000_000.0) / count;
    }
}
