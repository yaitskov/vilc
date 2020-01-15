package org.vilc

import org.bytedeco.javacpp.Loader
import org.bytedeco.javacpp.Pointer
import org.bytedeco.javacpp.opencv_java
//import org.bytedeco.javacv.OpenCVFrameConverter
import org.bytedeco.opencv.opencv_core.Image2D
import org.bytedeco.opencv.opencv_core.IplConvKernel
import org.bytedeco.opencv.opencv_core.IplImage
import org.bytedeco.opencv.opencv_core.Mat
import org.junit.Ignore
import org.junit.Test
import org.opencv.core.CvType
//import org.opencv.core.Mat
import org.opencv.imgcodecs.Imgcodecs
import org.opencv.imgproc.Imgproc
import org.opencv.osgi.OpenCVNativeLoader
import java.io.File
import java.nio.file.Paths
import java.util.stream.Stream
import kotlin.test.assertNotNull

class OpenCvTest {
  @Test
  fun init() {
//    for (dllFile :File in File(".").listFiles { x -> x.extension == "dll" }) {
//      print("Load ${dllFile.nameWithoutExtension}\n")
//      System.loadLibrary(dllFile.nameWithoutExtension)
//
//    }
    Loader.load(opencv_java::class.java)
    //OpenCVNativeLoader().init()
    val mat = org.opencv.core.Mat()
    assertNotNull(mat)
    // Loader.load(opencv_java::class.java)
    //    OpenCVNativeLoader().init()
  }

  @Test
  @Ignore
  fun grayScale() {


    val stripper = Stripper()
    val stripe = stripper.makeStripe(300, 300)
    val buffer = ImageConverter.bufferedImageToByteBuffer(stripe)


    val srcMat = Mat(stripe.width, stripe.height, CvType.CV_8UC3)
    srcMat.put<Pointer>(Pointer(buffer))

    val src2 = org.opencv.core.Mat(srcMat.address())
    val dst2 = org.opencv.core.Mat(stripe.width, stripe.height, CvType.CV_8UC1)
    //val srcFrame = OpenCVFrameConverter.ToMat().convert(srcMat)

    val dstMat = org.opencv.core.Mat(stripe.width, stripe.height, CvType.CV_8U)
    //IplImage.create(1, 2, 1, 1)
    Imgproc.cvtColor(src2, dst2,  Imgproc.COLOR_RGB2GRAY)
    //Imgproc.cvtColor(srcMat, dstMat, Imgproc.COLOR_RGB2GRAY)


  }
}