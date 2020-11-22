/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144307
 */
package xed.userprofile.service

import com.twitter.finagle.{
  service => ctfs,
  Filter => finagle$Filter,
  Service => finagle$Service,
  thrift => _,
  _
}
import com.twitter.finagle.stats.{Counter, NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.RichServerParam
import com.twitter.io.Buf
import com.twitter.scrooge._
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, HashMap => mutable$HashMap}
import scala.collection.{Map, Set}

import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class TUserProfileService$FinagleService(
  iface: TUserProfileService[Future],
  serverParam: RichServerParam
) extends com.twitter.finagle.Service[Array[Byte], Array[Byte]] {
  import TUserProfileService._

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: TUserProfileService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver = NullStatsReceiver,
    maxThriftBufferSize: Int = Thrift.param.maxThriftBufferSize,
    serviceName: String = "TUserProfileService"
  ) = this(iface, RichServerParam(protocolFactory, serviceName, maxThriftBufferSize, stats))

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: TUserProfileService[Future],
    protocolFactory: TProtocolFactory,
    stats: StatsReceiver,
    maxThriftBufferSize: Int
  ) = this(iface, protocolFactory, stats, maxThriftBufferSize, "TUserProfileService")

  @deprecated("Use com.twitter.finagle.thrift.RichServerParam", "2017-08-16")
  def this(
    iface: TUserProfileService[Future],
    protocolFactory: TProtocolFactory
  ) = this(iface, protocolFactory, NullStatsReceiver, Thrift.param.maxThriftBufferSize)

  def serviceName: String = serverParam.serviceName
  private[this] def responseClassifier: ctfs.ResponseClassifier = serverParam.responseClassifier
  private[this] def stats: StatsReceiver = serverParam.serverStats

  private[this] def protocolFactory: TProtocolFactory = serverParam.restrictedProtocolFactory
  private[this] def maxReusableBufferSize: Int = serverParam.maxThriftBufferSize

  private[this] val tlReusableBuffer = TReusableBuffer(maxThriftBufferSize = maxReusableBufferSize)

  protected val serviceMap = new mutable$HashMap[String, finagle$Service[(TProtocol, Int), Array[Byte]]]()

  protected def addService(name: String, service: finagle$Service[(TProtocol, Int), Array[Byte]]): Unit = {
    serviceMap(name) = service
  }

  final protected def exception(name: String, seqid: Int, code: Int, message: String): Buf = {
    val x = new TApplicationException(code, message)
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
      x.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final protected def reply(name: String, seqid: Int, result: ThriftStruct): Buf = {
    val memoryBuffer = tlReusableBuffer.get()
    try {
      val oprot = protocolFactory.getProtocol(memoryBuffer)

      oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
      result.write(oprot)
      oprot.writeMessageEnd()
      oprot.getTransport().flush()

      // make a copy of the array of bytes to construct a new buffer because memoryBuffer is reusable
      Buf.ByteArray.Shared(memoryBuffer.getArray(), 0, memoryBuffer.length())
    } finally {
      tlReusableBuffer.reset()
    }
  }

  final def apply(request: Array[Byte]): Future[Array[Byte]] = {
    val inputTransport = new TMemoryInputTransport(request)
    val iprot = protocolFactory.getProtocol(inputTransport)

    try {
      val msg = iprot.readMessageBegin()
      val service = serviceMap.get(msg.name)
      service match {
        case _root_.scala.Some(svc) =>
          svc(iprot, msg.seqid)
        case _ =>
          TProtocolUtil.skip(iprot, TType.STRUCT)
          Future.value(Buf.ByteArray.Owned.extract(
            exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
              "Invalid method name: '" + msg.name + "'")))
      }
    } catch {
      case e: Exception => Future.exception(e)
    }
  }

  private object ThriftMethodStats {
    def apply(stats: StatsReceiver): ThriftMethodStats =
      ThriftMethodStats(
        stats.counter("requests"),
        stats.counter("success"),
        stats.counter("failures"),
        stats.scope("failures")
      )
  }

  private case class ThriftMethodStats(
    requestsCounter: Counter,
    successCounter: Counter,
    failuresCounter: Counter,
    failuresScope: StatsReceiver
  )

  private def missingResult(name: String): TApplicationException = {
    new TApplicationException(
      TApplicationException.MISSING_RESULT,
      name + " failed: unknown result"
    )
  }

  private def setServiceName(ex: Throwable): Throwable =
    if (this.serviceName == "") ex
    else {
      ex match {
        case se: SourcedException =>
          se.serviceName = this.serviceName
          se
        case _ => ex
      }
    }

  private def recordResponse(reqRep: ctfs.ReqRep, methodStats: ThriftMethodStats): Unit = {
    val responseClass = responseClassifier.applyOrElse(reqRep, ctfs.ResponseClassifier.Default)
    responseClass match {
      case ctfs.ResponseClass.Successful(_) =>
        methodStats.successCounter.incr()
      case ctfs.ResponseClass.Failed(_) =>
        methodStats.failuresCounter.incr()
        reqRep.response match {
          case Throw(ex) =>
            methodStats.failuresScope.counter(Throwables.mkString(ex): _*).incr()
          case _ =>
        }
    }
  }

  final protected def perMethodStatsFilter(
    method: ThriftMethod
  ): finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] = {
    val methodStats = ThriftMethodStats((if (serviceName != "") stats.scope(serviceName) else stats).scope(method.name))
    new finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[method.Args, method.Result]] {
      def apply(
        req: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[method.Args, method.Result]]
      ): Future[Array[Byte]] = {
        methodStats.requestsCounter.incr()
        service(req).transform {
          case Return(value) =>
            value match {
              case SuccessfulResponse(req, _, result) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Return(result.successField.get)), methodStats)
              case ProtocolExceptionResponse(req, _, exp) =>
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(exp)), methodStats)
              case ThriftExceptionResponse(req, _, ex) =>
                val rep = ex match {
                  case exp: ThriftException => setServiceName(exp)
                  case _ => missingResult(serviceName)
                }
                recordResponse(ctfs.ReqRep(req, _root_.com.twitter.util.Throw(rep)), methodStats)
            }
            Future.value(Buf.ByteArray.Owned.extract(value.response))
          case t @ Throw(_) =>
            recordResponse(ctfs.ReqRep(req, t), methodStats)
            Future.const(t.cast[Array[Byte]])
        }
      }
    }
  }
  // ---- end boilerplate.

  addService("ping", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[Ping.Args, Ping.Result]] = perMethodStatsFilter(Ping)
  
    val methodService = new finagle$Service[Ping.Args, Ping.SuccessType] {
      def apply(args: Ping.Args): Future[Ping.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("ping")
        }
        iface.ping()
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[Ping.Args, Ping.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[Ping.Args, Ping.Result]]
      ): Future[RichResponse[Ping.Args, Ping.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("ping", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[Ping.Args, Ping.Result], Ping.Args, Ping.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[Ping.Args, Ping.SuccessType]
      ): Future[RichResponse[Ping.Args, Ping.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = Ping.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = Ping.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("ping", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[Ping.Args, Ping.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("checkSession", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[CheckSession.Args, CheckSession.Result]] = perMethodStatsFilter(CheckSession)
  
    val methodService = new finagle$Service[CheckSession.Args, CheckSession.SuccessType] {
      def apply(args: CheckSession.Args): Future[CheckSession.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("checkSession")
        }
        iface.checkSession(args.sessionId)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[CheckSession.Args, CheckSession.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[CheckSession.Args, CheckSession.Result]]
      ): Future[RichResponse[CheckSession.Args, CheckSession.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("checkSession", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[CheckSession.Args, CheckSession.Result], CheckSession.Args, CheckSession.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[CheckSession.Args, CheckSession.SuccessType]
      ): Future[RichResponse[CheckSession.Args, CheckSession.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = CheckSession.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = CheckSession.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("checkSession", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[CheckSession.Args, CheckSession.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getUserProfileBySessionID", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]] = perMethodStatsFilter(GetUserProfileBySessionID)
  
    val methodService = new finagle$Service[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.SuccessType] {
      def apply(args: GetUserProfileBySessionID.Args): Future[GetUserProfileBySessionID.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getUserProfileBySessionID")
        }
        iface.getUserProfileBySessionID(args.sessionId)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]]
      ): Future[RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getUserProfileBySessionID", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result], GetUserProfileBySessionID.Args, GetUserProfileBySessionID.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.SuccessType]
      ): Future[RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetUserProfileBySessionID.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetUserProfileBySessionID.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getUserProfileBySessionID", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetUserProfileBySessionID.Args, GetUserProfileBySessionID.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getUserProfileByUsername", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]] = perMethodStatsFilter(GetUserProfileByUsername)
  
    val methodService = new finagle$Service[GetUserProfileByUsername.Args, GetUserProfileByUsername.SuccessType] {
      def apply(args: GetUserProfileByUsername.Args): Future[GetUserProfileByUsername.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getUserProfileByUsername")
        }
        iface.getUserProfileByUsername(args.username)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]]
      ): Future[RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getUserProfileByUsername", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result], GetUserProfileByUsername.Args, GetUserProfileByUsername.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetUserProfileByUsername.Args, GetUserProfileByUsername.SuccessType]
      ): Future[RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetUserProfileByUsername.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetUserProfileByUsername.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getUserProfileByUsername", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetUserProfileByUsername.Args, GetUserProfileByUsername.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getUserProfile", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetUserProfile.Args, GetUserProfile.Result]] = perMethodStatsFilter(GetUserProfile)
  
    val methodService = new finagle$Service[GetUserProfile.Args, GetUserProfile.SuccessType] {
      def apply(args: GetUserProfile.Args): Future[GetUserProfile.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getUserProfile")
        }
        iface.getUserProfile(args.username)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetUserProfile.Args, GetUserProfile.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetUserProfile.Args, GetUserProfile.Result]]
      ): Future[RichResponse[GetUserProfile.Args, GetUserProfile.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getUserProfile", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetUserProfile.Args, GetUserProfile.Result], GetUserProfile.Args, GetUserProfile.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetUserProfile.Args, GetUserProfile.SuccessType]
      ): Future[RichResponse[GetUserProfile.Args, GetUserProfile.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetUserProfile.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetUserProfile.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getUserProfile", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetUserProfile.Args, GetUserProfile.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getProfileByEmail", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]] = perMethodStatsFilter(GetProfileByEmail)
  
    val methodService = new finagle$Service[GetProfileByEmail.Args, GetProfileByEmail.SuccessType] {
      def apply(args: GetProfileByEmail.Args): Future[GetProfileByEmail.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getProfileByEmail")
        }
        iface.getProfileByEmail(args.email)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]]
      ): Future[RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getProfileByEmail", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result], GetProfileByEmail.Args, GetProfileByEmail.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetProfileByEmail.Args, GetProfileByEmail.SuccessType]
      ): Future[RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetProfileByEmail.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetProfileByEmail.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getProfileByEmail", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetProfileByEmail.Args, GetProfileByEmail.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("multiGetUserProfiles", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]] = perMethodStatsFilter(MultiGetUserProfiles)
  
    val methodService = new finagle$Service[MultiGetUserProfiles.Args, MultiGetUserProfiles.SuccessType] {
      def apply(args: MultiGetUserProfiles.Args): Future[MultiGetUserProfiles.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("multiGetUserProfiles")
        }
        iface.multiGetUserProfiles(args.usernames)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]]
      ): Future[RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("multiGetUserProfiles", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result], MultiGetUserProfiles.Args, MultiGetUserProfiles.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[MultiGetUserProfiles.Args, MultiGetUserProfiles.SuccessType]
      ): Future[RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = MultiGetUserProfiles.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = MultiGetUserProfiles.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("multiGetUserProfiles", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[MultiGetUserProfiles.Args, MultiGetUserProfiles.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
  addService("getUserProfiles", {
    val statsFilter: finagle$Filter[(TProtocol, Int), Array[Byte], (TProtocol, Int), RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]] = perMethodStatsFilter(GetUserProfiles)
  
    val methodService = new finagle$Service[GetUserProfiles.Args, GetUserProfiles.SuccessType] {
      def apply(args: GetUserProfiles.Args): Future[GetUserProfiles.SuccessType] = {
        if (_root_.com.twitter.finagle.tracing.Trace.isActivelyTracing) {
          _root_.com.twitter.finagle.tracing.Trace.recordRpc("getUserProfiles")
        }
        iface.getUserProfiles(args.from, args.size)
      }
    }
  
    val protocolExnFilter = new SimpleFilter[(TProtocol, Int), RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[(TProtocol, Int), RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]]
      ): Future[RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val res = service(request)
        res.transform {
          case _root_.com.twitter.util.Throw(e: TProtocolException) =>
            iprot.readMessageEnd()
            Future.value(
              ProtocolExceptionResponse(
                null,
                exception("getUserProfiles", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage),
                new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage)))
          case _ =>
            res
        }
      }
    }
  
    val serdeFilter = new finagle$Filter[(TProtocol, Int), RichResponse[GetUserProfiles.Args, GetUserProfiles.Result], GetUserProfiles.Args, GetUserProfiles.SuccessType] {
      def apply(
        request: (TProtocol, Int),
        service: finagle$Service[GetUserProfiles.Args, GetUserProfiles.SuccessType]
      ): Future[RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]] = {
        val iprot = request._1
        val seqid = request._2
        val args = GetUserProfiles.Args.decode(iprot)
        iprot.readMessageEnd()
        val res = service(args)
        res.transform {
          case _root_.com.twitter.util.Return(value) =>
            val methodResult = GetUserProfiles.Result(success = Some(value))
            Future.value(
              SuccessfulResponse(
                args,
                reply("getUserProfiles", seqid, methodResult),
                methodResult))
          case t @ _root_.com.twitter.util.Throw(_) =>
            Future.const(t.cast[RichResponse[GetUserProfiles.Args, GetUserProfiles.Result]])
        }
      }
    }
  
    statsFilter.andThen(protocolExnFilter).andThen(serdeFilter).andThen(methodService)
  })
}
