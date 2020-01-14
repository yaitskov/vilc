package org.vilc

import org.bytedeco.javacpp.tesseract
import java.nio.ByteBuffer

class Ocr(val tessApi: tesseract.TessBaseAPI) {
  fun pictureToText(bb: ByteBuffer, width: Int, height: Int ): String {
    tessApi.SetImage(bb, width, height, 4, width * 4)
    return tessApi.GetUTF8Text().string
  }
}