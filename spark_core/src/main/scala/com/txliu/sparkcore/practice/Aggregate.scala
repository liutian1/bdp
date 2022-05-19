package com.txliu.sparkcore.practice

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * @author txliu
 * @date 2022/5/19 
 */
object Aggregate {
  def main(args: Array[String]): Unit = {

    val immutableList = List(1, 2, 3, 4, 5)
    // 不变List 添加元素
    val newImmutableList = 0 +: immutableList :+ 6
    //    println(newImmutableList.mkString(","))

    // :+
    val mutableList = ListBuffer(1, 2, 3, 4, 5)
    val newMutableList = 0 +: mutableList :+ 6
    0 +=: mutableList += 6


    //    println(newMutableList)
    //    println(mutableList)

    val arr = new Array[Int](5)
    arr(0) = 0
    arr(1) = 1
    arr(2) = 2
    arr(3) = 3
    // 0位置的值变成9
    //    arr.update(0,9)
    //    println(arr.mkString(","))
    //    for (i <- arr) {
    //      println(i)
    //    }
    //    arr.foreach(println)
    val arr02 = Array(0, 1, 2)
    //    arr02.foreach(println)

    val arrayBuffer = ArrayBuffer(2, 3, 4)
    arrayBuffer.+=(6)
    arrayBuffer += 9
    arrayBuffer.append(0, 0, 0)
    arrayBuffer.insert(0, 7, 8)
    arrayBuffer(0) = 10
    val array = arrayBuffer.toArray
    val buffer = array.toBuffer


    //    arrayBuffer.foreach(println)

    val list = List(0, 1, 2, 3, 4)

    val list2 = -1 :: list
    //    println(list2.mkString(","))
    //    println(list2(0))
    val mutableSet = mutable.Set(3, 3, 4, 4)
    mutableSet += 8
    mutableSet-=8
//    println(mutableSet.mkString(","))

    val map = Map("a" -> 1, "b" -> 2)
//    println(map)
//    for (elem <- map.keys ) {
//      println(elem+"   "+map.get(elem).get)
//    }

//    println(map.get("dd").getOrElse(0))
//    println(map.getOrElse("dd",8))
//    map.foreach((kv) => println(kv))

//    val mutableMap = mutable.Map("a" -> 1, "b" -> 2)
//
//    mutableMap+= "c"->5
//    mutableMap.put("d",7)
//    mutableMap -=("c","d")
//    println(mutableMap)

//    val tuple = (1,2,3,4)
//    println(tuple._1)
//    println(tuple.productElement(0))
//    for (elem <- tuple.productIterator) {
//      println(elem)
//    }
    println(describe(6))


  }
  def describe(x:Any) = x match {
    case x:Int => " int five"
    case "hello" => "string hello"
    case  _ => " nothing"
  }

}
