package com.example;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * @author McClone
 */
public class HelloWorld {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.just("abc", "123").subscribe(s -> {
            for (char c : s.toCharArray()) {
                System.out.println(c);
            }
            System.out.println(".");
        });

        Observable.fromArray("1", "2", "3")
                .subscribe(s -> {
                }, throwable -> {
                }, () -> {
                });


    }
}
