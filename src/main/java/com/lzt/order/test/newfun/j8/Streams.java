package com.lzt.order.test.newfun.j8;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private enum Status {
        OPEN, CLOSED
    }

    ;

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String args[]) {
        final List<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );


        final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        final long totalPoints = tasks.stream().mapToInt(Task::getPoints).sum();

//        System.out.println(totalPointsOfOpenTasks);
//        System.out.println(totalPoints);
//
//        System.out.println(tasks.stream().count());


        final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));


        tasks
                .stream()                                        // Stream< String >
                .mapToInt(Task::getPoints)                     // IntStream


                .asLongStream()                                  // LongStream
                .mapToDouble(points -> points / totalPoints)   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong(weigth -> (long) (weigth * 100)) // LongStream
                .mapToObj(percentage -> percentage + "%")      // Stream< String>
                .collect(Collectors.toList());                 // List< String >




        System.out.println(map);



        final Map<Status, List<Task>> map1 = tasks.stream().distinct().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map1);

    }
}
