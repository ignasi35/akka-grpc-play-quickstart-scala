package example.myapp.helloworld.grpc

import akka.stream.Materializer
import javax.inject.{Inject, Named}

import scala.concurrent.Future

class GreeterServiceImpl @Inject()(mat: Materializer) extends GreeterService {
  private implicit val ec = mat.executionContext

  override def sayHello(in: HelloRequest): Future[HelloReply] =
    Future {
      HelloReply(s"Hello, ${in.name}!")
    }
}
