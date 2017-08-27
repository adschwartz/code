package com.dkus.misc.examples.ninetynine.artihmetic

class S99Int(val start: Int) {

    def isPrime: Boolean = {
      (start > 1) && (S99Int.primes.takeWhile {
        _ <= Math.sqrt(start)
      } forall {
        start % _ != 0
      })
    }

  }

  object S99Int {

    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)

    val primes = Stream.cons(2, Stream.from(3, 2) filter {
      _.isPrime
    })


  }