/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144307
 */
package xed.api_service.domain.thrift

import com.twitter.io.Buf
import com.twitter.scrooge.{
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport, TIOStreamTransport}
import java.io.ByteArrayInputStream
import java.nio.ByteBuffer
import java.util.Arrays
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object TCard extends ValidatingThriftStructCodec3[TCard] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("TCard")
  val IdField = new TField("id", TType.STRING, 1)
  val IdFieldManifest = implicitly[Manifest[String]]
  val DeckIdField = new TField("deckId", TType.STRING, 2)
  val DeckIdFieldManifest = implicitly[Manifest[String]]
  val UsernameField = new TField("username", TType.STRING, 3)
  val UsernameFieldManifest = implicitly[Manifest[String]]
  val CardVersionField = new TField("cardVersion", TType.I32, 4)
  val CardVersionFieldManifest = implicitly[Manifest[Int]]
  val DesignField = new TField("design", TType.STRING, 5)
  val DesignFieldManifest = implicitly[Manifest[String]]
  val UpdatedTimeField = new TField("updatedTime", TType.I64, 6)
  val UpdatedTimeFieldManifest = implicitly[Manifest[Long]]
  val CreatedTimeField = new TField("createdTime", TType.I64, 7)
  val CreatedTimeFieldManifest = implicitly[Manifest[Long]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      IdField,
      false,
      true,
      IdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      DeckIdField,
      true,
      false,
      DeckIdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UsernameField,
      true,
      false,
      UsernameFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      CardVersionField,
      true,
      false,
      CardVersionFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      DesignField,
      true,
      false,
      DesignFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UpdatedTimeField,
      true,
      false,
      UpdatedTimeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      CreatedTimeField,
      true,
      false,
      CreatedTimeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: TCard): Unit = {
    if (_item.id == null) throw new TProtocolException("Required field id cannot be null")
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TCard): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    if (item.id == null)
      buf += com.twitter.scrooge.validation.MissingRequiredField(fieldInfos.apply(0))
    buf ++= validateField(item.id)
    buf ++= validateField(item.deckId)
    buf ++= validateField(item.username)
    buf ++= validateField(item.cardVersion)
    buf ++= validateField(item.design)
    buf ++= validateField(item.updatedTime)
    buf ++= validateField(item.createdTime)
    buf.toList
  }

  def withoutPassthroughFields(original: TCard): TCard =
    new Immutable(
      id =
        {
          val field = original.id
          field
        },
      deckId =
        {
          val field = original.deckId
          field.map { field =>
            field
          }
        },
      username =
        {
          val field = original.username
          field.map { field =>
            field
          }
        },
      cardVersion =
        {
          val field = original.cardVersion
          field.map { field =>
            field
          }
        },
      design =
        {
          val field = original.design
          field.map { field =>
            field
          }
        },
      updatedTime =
        {
          val field = original.updatedTime
          field.map { field =>
            field
          }
        },
      createdTime =
        {
          val field = original.createdTime
          field.map { field =>
            field
          }
        }
    )

  override def encode(_item: TCard, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TCard = {

    var idOffset: Int = -1
    var _got_id = false
    var deckIdOffset: Int = -1
    var usernameOffset: Int = -1
    var cardVersionOffset: Int = -1
    var designOffset: Int = -1
    var updatedTimeOffset: Int = -1
    var createdTimeOffset: Int = -1

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                idOffset = _iprot.offsetSkipString
    
                _got_id = true
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                deckIdOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'deckId' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                usernameOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'username' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.I32 =>
                cardVersionOffset = _iprot.offsetSkipI32
    
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'cardVersion' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
            _field.`type` match {
              case TType.STRING =>
                designOffset = _iprot.offsetSkipString
    
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'design' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 6 =>
            _field.`type` match {
              case TType.I64 =>
                updatedTimeOffset = _iprot.offsetSkipI64
    
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'updatedTime' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 7 =>
            _field.`type` match {
              case TType.I64 =>
                createdTimeOffset = _iprot.offsetSkipI64
    
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'createdTime' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_id) throw new TProtocolException("Required field 'id' was not found in serialized data for struct TCard")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      idOffset,
      deckIdOffset,
      usernameOffset,
      cardVersionOffset,
      designOffset,
      updatedTimeOffset,
      createdTimeOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TCard =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TCard = {
    var id: String = null
    var _got_id = false
    var deckId: _root_.scala.Option[String] = _root_.scala.None
    var username: _root_.scala.Option[String] = _root_.scala.None
    var cardVersion: _root_.scala.Option[Int] = _root_.scala.None
    var design: _root_.scala.Option[String] = _root_.scala.None
    var updatedTime: _root_.scala.Option[Long] = _root_.scala.None
    var createdTime: _root_.scala.Option[Long] = _root_.scala.None
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.STRING =>
                id = readIdValue(_iprot)
                _got_id = true
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'id' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRING =>
                deckId = _root_.scala.Some(readDeckIdValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'deckId' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRING =>
                username = _root_.scala.Some(readUsernameValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'username' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 4 =>
            _field.`type` match {
              case TType.I32 =>
                cardVersion = _root_.scala.Some(readCardVersionValue(_iprot))
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'cardVersion' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 5 =>
            _field.`type` match {
              case TType.STRING =>
                design = _root_.scala.Some(readDesignValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRING
                throw new TProtocolException(
                  "Received wrong type for field 'design' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 6 =>
            _field.`type` match {
              case TType.I64 =>
                updatedTime = _root_.scala.Some(readUpdatedTimeValue(_iprot))
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'updatedTime' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 7 =>
            _field.`type` match {
              case TType.I64 =>
                createdTime = _root_.scala.Some(readCreatedTimeValue(_iprot))
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'createdTime' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    if (!_got_id) throw new TProtocolException("Required field 'id' was not found in serialized data for struct TCard")
    new Immutable(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    id: String,
    deckId: _root_.scala.Option[String] = _root_.scala.None,
    username: _root_.scala.Option[String] = _root_.scala.None,
    cardVersion: _root_.scala.Option[Int] = _root_.scala.None,
    design: _root_.scala.Option[String] = _root_.scala.None,
    updatedTime: _root_.scala.Option[Long] = _root_.scala.None,
    createdTime: _root_.scala.Option[Long] = _root_.scala.None
  ): TCard =
    new Immutable(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime
    )

  def unapply(_item: TCard): _root_.scala.Option[_root_.scala.Tuple7[String, Option[String], Option[String], Option[Int], Option[String], Option[Long], Option[Long]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thrift] def readIdValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeIdField(id_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(IdField)
    writeIdValue(id_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeIdValue(id_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(id_item)
  }

  @inline private[thrift] def readDeckIdValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeDeckIdField(deckId_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(DeckIdField)
    writeDeckIdValue(deckId_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeDeckIdValue(deckId_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(deckId_item)
  }

  @inline private[thrift] def readUsernameValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeUsernameField(username_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UsernameField)
    writeUsernameValue(username_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUsernameValue(username_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(username_item)
  }

  @inline private[thrift] def readCardVersionValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeCardVersionField(cardVersion_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(CardVersionField)
    writeCardVersionValue(cardVersion_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeCardVersionValue(cardVersion_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(cardVersion_item)
  }

  @inline private[thrift] def readDesignValue(_iprot: TProtocol): String = {
    _iprot.readString()
  }

  @inline private def writeDesignField(design_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(DesignField)
    writeDesignValue(design_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeDesignValue(design_item: String, _oprot: TProtocol): Unit = {
    _oprot.writeString(design_item)
  }

  @inline private[thrift] def readUpdatedTimeValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeUpdatedTimeField(updatedTime_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UpdatedTimeField)
    writeUpdatedTimeValue(updatedTime_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUpdatedTimeValue(updatedTime_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(updatedTime_item)
  }

  @inline private[thrift] def readCreatedTimeValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeCreatedTimeField(createdTime_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(CreatedTimeField)
    writeCreatedTimeValue(createdTime_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeCreatedTimeValue(createdTime_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(createdTime_item)
  }


  object Immutable extends ThriftStructCodec3[TCard] {
    override def encode(_item: TCard, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TCard = TCard.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TCard] = TCard.metaData
  }

  /**
   * The default read-only implementation of TCard.  You typically should not need to
   * directly reference this class; instead, use the TCard.apply method to construct
   * new instances.
   */
  class Immutable(
      val id: String,
      val deckId: _root_.scala.Option[String],
      val username: _root_.scala.Option[String],
      val cardVersion: _root_.scala.Option[Int],
      val design: _root_.scala.Option[String],
      val updatedTime: _root_.scala.Option[Long],
      val createdTime: _root_.scala.Option[Long],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TCard {
    def this(
      id: String,
      deckId: _root_.scala.Option[String] = _root_.scala.None,
      username: _root_.scala.Option[String] = _root_.scala.None,
      cardVersion: _root_.scala.Option[Int] = _root_.scala.None,
      design: _root_.scala.Option[String] = _root_.scala.None,
      updatedTime: _root_.scala.Option[Long] = _root_.scala.None,
      createdTime: _root_.scala.Option[Long] = _root_.scala.None
    ) = this(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime,
      Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      idOffset: Int,
      deckIdOffset: Int,
      usernameOffset: Int,
      cardVersionOffset: Int,
      designOffset: Int,
      updatedTimeOffset: Int,
      createdTimeOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TCard {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val id: String =
      if (idOffset == -1)
        null
      else {
        _proto.decodeString(_buf, idOffset)
      }
    lazy val deckId: _root_.scala.Option[String] =
      if (deckIdOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, deckIdOffset))
      }
    lazy val username: _root_.scala.Option[String] =
      if (usernameOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, usernameOffset))
      }
    lazy val cardVersion: _root_.scala.Option[Int] =
      if (cardVersionOffset == -1)
        None
      else {
        Some(_proto.decodeI32(_buf, cardVersionOffset))
      }
    lazy val design: _root_.scala.Option[String] =
      if (designOffset == -1)
        None
      else {
        Some(_proto.decodeString(_buf, designOffset))
      }
    lazy val updatedTime: _root_.scala.Option[Long] =
      if (updatedTimeOffset == -1)
        None
      else {
        Some(_proto.decodeI64(_buf, updatedTimeOffset))
      }
    lazy val createdTime: _root_.scala.Option[Long] =
      if (createdTimeOffset == -1)
        None
      else {
        Some(_proto.decodeI64(_buf, createdTimeOffset))
      }

    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode = super.hashCode
  }

  /**
   * This Proxy trait allows you to extend the TCard trait with additional state or
   * behavior and implement the read-only methods from TCard using an underlying
   * instance.
   */
  trait Proxy extends TCard {
    protected def _underlying_TCard: TCard
    override def id: String = _underlying_TCard.id
    override def deckId: _root_.scala.Option[String] = _underlying_TCard.deckId
    override def username: _root_.scala.Option[String] = _underlying_TCard.username
    override def cardVersion: _root_.scala.Option[Int] = _underlying_TCard.cardVersion
    override def design: _root_.scala.Option[String] = _underlying_TCard.design
    override def updatedTime: _root_.scala.Option[Long] = _underlying_TCard.updatedTime
    override def createdTime: _root_.scala.Option[Long] = _underlying_TCard.createdTime
    override def _passthroughFields = _underlying_TCard._passthroughFields
  }
}

/**
 * Prefer the companion object's [[xed.api_service.domain.thrift.TCard.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TCard
  extends ThriftStruct
  with _root_.scala.Product7[String, Option[String], Option[String], Option[Int], Option[String], Option[Long], Option[Long]]
  with ValidatingThriftStruct[TCard]
  with java.io.Serializable
{
  import TCard._

  def id: String
  def deckId: _root_.scala.Option[String]
  def username: _root_.scala.Option[String]
  def cardVersion: _root_.scala.Option[Int]
  def design: _root_.scala.Option[String]
  def updatedTime: _root_.scala.Option[Long]
  def createdTime: _root_.scala.Option[Long]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = id
  def _2 = deckId
  def _3 = username
  def _4 = cardVersion
  def _5 = design
  def _6 = updatedTime
  def _7 = createdTime

  def toTuple: _root_.scala.Tuple7[String, Option[String], Option[String], Option[Int], Option[String], Option[Long], Option[Long]] = {
    (
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime
    )
  }


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (id ne null) {
                writeIdValue(id, _oprot)
                _root_.scala.Some(TCard.IdField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (deckId.isDefined) {
                writeDeckIdValue(deckId.get, _oprot)
                _root_.scala.Some(TCard.DeckIdField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (username.isDefined) {
                writeUsernameValue(username.get, _oprot)
                _root_.scala.Some(TCard.UsernameField)
              } else {
                _root_.scala.None
              }
            case 4 =>
              if (cardVersion.isDefined) {
                writeCardVersionValue(cardVersion.get, _oprot)
                _root_.scala.Some(TCard.CardVersionField)
              } else {
                _root_.scala.None
              }
            case 5 =>
              if (design.isDefined) {
                writeDesignValue(design.get, _oprot)
                _root_.scala.Some(TCard.DesignField)
              } else {
                _root_.scala.None
              }
            case 6 =>
              if (updatedTime.isDefined) {
                writeUpdatedTimeValue(updatedTime.get, _oprot)
                _root_.scala.Some(TCard.UpdatedTimeField)
              } else {
                _root_.scala.None
              }
            case 7 =>
              if (createdTime.isDefined) {
                writeCreatedTimeValue(createdTime.get, _oprot)
                _root_.scala.Some(TCard.CreatedTimeField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            _root_.scala.Some(TFieldBlob(_field, Buf.ByteArray.Owned(_buff.getArray())))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): TCard = {
    var id: String = this.id
    var deckId: _root_.scala.Option[String] = this.deckId
    var username: _root_.scala.Option[String] = this.username
    var cardVersion: _root_.scala.Option[Int] = this.cardVersion
    var design: _root_.scala.Option[String] = this.design
    var updatedTime: _root_.scala.Option[Long] = this.updatedTime
    var createdTime: _root_.scala.Option[Long] = this.createdTime
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        id = readIdValue(_blob.read)
      case 2 =>
        deckId = _root_.scala.Some(readDeckIdValue(_blob.read))
      case 3 =>
        username = _root_.scala.Some(readUsernameValue(_blob.read))
      case 4 =>
        cardVersion = _root_.scala.Some(readCardVersionValue(_blob.read))
      case 5 =>
        design = _root_.scala.Some(readDesignValue(_blob.read))
      case 6 =>
        updatedTime = _root_.scala.Some(readUpdatedTimeValue(_blob.read))
      case 7 =>
        createdTime = _root_.scala.Some(readCreatedTimeValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TCard = {
    var id: String = this.id
    var deckId: _root_.scala.Option[String] = this.deckId
    var username: _root_.scala.Option[String] = this.username
    var cardVersion: _root_.scala.Option[Int] = this.cardVersion
    var design: _root_.scala.Option[String] = this.design
    var updatedTime: _root_.scala.Option[Long] = this.updatedTime
    var createdTime: _root_.scala.Option[Long] = this.createdTime

    _fieldId match {
      case 1 =>
        id = null
      case 2 =>
        deckId = _root_.scala.None
      case 3 =>
        username = _root_.scala.None
      case 4 =>
        cardVersion = _root_.scala.None
      case 5 =>
        design = _root_.scala.None
      case 6 =>
        updatedTime = _root_.scala.None
      case 7 =>
        createdTime = _root_.scala.None
      case _ =>
    }
    new Immutable(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetId: TCard = unsetField(1)

  def unsetDeckId: TCard = unsetField(2)

  def unsetUsername: TCard = unsetField(3)

  def unsetCardVersion: TCard = unsetField(4)

  def unsetDesign: TCard = unsetField(5)

  def unsetUpdatedTime: TCard = unsetField(6)

  def unsetCreatedTime: TCard = unsetField(7)


  override def write(_oprot: TProtocol): Unit = {
    TCard.validate(this)
    _oprot.writeStructBegin(Struct)
    if (id ne null) writeIdField(id, _oprot)
    if (deckId.isDefined) writeDeckIdField(deckId.get, _oprot)
    if (username.isDefined) writeUsernameField(username.get, _oprot)
    if (cardVersion.isDefined) writeCardVersionField(cardVersion.get, _oprot)
    if (design.isDefined) writeDesignField(design.get, _oprot)
    if (updatedTime.isDefined) writeUpdatedTimeField(updatedTime.get, _oprot)
    if (createdTime.isDefined) writeCreatedTimeField(createdTime.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    id: String = this.id,
    deckId: _root_.scala.Option[String] = this.deckId,
    username: _root_.scala.Option[String] = this.username,
    cardVersion: _root_.scala.Option[Int] = this.cardVersion,
    design: _root_.scala.Option[String] = this.design,
    updatedTime: _root_.scala.Option[Long] = this.updatedTime,
    createdTime: _root_.scala.Option[Long] = this.createdTime,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TCard =
    new Immutable(
      id,
      deckId,
      username,
      cardVersion,
      design,
      updatedTime,
      createdTime,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TCard]

  private def _equals(x: TCard, y: TCard): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TCard]) &&
      _passthroughFields == other.asInstanceOf[TCard]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 7

  override def productElement(n: Int): Any = n match {
    case 0 => this.id
    case 1 => this.deckId
    case 2 => this.username
    case 3 => this.cardVersion
    case 4 => this.design
    case 5 => this.updatedTime
    case 6 => this.createdTime
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TCard"

  def _codec: ValidatingThriftStructCodec3[TCard] = TCard
}

