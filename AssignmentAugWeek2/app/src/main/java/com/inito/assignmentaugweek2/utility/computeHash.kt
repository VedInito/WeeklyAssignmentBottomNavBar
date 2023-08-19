package com.inito.assignmentaugweek2.utility

fun computeHash(s: String): Long {
    val p = 31
    val m = 1_000_000_007
    var hashValue: Long = 0
    var pPow: Long = 1

    for (c in s) {
        hashValue = (hashValue + (c - 'a' + 1) * pPow) % m
        pPow = (pPow * p) % m
    }

    return hashValue
}