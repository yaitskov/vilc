package org.vilc

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import java.nio.file.Paths
import javax.imageio.ImageIO

class App {
  fun extractUrl() {

  }

  fun onClickTarget(cursorX: Int, cursorY: Int) {
    makeStripe(cursorX, cursorY)
  }

  fun makeStripe(x: Int, y: Int) {
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
    val stripeWidth = 100
    val shotRect = Rectangle(
        10,
        Math.max(0, y - stripeWidth / 2),
        screenRect.width - 10,
        stripeWidth)
    val capture: BufferedImage = Robot().createScreenCapture(shotRect)
    val stream = ByteArrayOutputStream()
    ImageIO.write(capture, "bmp", stream)
    val bytes = stream.toByteArray()
    Files.write(Paths.get("current.bmp"), bytes)

  }
}