package org.hamcrest.kotlin

import org.hamcrest.kotlin.internal.match


public fun <T> contains(elementMatcher: Matcher<T>) : Matcher<Iterable<T>> {
    return object : Matcher.Primitive<Iterable<T>>() {
        override fun invoke(actual: Iterable<T>): MatchResult =
                match(actual.any(elementMatcher.asPredicate())) {"was ${delimit(actual)}"}

        override fun description(): String = "containing a value ${elementMatcher.description()}"
        override fun negatedDescription() : String = "containing no value ${elementMatcher.description()}"
    }
}