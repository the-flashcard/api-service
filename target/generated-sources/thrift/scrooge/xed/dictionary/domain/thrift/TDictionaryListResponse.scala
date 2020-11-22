/**
 * Generated by Scrooge
 *   version: 18.4.0
 *   rev: b64bcb47af2451b2e51a1ed1b3876f6c06c642b3
 *   built at: 20180410-144307
 */
package xed.dictionary.domain.thrift

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


object TDictionaryListResponse extends ValidatingThriftStructCodec3[TDictionaryListResponse] {
  val NoPassthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("TDictionaryListResponse")
  val SuccessField = new TField("success", TType.BOOL, 1)
  val SuccessFieldManifest = implicitly[Manifest[Boolean]]
  val RecordsField = new TField("records", TType.LIST, 2)
  val RecordsFieldManifest = implicitly[Manifest[Seq[xed.dictionary.domain.thrift.TDictionary]]]
  val TotalField = new TField("total", TType.I64, 3)
  val TotalFieldManifest = implicitly[Manifest[Long]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      SuccessField,
      false,
      true,
      SuccessFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      RecordsField,
      true,
      false,
      RecordsFieldManifest,
      _root_.scala.None,
      _root_.scala.Some(implicitly[Manifest[xed.dictionary.domain.thrift.TDictionary]]),
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    ),
    new ThriftStructFieldInfo(
      TotalField,
      true,
      false,
      TotalFieldManifest,
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
  def validate(_item: TDictionaryListResponse): Unit = {
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: TDictionaryListResponse): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    buf ++= validateField(item.success)
    buf ++= validateField(item.records)
    buf ++= validateField(item.total)
    buf.toList
  }

  def withoutPassthroughFields(original: TDictionaryListResponse): TDictionaryListResponse =
    new Immutable(
      success =
        {
          val field = original.success
          field
        },
      records =
        {
          val field = original.records
          field.map { field =>
            field.map { field =>
              xed.dictionary.domain.thrift.TDictionary.withoutPassthroughFields(field)
            }
          }
        },
      total =
        {
          val field = original.total
          field.map { field =>
            field
          }
        }
    )

  override def encode(_item: TDictionaryListResponse, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }


