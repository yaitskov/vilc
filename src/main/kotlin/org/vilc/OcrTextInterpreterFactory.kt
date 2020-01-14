package org.vilc

import java.util.regex.Pattern

object OcrTextInterpreterFactory {

  fun create(): OcrTextInterpreter {
    val host = """^.*[ /](([A-Za-z0-9_-]+[,.])+(org|ru|pl|biz|com|net|mil|gov|us)([;:][0-9]{2,5} ?)?"""
    val path = """([/][A-Za-z0-9_+%-]+)*"""
    val params = """/?([?&][A-Za-z0-9_-]+(=[A-Za-z0-9_.,%+-]+)?)*).*$"""
    return OcrTextInterpreter(
        Pattern.compile(host + path + params))
  }
}