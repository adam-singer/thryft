package org.thryft;

import java.util.Collection;

import com.google.common.collect.ImmutableMap;

public final class Comparators {
    public static int compare(final byte[] left, final byte[] right) {
        int result = ((Integer) left.length).compareTo(right.length);
        if (result != 0) {
            return result;
        }

        for (int i = 0; i < left.length; i++) {
            result = ((Byte) left[i]).compareTo(right[i]);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public static <E extends Comparable<E>> int compare(
            final Collection<E> left, final Collection<E> right) {
        int result = ((Integer) left.size()).compareTo(right.size());
        if (result != 0) {
            return result;
        }

        final java.util.List<E> leftSortedList = com.google.common.collect.Lists
                .newArrayList(left);
        java.util.Collections.sort(leftSortedList);
        final java.util.Iterator<E> leftI = leftSortedList.iterator();

        final java.util.List<E> rightSortedList = com.google.common.collect.Lists
                .newArrayList(right);
        java.util.Collections.sort(rightSortedList);
        final java.util.Iterator<E> rightI = leftSortedList.iterator();

        while (leftI.hasNext()) {
            final E leftElement = leftI.next();
            final E rightElement = rightI.next();

            result = leftElement.compareTo(rightElement);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public static <K, V extends Comparable<V>> int compare(
            final ImmutableMap<K, V> left, final ImmutableMap<K, V> right) {
        for (final com.google.common.collect.ImmutableMap.Entry<K, V> leftEntry : left
                .entrySet()) {
            final V rightValue = right.get(leftEntry.getKey());
            if (rightValue == null) {
                return 1;
            }
            final int result = leftEntry.getValue().compareTo(rightValue);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public static int compare(final Object left, final Object right) {
        if (left.equals(right)) {
            return 0;
        } else {
            return -1;
        }
    }

    private Comparators() {
    }
}
