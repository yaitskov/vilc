package org.vilc

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage

class Stripper {
  fun makeStripe(x: Int, y: Int): BufferedImage {
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
    val stripeWidth = 100
    val shotRect = Rectangle(
        10,
        Math.max(0, y - stripeWidth / 2),
        screenRect.width - 10,
        stripeWidth)
    return Robot().createScreenCapture(shotRect)
  }
}