package com.data;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Task implements Callable<List<Result>> {
    private List<Record> dtoList = null;

    public Task(List<Record> dtoList) {
        this.dtoList = dtoList;
    }

    @Override
    public List<Result> call() throws Exception {
       System.out.println("Started Thread-"+Thread.currentThread().getName());
        Thread. sleep(1000);
        System.out.println("Ends Thread-"+Thread.currentThread().getName());
        //TODO Actual API calls
       return dtoList.stream().map(record->new Result(record.getName(), record.getEmail(), record.getUserId(), "PASSED", "N?A")).collect(Collectors.toList());
    }
}
