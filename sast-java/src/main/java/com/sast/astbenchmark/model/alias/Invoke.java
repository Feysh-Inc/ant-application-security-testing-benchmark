package com.sast.astbenchmark.model.alias;

import java.util.Random;

public class Invoke {

    public static void copy(DataClass dc1, DataClass dc2) {
        dc2.data = dc1.data;
    }

    public static void copy(A b, String string) {
        A c = b;
        c.b = string;
    }

    public static A newA(String data) {
        A a = new A();
        A b = a;
        b.b = data;
        return a;
    }

    public static void taintMe(DataClass dc, String taint) {
        String tainted = taint;
        dc.data = tainted;
    }

    public static A alias(B b) {
        return b.attr;
    }

    public static A alias(A a) {
        A r = a;
        return r;
    }

    public static String alias(String val) {
        String r = val;
        return r;
    }

    public static void alias(B b, A a) {
        b.attr = a;
    }

    private static void doUnalias(B b2) {
        b2.attr = new A();
    }

    private static void overwriteParameter(B b) {
        b = new B();
    }

    private static <T> SimpleLinkedList<T> newSimpleLinkedList(T data) {
        SimpleLinkedList<T> link = new SimpleLinkedList<>();
        SimpleLinkedList<T> link1 = new SimpleLinkedList<>();
        SimpleLinkedList<T> link2 = new SimpleLinkedList<>();
        SimpleLinkedList<T> link3 = new SimpleLinkedList<>();
        SimpleLinkedList<T> link4 = new SimpleLinkedList<>();
        SimpleLinkedList<T> link5 = new SimpleLinkedList<>();
        SimpleLinkedList<T> link6 = new SimpleLinkedList<>();
        link.next = link1;
        link1.next = link2;
        link2.next = link3;
        link3.next = link4;
        link4.next = link5;
        link5.next = link6;
        link6.data = data;
        return link;
    }

    private static String taintRecursively(A a, String v) {
        if (new Random().nextBoolean()) {
            a.b = v;
            return "";
        } else {
            A a2 = new A();
            taintRecursively(a2, v + "foo");
            return a2.b;
        }
    }

    private static void assign(final Container2 base, final String string) {
        base.f.g = string;
    }
}