package com.dkus.misc.examples



//import org.apache.spark.{SparkConf, SparkContext}
//
///**
//  * @author aschwartz on 6/8/16 (#)
//  */
//object SparkTest {
//
//  def isEqual(number:Int): Boolean = number % 2 == 0
//
//  def main(args:Array[String]): Unit = {
//
//    val conf = new SparkConf().setMaster("local[1]").setAppName("Test")
//    val sc = new SparkContext(conf)
//
//    val data = List(1,2,3,4,5,6,7,8,9,10)
//
//    val rdd = sc.parallelize(data)
//
//    // Keep all equal numbers:
//    val equalNumbers = rdd.filter(isEqual).collect().toList
//    println(equalNumbers)
//  }
//}