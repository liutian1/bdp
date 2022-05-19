package com.txliu.sparkcore.practice

import scala.util.control.Breaks.{break, breakable}

/**
 * @author txliu
 * @date 2022/5/18
 */
object ContinueDemo {
  def main(args: Array[String]): Unit = {
    var i = 0

    while (i < 20) {

      i += 1
      // continue
      breakable {
        if (i % 2 == 1) {
          break()
        }
        println(i)
      }

    }
  }


}
