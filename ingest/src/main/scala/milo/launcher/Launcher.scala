package milo.launcher

import java.net.InetSocketAddress

import akka.actor._
import com.typesafe.config.ConfigFactory
import milo.server.MiloTcpServer

object Launcher {
  implicit val universe = ActorSystem("MiloSystem", ConfigFactory.load("akka"))

  // Application configuration file, by default
  // should be 'application.conf'
  val config = ConfigFactory.load().getConfig("milo.server")

  // Application entry point
  def main(args: Array[String]): Unit = {
    val interface = config.getString("interface")
    val port      = config.getInt("port")

    val socket = new InetSocketAddress(interface, port)

    universe.actorOf(Props(classOf[MiloTcpServer], socket))
  }

}