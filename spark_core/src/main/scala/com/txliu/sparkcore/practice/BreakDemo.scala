package com.txliu.sparkcore.practice

import scala.util.control.Breaks.{break, breakable}

/**
 * @author txliu
 * @date 2022/5/18
 */
object BreakDemo {
  def main(args: Array[String]): Unit = {
    var i = 0
    breakable {
      while (true) {
        println(i)
        i += 1
        if (i == 10) {
          break()
        }
      }

    }
  }

}