  private[this] def lazyDecode(_iprot: LazyTProtocol): TDictionaryListResponse = {

    var success: Boolean = false
    var _got_success = false
    var records: Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = None
    var totalOffset: Int = -1

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
    
                success = readSuccessValue(_iprot)
                _got_success = true
              case _actualType =>
                val _expectedType = TType.BOOL
                throw new TProtocolException(
                  "Received wrong type for field 'success' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.LIST =>
    
                records = Some(readRecordsValue(_iprot))
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'records' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.I64 =>
                totalOffset = _iprot.offsetSkipI64
    
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'total' (expected=%s, actual=%s).".format(
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

    if (!_got_success) throw new TProtocolException("Required field 'success' was not found in serialized data for struct TDictionaryListResponse")
    new LazyImmutable(
      _iprot,
      _iprot.buffer,
      _start_offset,
      _iprot.offset,
      success,
      records,
      totalOffset,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  override def decode(_iprot: TProtocol): TDictionaryListResponse =
    _iprot match {
      case i: LazyTProtocol => lazyDecode(i)
      case i => eagerDecode(i)
    }

  private[thrift] def eagerDecode(_iprot: TProtocol): TDictionaryListResponse = {
    var success: Boolean = false
    var _got_success = false
    var records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = _root_.scala.None
    var total: _root_.scala.Option[Long] = _root_.scala.None
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
                success = readSuccessValue(_iprot)
                _got_success = true
              case _actualType =>
                val _expectedType = TType.BOOL
                throw new TProtocolException(
                  "Received wrong type for field 'success' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 2 =>
            _field.`type` match {
              case TType.LIST =>
                records = _root_.scala.Some(readRecordsValue(_iprot))
              case _actualType =>
                val _expectedType = TType.LIST
                throw new TProtocolException(
                  "Received wrong type for field 'records' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case 3 =>
            _field.`type` match {
              case TType.I64 =>
                total = _root_.scala.Some(readTotalValue(_iprot))
              case _actualType =>
                val _expectedType = TType.I64
                throw new TProtocolException(
                  "Received wrong type for field 'total' (expected=%s, actual=%s).".format(
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

    if (!_got_success) throw new TProtocolException("Required field 'success' was not found in serialized data for struct TDictionaryListResponse")
    new Immutable(
      success,
      records,
      total,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    success: Boolean,
    records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = _root_.scala.None,
    total: _root_.scala.Option[Long] = _root_.scala.None
  ): TDictionaryListResponse =
    new Immutable(
      success,
      records,
      total
    )

  def unapply(_item: TDictionaryListResponse): _root_.scala.Option[_root_.scala.Tuple3[Boolean, Option[Seq[xed.dictionary.domain.thrift.TDictionary]], Option[Long]]] = _root_.scala.Some(_item.toTuple)


  @inline private[thrift] def readSuccessValue(_iprot: TProtocol): Boolean = {
    _iprot.readBool()
  }

  @inline private def writeSuccessField(success_item: Boolean, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(SuccessField)
    writeSuccessValue(success_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeSuccessValue(success_item: Boolean, _oprot: TProtocol): Unit = {
    _oprot.writeBool(success_item)
  }

  @inline private[thrift] def readRecordsValue(_iprot: TProtocol): Seq[xed.dictionary.domain.thrift.TDictionary] = {
    val _list = _iprot.readListBegin()
    if (_list.size == 0) {
      _iprot.readListEnd()
      Nil
    } else {
      val _rv = new mutable$ArrayBuffer[xed.dictionary.domain.thrift.TDictionary](_list.size)
      var _i = 0
      while (_i < _list.size) {
        _rv += {
          xed.dictionary.domain.thrift.TDictionary.decode(_iprot)
        }
        _i += 1
      }
      _iprot.readListEnd()
      _rv
    }
  }

  @inline private def writeRecordsField(records_item: Seq[xed.dictionary.domain.thrift.TDictionary], _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(RecordsField)
    writeRecordsValue(records_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeRecordsValue(records_item: Seq[xed.dictionary.domain.thrift.TDictionary], _oprot: TProtocol): Unit = {
    _oprot.writeListBegin(new TList(TType.STRUCT, records_item.size))
    records_item match {
      case _: IndexedSeq[_] =>
        var _i = 0
        val _size = records_item.size
        while (_i < _size) {
          val records_item_element = records_item(_i)
          records_item_element.write(_oprot)
          _i += 1
        }
      case _ =>
        records_item.foreach { records_item_element =>
          records_item_element.write(_oprot)
        }
    }
    _oprot.writeListEnd()
  }

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


  object Immutable extends ThriftStructCodec3[TDictionaryListResponse] {
    override def encode(_item: TDictionaryListResponse, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): TDictionaryListResponse = TDictionaryListResponse.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[TDictionaryListResponse] = TDictionaryListResponse.metaData
  }

  /**
   * The default read-only implementation of TDictionaryListResponse.  You typically should not need to
   * directly reference this class; instead, use the TDictionaryListResponse.apply method to construct
   * new instances.
   */
  class Immutable(
      val success: Boolean,
      val records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]],
      val total: _root_.scala.Option[Long],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TDictionaryListResponse {
    def this(
      success: Boolean,
      records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = _root_.scala.None,
      total: _root_.scala.Option[Long] = _root_.scala.None
    ) = this(
      success,
      records,
      total,
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
      val success: Boolean,
      val records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]],
      totalOffset: Int,
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends TDictionaryListResponse {

    override def write(_oprot: TProtocol): Unit = {
      _oprot match {
        case i: LazyTProtocol => i.writeRaw(_buf, _start_offset, _end_offset - _start_offset)
        case _ => super.write(_oprot)
      }
    }

    lazy val total: _root_.scala.Option[Long] =
      if (totalOffset == -1)
        None
      else {
        Some(_proto.decodeI64(_buf, totalOffset))
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
   * This Proxy trait allows you to extend the TDictionaryListResponse trait with additional state or
   * behavior and implement the read-only methods from TDictionaryListResponse using an underlying
   * instance.
   */
  trait Proxy extends TDictionaryListResponse {
    protected def _underlying_TDictionaryListResponse: TDictionaryListResponse
    override def success: Boolean = _underlying_TDictionaryListResponse.success
    override def records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = _underlying_TDictionaryListResponse.records
    override def total: _root_.scala.Option[Long] = _underlying_TDictionaryListResponse.total
    override def _passthroughFields = _underlying_TDictionaryListResponse._passthroughFields
  }
}

/**
 * Prefer the companion object's [[xed.dictionary.domain.thrift.TDictionaryListResponse.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait TDictionaryListResponse
  extends ThriftStruct
  with _root_.scala.Product3[Boolean, Option[Seq[xed.dictionary.domain.thrift.TDictionary]], Option[Long]]
  with ValidatingThriftStruct[TDictionaryListResponse]
  with java.io.Serializable
{
  import TDictionaryListResponse._

  def success: Boolean
  def records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]]
  def total: _root_.scala.Option[Long]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1 = success
  def _2 = records
  def _3 = total

  def toTuple: _root_.scala.Tuple3[Boolean, Option[Seq[xed.dictionary.domain.thrift.TDictionary]], Option[Long]] = {
    (
      success,
      records,
      total
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
                writeSuccessValue(success, _oprot)
                _root_.scala.Some(TDictionaryListResponse.SuccessField)
              } else {
                _root_.scala.None
              }
            case 2 =>
              if (records.isDefined) {
                writeRecordsValue(records.get, _oprot)
                _root_.scala.Some(TDictionaryListResponse.RecordsField)
              } else {
                _root_.scala.None
              }
            case 3 =>
              if (total.isDefined) {
                writeTotalValue(total.get, _oprot)
                _root_.scala.Some(TDictionaryListResponse.TotalField)
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
  def setField(_blob: TFieldBlob): TDictionaryListResponse = {
    var success: Boolean = this.success
    var records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = this.records
    var total: _root_.scala.Option[Long] = this.total
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        success = readSuccessValue(_blob.read)
      case 2 =>
        records = _root_.scala.Some(readRecordsValue(_blob.read))
      case 3 =>
        total = _root_.scala.Some(readTotalValue(_blob.read))
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new Immutable(
      success,
      records,
      total,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): TDictionaryListResponse = {
    var success: Boolean = this.success
    var records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = this.records
    var total: _root_.scala.Option[Long] = this.total

    _fieldId match {
      case 1 =>
        success = false
      case 2 =>
        records = _root_.scala.None
      case 3 =>
        total = _root_.scala.None
      case _ =>
    }
    new Immutable(
      success,
      records,
      total,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetSuccess: TDictionaryListResponse = unsetField(1)

  def unsetRecords: TDictionaryListResponse = unsetField(2)

  def unsetTotal: TDictionaryListResponse = unsetField(3)


  override def write(_oprot: TProtocol): Unit = {
    TDictionaryListResponse.validate(this)
    _oprot.writeStructBegin(Struct)
    writeSuccessField(success, _oprot)
    if (records.isDefined) writeRecordsField(records.get, _oprot)
    if (total.isDefined) writeTotalField(total.get, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    success: Boolean = this.success,
    records: _root_.scala.Option[Seq[xed.dictionary.domain.thrift.TDictionary]] = this.records,
    total: _root_.scala.Option[Long] = this.total,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): TDictionaryListResponse =
    new Immutable(
      success,
      records,
      total,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[TDictionaryListResponse]

  private def _equals(x: TDictionaryListResponse, y: TDictionaryListResponse): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[TDictionaryListResponse]) &&
      _passthroughFields == other.asInstanceOf[TDictionaryListResponse]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 3

  override def productElement(n: Int): Any = n match {
    case 0 => this.success
    case 1 => this.records
    case 2 => this.total
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "TDictionaryListResponse"

  def _codec: ValidatingThriftStructCodec3[TDictionaryListResponse] = TDictionaryListResponse
}

