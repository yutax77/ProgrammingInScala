import scala.collection.mutable.{Map, SynchronizedMap, HashMap}
object MapMaker {
    def makeMap: Map[String, String] = {
        new HashMap[String, String] with SynchronizedMap[String, String] {
            override def default(key: String) = 
                "Why do you want to know?"
        }
    }
}
