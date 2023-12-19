package main

object Main extends App {
  private val program = new Program

  try {
    program.parse(args.toList)
    program.run()
  } catch {
    case e:Any => println(e.getMessage)
  }
}