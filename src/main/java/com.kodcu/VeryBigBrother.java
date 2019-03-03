package com.kodcu;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Singleton
public class VeryBigBrother {


    private CopyOnWriteArrayList<String> messageQueue;

    //@Resource
    //ManagedExecutorService mes;

    @Resource
    TimerService timerService;
    private Timer timer;

    @Inject
    MessageAnalyzer messageAnalyzer;

    @PostConstruct
    public void initialize() {
        this.messageQueue = new CopyOnWriteArrayList<>();
        ScheduleExpression se = new ScheduleExpression();
        se.minute("*").hour("*").second("*/5");
        this.timer = timerService.createCalendarTimer(se);

    }


  public void gatherEverything(String message) {
        this.messageQueue.add(message);
  }


    @Timeout
    public void batchAnalyze() {

        System.out.println("Analyzing at : " + new Date());
        List<Future<Boolean>> results = new ArrayList<>();
        for (String message : messageQueue) {
           results.add(messageAnalyzer.analyze(message));
           this.messageQueue.remove(message);
        }

        for (Future<Boolean> result : results) {
            try {
                System.out.println(" ### " + result.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "VeryBigBrother{}";
    }

}
