package org.vilc

import java.awt.image.BufferedImage
import java.awt.image.DataBuffer
import java.awt.image.DataBufferByte
import java.awt.image.DataBufferInt
import java.awt.image.DataBufferShort
import java.awt.image.DataBufferUShort
import java.nio.ByteBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer

object ImageConverter {
  fun bufferedImageToByteBuffer(bi: BufferedImage): ByteBuffer {
    val dataBuffer: DataBuffer = bi.raster.dataBuffer

    if (dataBuffer is DataBufferByte) {
      val pixelData = dataBuffer.data
      return ByteBuffer.wrap(pixelData)
    } else if (dataBuffer is DataBufferUShort) {
      val pixelData = dataBuffer.data
      val byteBuffer = ByteBuffer.allocate(pixelData.size * 2)
      byteBuffer.asShortBuffer().put(ShortBuffer.wrap(pixelData))
      return byteBuffer
    } else if (dataBuffer is DataBufferShort) {
      val pixelData = dataBuffer.data
      val byteBuffer = ByteBuffer.allocate(pixelData.size * 2)
      byteBuffer.asShortBuffer().put(ShortBuffer.wrap(pixelData))
      return byteBuffer
    } else if (dataBuffer is DataBufferInt) {
      val pixelData = dataBuffer.data
      val byteBuffer = ByteBuffer.allocate(pixelData.size * 4)
      byteBuffer.asIntBuffer().put(IntBuffer.wrap(pixelData))
      return byteBuffer
    } else {
      throw IllegalArgumentException("Not implemented for data buffer type: " + dataBuffer.javaClass)
    }
  }
}