package org.vilc

import java.util.regex.Pattern

object OcrTextInterpreterFactory {

  fun create(): OcrTextInterpreter {
    return OcrTextInterpreter(
        Pattern.compile("""^.*[ /](([A-Za-z0-9_-]+[.])+(org|ru|pl|biz|com|net|mil|gov|us)(/[A-Za-z0-9_+%-]+)*).*$"""))
  }
}