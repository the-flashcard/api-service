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


object TFullUserInfoResp extends ValidatingThriftStructCodec3[TFullUserInfoResp] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("TFullUserInfoResp")
  val ExistField = new TField("exist", TType.BOOL, 1)
  val ExistFieldManifest = implicitly[Manifest[Boolean]]
  val UserInfoField = new TField("userInfo", TType.STRUCT, 2)
  val UserInfoFieldManifest = implicitly[Manifest[xed.userprofile.domain.thrift.TUserInfo]]
  val UserProfileField = new TField("userProfile", TType.STRUCT, 3)
  val UserProfileFieldManifest = implicitly[Manifest[xed.userprofile.domain.thrift.TUserProfile]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      ExistField,
      false,
      true,
      ExistFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UserInfoField,
      true,
      false,
      UserInfoFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      UserProfileField,
      true,
      false,
      UserProfileFieldManifest,
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
  def validate(_item: TFullUserInfoResp): Unit = {
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TFullUserInfoResp): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    buf ++= validateField(item.exist)
    buf ++= validateField(item.userInfo)
    buf ++= validateField(item.userProfile)
    buf.toList
  }

  def withoutPassthroughFields(original: TFullUserInfoResp): TFullUserInfoResp =
    new Immutable(
      exist =
        {
          val field = original.exist
          field
        },
      userInfo =
        {
          val field = original.userInfo
          field.map { field =>
            xed.userprofile.domain.thrift.TUserInfo.withoutPassthroughFields(field)
          }
        },
      userProfile =
        {
          val field = original.userProfile
          field.map { field =>
            xed.userprofile.domain.thrift.TUserProfile.withoutPassthroughFields(field)
          }
        }
    )

  override def encode(_item: TFullUserInfoResp, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TFullUserInfoResp = {

    var exist: Boolean = false
    var _got_exist = false
    var userInfo: Option[xed.userprofile.domain.thrift.TUserInfo] = None
    var userProfile: Option[xed.userprofile.domain.thrift.TUserProfile] = None

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
              case TType.BOOL =>
    
                exist = readExistValue(_iprot)
                _got_exist = true
              case _actualType =>
                val _expectedType = TType.BOOL
                throw new TProtocolException(
                  "Received wrong type for field 'exist' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                userInfo = Some(readUserInfoValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'userInfo' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
    
                userProfile = Some(readUserProfileValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'userProfile' (expected=%s, actual=%s).".format(
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

    if (!_got_exist) throw new TProtocolException("Required field 'exist' was not found in serialized data for struct TFullUserInfoResp")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      exist,
      userInfo,
      userProfile,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TFullUserInfoResp =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TFullUserInfoResp = {
    var exist: Boolean = false
    var _got_exist = false
    var userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = _root_.scala.None
    var userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = _root_.scala.None
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
              case TType.BOOL =>
                exist = readExistValue(_iprot)
                _got_exist = true
              case _actualType =>
                val _expectedType = TType.BOOL
                throw new TProtocolException(
                  "Received wrong type for field 'exist' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.STRUCT =>
                userInfo = _root_.scala.Some(readUserInfoValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'userInfo' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.STRUCT =>
                userProfile = _root_.scala.Some(readUserProfileValue(_iprot))
              case _actualType =>
                val _expectedType = TType.STRUCT
                throw new TProtocolException(
                  "Received wrong type for field 'userProfile' (expected=%s, actual=%s).".format(
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

    if (!_got_exist) throw new TProtocolException("Required field 'exist' was not found in serialized data for struct TFullUserInfoResp")
    new Immutable(
      exist,
      userInfo,
      userProfile,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    exist: Boolean,
    userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = _root_.scala.None,
    userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = _root_.scala.None
  ): TFullUserInfoResp =
    new Immutable(
      exist,
      userInfo,
      userProfile
    )

  def unapply(_item: TFullUserInfoResp): _root_.scala.Option[_root_.scala.Tuple3[Boolean, Option[xed.userprofile.domain.thrift.TUserInfo], Option[xed.userprofile.domain.thrift.TUserProfile]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thrift] def readExistValue(_iprot: TProtocol): Boolean = {
    _iprot.readBool()
  }

  @inline private def writeExistField(exist_item: Boolean, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ExistField)
    writeExistValue(exist_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeExistValue(exist_item: Boolean, _oprot: TProtocol): Unit = {
    _oprot.writeBool(exist_item)
  }

  @inline private[thrift] def readUserInfoValue(_iprot: TProtocol): xed.userprofile.domain.thrift.TUserInfo = {
    xed.userprofile.domain.thrift.TUserInfo.decode(_iprot)
  }

  @inline private def writeUserInfoField(userInfo_item: xed.userprofile.domain.thrift.TUserInfo, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UserInfoField)
    writeUserInfoValue(userInfo_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUserInfoValue(userInfo_item: xed.userprofile.domain.thrift.TUserInfo, _oprot: TProtocol): Unit = {
    userInfo_item.write(_oprot)
  }

  @inline private[thrift] def readUserProfileValue(_iprot: TProtocol): xed.userprofile.domain.thrift.TUserProfile = {
    xed.userprofile.domain.thrift.TUserProfile.decode(_iprot)
  }

  @inline private def writeUserProfileField(userProfile_item: xed.userprofile.domain.thrift.TUserProfile, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(UserProfileField)
    writeUserProfileValue(userProfile_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeUserProfileValue(userProfile_item: xed.userprofile.domain.thrift.TUserProfile, _oprot: TProtocol): Unit = {
    userProfile_item.write(_oprot)
  }


  object Immutable extends ThriftStructCodec3[TFullUserInfoResp] {
    override def encode(_item: TFullUserInfoResp, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TFullUserInfoResp = TFullUserInfoResp.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TFullUserInfoResp] = TFullUserInfoResp.metaData
  }

  /**
   * The default read-only implementation of TFullUserInfoResp.  You typically should not need to
   * directly reference this class; instead, use the TFullUserInfoResp.apply method to construct
   * new instances.
   */
  class Immutable(
      val exist: Boolean,
      val userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo],
      val userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TFullUserInfoResp {
    def this(
      exist: Boolean,
      userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = _root_.scala.None,
      userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = _root_.scala.None
    ) = this(
      exist,
      userInfo,
      userProfile,
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
      val exist: Boolean,
      val userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo],
      val userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TFullUserInfoResp {

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
   * This Proxy trait allows you to extend the TFullUserInfoResp trait with additional state or
   * behavior and implement the read-only methods from TFullUserInfoResp using an underlying
   * instance.
   */
  trait Proxy extends TFullUserInfoResp {
    protected def _underlying_TFullUserInfoResp: TFullUserInfoResp
    override def exist: Boolean = _underlying_TFullUserInfoResp.exist
    override def userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = _underlying_TFullUserInfoResp.userInfo
    override def userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = _underlying_TFullUserInfoResp.userProfile
    override def _passthroughFields = _underlying_TFullUserInfoResp._passthroughFields
  }
}

/**
 * Prefer the companion object's [[xed.userprofile.domain.thrift.TFullUserInfoResp.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TFullUserInfoResp
  extends ThriftStruct
  with _root_.scala.Product3[Boolean, Option[xed.userprofile.domain.thrift.TUserInfo], Option[xed.userprofile.domain.thrift.TUserProfile]]
  with ValidatingThriftStruct[TFullUserInfoResp]
  with java.io.Serializable
{
  import TFullUserInfoResp._

  def exist: Boolean
  def userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo]
  def userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = exist
  def _2 = userInfo
  def _3 = userProfile

  def toTuple: _root_.scala.Tuple3[Boolean, Option[xed.userprofile.domain.thrift.TUserInfo], Option[xed.userprofile.domain.thrift.TUserProfile]] = {
    (
      exist,
      userInfo,
      userProfile
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
                writeExistValue(exist, _oprot)
                _root_.scala.Some(TFullUserInfoResp.ExistField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (userInfo.isDefined) {
                writeUserInfoValue(userInfo.get, _oprot)
                _root_.scala.Some(TFullUserInfoResp.UserInfoField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (userProfile.isDefined) {
                writeUserProfileValue(userProfile.get, _oprot)
                _root_.scala.Some(TFullUserInfoResp.UserProfileField)
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
  def setField(_blob: TFieldBlob): TFullUserInfoResp = {
    var exist: Boolean = this.exist
    var userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = this.userInfo
    var userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = this.userProfile
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        exist = readExistValue(_blob.read)
      case 2 =>
        userInfo = _root_.scala.Some(readUserInfoValue(_blob.read))
      case 3 =>
        userProfile = _root_.scala.Some(readUserProfileValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      exist,
      userInfo,
      userProfile,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TFullUserInfoResp = {
    var exist: Boolean = this.exist
    var userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = this.userInfo
    var userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = this.userProfile

    _fieldId match {
      case 1 =>
        exist = false
      case 2 =>
        userInfo = _root_.scala.None
      case 3 =>
        userProfile = _root_.scala.None
      case _ =>
    }
    new Immutable(
      exist,
      userInfo,
      userProfile,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetExist: TFullUserInfoResp = unsetField(1)

  def unsetUserInfo: TFullUserInfoResp = unsetField(2)

  def unsetUserProfile: TFullUserInfoResp = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    TFullUserInfoResp.validate(this)
    _oprot.writeStructBegin(Struct)
    writeExistField(exist, _oprot)
    if (userInfo.isDefined) writeUserInfoField(userInfo.get, _oprot)
    if (userProfile.isDefined) writeUserProfileField(userProfile.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    exist: Boolean = this.exist,
    userInfo: _root_.scala.Option[xed.userprofile.domain.thrift.TUserInfo] = this.userInfo,
    userProfile: _root_.scala.Option[xed.userprofile.domain.thrift.TUserProfile] = this.userProfile,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TFullUserInfoResp =
    new Immutable(
      exist,
      userInfo,
      userProfile,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TFullUserInfoResp]

  private def _equals(x: TFullUserInfoResp, y: TFullUserInfoResp): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TFullUserInfoResp]) &&
      _passthroughFields == other.asInstanceOf[TFullUserInfoResp]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.exist
    case 1 => this.userInfo
    case 2 => this.userProfile
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TFullUserInfoResp"

  def _codec: ValidatingThriftStructCodec3[TFullUserInfoResp] = TFullUserInfoResp
}
