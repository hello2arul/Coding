package Searching;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/my-calendar-ii/
You are implementing a program to use as your calendar. We can add a new event
if adding the event will not cause a triple booking.

A triple booking happens when three events have some non-empty intersection
(i.e., some moment is common to all the three events.).

The event can be represented as a pair of integers start and end that represents 
a booking on the half-open interval [start, end), the range of real numbers x such 
that start <= x < end.

Implement the MyCalendarTwo class:

MyCalendarTwo() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to 
the calendar successfully without causing a triple booking. Otherwise, return false 
and do not add the event to the calendar.

*/
public class MyCalenderII {
    List<int[]> one;
    List<int[]> two;

    public MyCalenderII() {
        one = new ArrayList<>();
        two = new ArrayList<>();    
    }
    
    public boolean book(int start, int end) {
        for (int[] arr: two) {
            if (arr[0] < end && start < arr[1])
                return false;
        }
        for (int[] arr: one) {
            if (arr[0] < end && start < arr[1])
                two.add(new int[] {Math.max(start, arr[0]), Math.min(end, arr[1])});
        }
        one.add(new int[] {start, end});
        return true;
    }
}
