package org.vilc

import java.awt.Desktop
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Paths

class App(val ocr: Ocr, val interpreter: OcrTextInterpreter) {
  fun onClickTarget(cursorX: Int, cursorY: Int) {
    val stripe = makeStripe(cursorX, cursorY)
    val buffer = ImageConverter.bufferedImageToByteBuffer(stripe)

    val ocrText = ocr.pictureToText(buffer, stripe.width, stripe.height)
    val mayBeUrl = interpreter.extractUrl(ocrText)
    if (mayBeUrl.isPresent) {
      if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
        Desktop.getDesktop().browse(mayBeUrl.get().toURI());
      }
    }
    Files.write(Paths.get("extracted.txt"), "url $mayBeUrl from:\n$ocrText".toByteArray())
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
  }
}