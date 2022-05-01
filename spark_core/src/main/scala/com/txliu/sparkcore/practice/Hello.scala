package com.txliu.sparkcore.practice

/**
 * @ClassName : Hello 
 * @Author : txliu 
 * @Date: 2022-04-30 14:34
 */
object Hello {
  def main(args: Array[String]): Unit = {

    println("Hello scala")
    lazy val set: Set[Int] = Set(1, 2, 4)
    set.foreach(println)
    println()

  }

}
