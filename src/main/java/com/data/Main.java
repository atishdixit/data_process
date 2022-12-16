package com.data;

import java.util.*;
import java.util.concurrent.*;
import static java.util.regex.Pattern.quote;

public class Main {

    public static void main(String as[]){

        String[] Values = "A|B".split(quote("|"));


        int NUMBER_OF_THREAD = 20;
        int numberOfRecord = 50000;
        int executePerThread = 50;
        int start = 0;
        int end=executePerThread;
        List<Record> dtoList = new ArrayList<>();

        for(int i = 0;i<numberOfRecord;i++) {
            dtoList.add(new Record("Name-"+i, "email-"+1, "userId-"+i, "PhoneNumber-"+i));
        }

        List<Task> taskList = new ArrayList<>();
        List<Future<List<Result>>> finalResult = null;
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);
        while(executePerThread<numberOfRecord){
            taskList.add(new Task(dtoList.subList(start, end)));
            start = end;
            end= end + executePerThread;
            numberOfRecord = numberOfRecord- executePerThread;
        }
        if(numberOfRecord!=0){
            taskList.add(new Task(dtoList.subList(start, start+numberOfRecord)));
        }

        try {
            finalResult = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        System.out.println("Result printing main thread.....");

        finalResult.stream().forEach(future-> {
            try {
                future.get().stream().forEach(System.out::println);


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
