package com.vincent.practice.stream;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SinkPractice {

    public static void main(String[] args) {
        int[] source = {1,2,3,4,5};
        Spliterator spliterator = Arrays.stream(source).spliterator();
        Sink<Integer> sink0 = new Sink<>(null, "source");
        Sink<Integer> sink4 =sink0.op("sink1").op("sink2").op("sink3").op("sink4");
        Sink wrapSink = wrapSink(sink4);
        assert(wrapSink == sink0); //now get the first (source) stage

        //in one loop, handle elements: 1,2,3,4,5
        spliterator.forEachRemaining(wrapSink);
    }

    public static Sink wrapSink(Sink sink) {
        while (sink.getUpStream() != null) {
            sink.getUpStream().setDownStream(sink);
            sink = sink.getUpStream();
        }
        return sink;
    }


}

class Sink<T> implements Consumer<T> {
    private Sink upStream;
    private Sink downStream;
    private String name;

    public Sink(Sink upStream, String name) {
        this.upStream = upStream;
        this.name = name;
    }

    public Sink op(String name) {
        return new Sink(this, name);
    }

    @Override
    public void accept(T t) {
        System.out.println(name + " handles " + t);
        if (downStream != null) {
            downStream.accept(t);
        }
    }

    public Sink getUpStream() {
        return upStream;
    }

    public void setUpStream(Sink upStream) {
        this.upStream = upStream;
    }

    public Sink getDownStream() {
        return downStream;
    }

    public void setDownStream(Sink downStream) {
        this.downStream = downStream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
