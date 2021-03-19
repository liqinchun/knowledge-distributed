package com.liqinchun.knowledge.distributed.task;


public class ScheduledTaskWapper implements Runnable {

    ScheduledTask scheduledTask;

    public ScheduledTaskWapper(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }

    @Override
    public void run() {
        try {
            scheduledTask.printCurrentTime();
//            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
