package org.vilc

import java.net.MalformedURLException
import java.net.URL
import java.util.*
import java.util.regex.Pattern

class OcrTextInterpreter(val urlPattern: Pattern) {

  fun extractUrl(text: String): Optional<URL> {
    val matcher = urlPattern.matcher(text)
    if (matcher.find()) {
      try {
        return Optional.of(URL("http://${matcher.group(1)}"))
      } catch (e: MalformedURLException) {
        print("bad url ${matcher.group(1)}")
      }
    }
    return Optional.empty()
  }
}