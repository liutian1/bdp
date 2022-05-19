package com.txliu.sparkcore.practice

/**
 * @author txliu
 * @date 2022/5/18 
 */
object FunctionDemo {
  def main(args: Array[String]): Unit = {
    println(calculateTest(3,5,(a,b) => a-b ))
  }

  def calculateTest(a:Int,b:Int,operater:(Int,Int) => Int): Int = {
    operater(a,b)
  }

}
