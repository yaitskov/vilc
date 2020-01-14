package org.vilc

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.file.Files
import java.nio.file.Paths

class App(val ocr: Ocr) {
  fun onClickTarget(cursorX: Int, cursorY: Int) {
    val stripe = makeStripe(cursorX, cursorY)
    val buffer = ImageConverter.bufferedImageToByteBuffer(stripe)

    Files.write(Paths.get("extracted.txt"),
        ocr.pictureToText(buffer, stripe.width, stripe.height)
            .toByteArray())
  }

  fun makeStripe(x: Int, y: Int): BufferedImage {
    val screenRect = Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
    val stripeWidth = 100
    val shotRect = Rectangle(
        10,
        Math.max(0, y - stripeWidth / 2),
        screenRect.width - 10,
        stripeWidth)
    return Robot().createScreenCapture(shotRect)
    //val stream = ByteArrayOutputStream()
    // ImageIO.write(capture, "bmp", stream)
    //val bytes = stream.toByteArray()
    // Files.write(Paths.get("current.bmp"), bytes)
    //return Stripe(shotRect, ByteBuffer.wrap(bytes))
  }
}