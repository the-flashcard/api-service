/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144307
 */
package xed.userprofile.domain.thrift

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


object TMultiUserProfileResp extends ValidatingThriftStructCodec3[TMultiUserProfileResp] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("TMultiUserProfileResp")
  val TotalField = new TField("total", TType.I64, 1)
  val TotalFieldManifest = implicitly[Manifest[Long]]
  val UserProfilesField = new TField("userProfiles", TType.MAP, 2)
  val UserProfilesFieldManifest = implicitly[Manifest[Map[String, xed.userprofile.domain.thrift.TUserProfile]]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      TotalField,
      false,
      true,
      TotalFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UserProfilesField,
      true,
      false,
      UserProfilesFieldManifest,
      _root_.scala.Some(implicitly[Manifest[String]]),
      _root_.scala.Some(implicitly[Manifest[xed.userprofile.domain.thrift.TUserProfile]]),
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
  def validate(_item: TMultiUserProfileResp): Unit = {
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TMultiUserProfileResp): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    buf ++= validateField(item.total)
    buf ++= validateField(item.userProfiles)
    buf.toList
  }

  def withoutPassthroughFields(original: TMultiUserProfileResp): TMultiUserProfileResp =
    new Immutable(
      total =
        {
          val field = original.total
          field
        },
      userProfiles =
        {
          val field = original.userProfiles
          field.map { field =>
            field.map { case (key, value) =>
                val newKey = {
                val field = key
                field
              }
  
  
                val newValue = {
                val field = value
                xed.userprofile.domain.thrift.TUserProfile.withoutPassthroughFields(field)
              }
  
  
              newKey -> newValue
            }
          }
        }
    )

  override def encode(_item: TMultiUserProfileResp, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TMultiUserProfileResp = {

    var total: Long = 0L
    var _got_total = false
    var userProfiles: Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = None

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
              case TType.I64 =>
    
                total = readTotalValue(_iprot)
                _got_total = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'total' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.MAP =>
    
                userProfiles = Some(readUserProfilesValue(_iprot))
              case _actualType =>
                val _expectedType = TType.MAP
                throw new TProtocolException(
                  "Received wrong type for field 'userProfiles' (expected=%s, actual=%s).".format(
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

    if (!_got_total) throw new TProtocolException("Required field 'total' was not found in serialized data for struct TMultiUserProfileResp")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      total,
      userProfiles,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TMultiUserProfileResp =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TMultiUserProfileResp = {
    var total: Long = 0L
    var _got_total = false
    var userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = _root_.scala.None
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
              case TType.I64 =>
                total = readTotalValue(_iprot)
                _got_total = true
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'total' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.MAP =>
                userProfiles = _root_.scala.Some(readUserProfilesValue(_iprot))
              case _actualType =>
                val _expectedType = TType.MAP
                throw new TProtocolException(
                  "Received wrong type for field 'userProfiles' (expected=%s, actual=%s).".format(
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

    if (!_got_total) throw new TProtocolException("Required field 'total' was not found in serialized data for struct TMultiUserProfileResp")
    new Immutable(
      total,
      userProfiles,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    total: Long,
    userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = _root_.scala.None
  ): TMultiUserProfileResp =
    new Immutable(
      total,
      userProfiles
    )

  def unapply(_item: TMultiUserProfileResp): _root_.scala.Option[_root_.scala.Tuple2[Long, Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thrift] def readTotalValue(_iprot: TProtocol): Long = {
    _iprot.readI64()
  }

  @inline private def writeTotalField(total_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(TotalField)
    writeTotalValue(total_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeTotalValue(total_item: Long, _oprot: TProtocol): Unit = {
    _oprot.writeI64(total_item)
  }

  @inline private[thrift] def readUserProfilesValue(_iprot: TProtocol): Map[String, xed.userprofile.domain.thrift.TUserProfile] = {
    val _map = _iprot.readMapBegin()
    if (_map.size == 0) {
      _iprot.readMapEnd()
      Map.empty[String, xed.userprofile.domain.thrift.TUserProfile]
    } else {
      val _rv = new mutable$HashMap[String, xed.userprofile.domain.thrift.TUserProfile]
      var _i = 0
      while (_i < _map.size) {
        val _key = {
          _iprot.readString()
        }
        val _value = {
          xed.userprofile.domain.thrift.TUserProfile.decode(_iprot)
        }
        _rv(_key) = _value
        _i += 1
      }
      _iprot.readMapEnd()
      _rv
    }
  }

  @inline private def writeUserProfilesField(userProfiles_item: Map[String, xed.userprofile.domain.thrift.TUserProfile], _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UserProfilesField)
    writeUserProfilesValue(userProfiles_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUserProfilesValue(userProfiles_item: Map[String, xed.userprofile.domain.thrift.TUserProfile], _oprot: TProtocol): Unit = {
    _oprot.writeMapBegin(new TMap(TType.STRING, TType.STRUCT, userProfiles_item.size))
    userProfiles_item.foreach { case (userProfiles_item_key, userProfiles_item_value) =>
      _oprot.writeString(userProfiles_item_key)
      userProfiles_item_value.write(_oprot)
    }
    _oprot.writeMapEnd()
  }


  object Immutable extends ThriftStructCodec3[TMultiUserProfileResp] {
    override def encode(_item: TMultiUserProfileResp, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TMultiUserProfileResp = TMultiUserProfileResp.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TMultiUserProfileResp] = TMultiUserProfileResp.metaData
  }

  /**
   * The default read-only implementation of TMultiUserProfileResp.  You typically should not need to
   * directly reference this class; instead, use the TMultiUserProfileResp.apply method to construct
   * new instances.
   */
  class Immutable(
      val total: Long,
      val userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TMultiUserProfileResp {
    def this(
      total: Long,
      userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = _root_.scala.None
    ) = this(
      total,
      userProfiles,
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
      val total: Long,
      val userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TMultiUserProfileResp {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
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
   * This Proxy trait allows you to extend the TMultiUserProfileResp trait with additional state or
   * behavior and implement the read-only methods from TMultiUserProfileResp using an underlying
   * instance.
   */
  trait Proxy extends TMultiUserProfileResp {
    protected def _underlying_TMultiUserProfileResp: TMultiUserProfileResp
    override def total: Long = _underlying_TMultiUserProfileResp.total
    override def userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = _underlying_TMultiUserProfileResp.userProfiles
    override def _passthroughFields = _underlying_TMultiUserProfileResp._passthroughFields
  }
}

/**
 * Prefer the companion object's [[xed.userprofile.domain.thrift.TMultiUserProfileResp.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TMultiUserProfileResp
  extends ThriftStruct
  with _root_.scala.Product2[Long, Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]]]
  with ValidatingThriftStruct[TMultiUserProfileResp]
  with java.io.Serializable
{
  import TMultiUserProfileResp._

  def total: Long
  def userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = total
  def _2 = userProfiles

  def toTuple: _root_.scala.Tuple2[Long, Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]]] = {
    (
      total,
      userProfiles
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
              if (true) {
                writeTotalValue(total, _oprot)
                _root_.scala.Some(TMultiUserProfileResp.TotalField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (userProfiles.isDefined) {
                writeUserProfilesValue(userProfiles.get, _oprot)
                _root_.scala.Some(TMultiUserProfileResp.UserProfilesField)
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
  def setField(_blob: TFieldBlob): TMultiUserProfileResp = {
    var total: Long = this.total
    var userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = this.userProfiles
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        total = readTotalValue(_blob.read)
      case 2 =>
        userProfiles = _root_.scala.Some(readUserProfilesValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      total,
      userProfiles,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TMultiUserProfileResp = {
    var total: Long = this.total
    var userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = this.userProfiles

    _fieldId match {
      case 1 =>
        total = 0L
      case 2 =>
        userProfiles = _root_.scala.None
      case _ =>
    }
    new Immutable(
      total,
      userProfiles,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetTotal: TMultiUserProfileResp = unsetField(1)

  def unsetUserProfiles: TMultiUserProfileResp = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    TMultiUserProfileResp.validate(this)
    _oprot.writeStructBegin(Struct)
    writeTotalField(total, _oprot)
    if (userProfiles.isDefined) writeUserProfilesField(userProfiles.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    total: Long = this.total,
    userProfiles: _root_.scala.Option[Map[String, xed.userprofile.domain.thrift.TUserProfile]] = this.userProfiles,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TMultiUserProfileResp =
    new Immutable(
      total,
      userProfiles,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TMultiUserProfileResp]

  private def _equals(x: TMultiUserProfileResp, y: TMultiUserProfileResp): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TMultiUserProfileResp]) &&
      _passthroughFields == other.asInstanceOf[TMultiUserProfileResp]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 2

  override def productElement(n: Int): Any = n match {
    case 0 => this.total
    case 1 => this.userProfiles
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TMultiUserProfileResp"

  def _codec: ValidatingThriftStructCodec3[TMultiUserProfileResp] = TMultiUserProfileResp
}
