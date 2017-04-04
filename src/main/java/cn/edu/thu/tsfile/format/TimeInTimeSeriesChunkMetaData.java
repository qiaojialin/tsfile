/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package cn.edu.thu.tsfile.format;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import javax.annotation.Generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-12-29")
public class TimeInTimeSeriesChunkMetaData implements org.apache.thrift.TBase<TimeInTimeSeriesChunkMetaData, TimeInTimeSeriesChunkMetaData._Fields>, java.io.Serializable, Cloneable, Comparable<TimeInTimeSeriesChunkMetaData> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TimeInTimeSeriesChunkMetaData");

  private static final org.apache.thrift.protocol.TField DATA_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("data_type", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField FREQ_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("freq_type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField FREQUENCIES_FIELD_DESC = new org.apache.thrift.protocol.TField("frequencies", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField STARTIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startime", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField ENDTIME_FIELD_DESC = new org.apache.thrift.protocol.TField("endtime", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField ENUM_VALUES_FIELD_DESC = new org.apache.thrift.protocol.TField("enum_values", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TimeInTimeSeriesChunkMetaDataStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TimeInTimeSeriesChunkMetaDataTupleSchemeFactory());
  }

  /**
   * 
   * @see DataType
   */
  public DataType data_type; // required
  /**
   * 
   * @see FreqType
   */
  public FreqType freq_type; // optional
  public List<Integer> frequencies; // optional
  public long startime; // required
  public long endtime; // required
  /**
   * If values of data consist of enum values, metadata will store all possible
   * values in time series
   */
  public List<String> enum_values; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see DataType
     */
    DATA_TYPE((short)1, "data_type"),
    /**
     * 
     * @see FreqType
     */
    FREQ_TYPE((short)2, "freq_type"),
    FREQUENCIES((short)3, "frequencies"),
    STARTIME((short)4, "startime"),
    ENDTIME((short)5, "endtime"),
    /**
     * If values of data consist of enum values, metadata will store all possible
     * values in time series
     */
    ENUM_VALUES((short)6, "enum_values");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DATA_TYPE
          return DATA_TYPE;
        case 2: // FREQ_TYPE
          return FREQ_TYPE;
        case 3: // FREQUENCIES
          return FREQUENCIES;
        case 4: // STARTIME
          return STARTIME;
        case 5: // ENDTIME
          return ENDTIME;
        case 6: // ENUM_VALUES
          return ENUM_VALUES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __STARTIME_ISSET_ID = 0;
  private static final int __ENDTIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.FREQ_TYPE,_Fields.FREQUENCIES,_Fields.ENUM_VALUES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DATA_TYPE, new org.apache.thrift.meta_data.FieldMetaData("data_type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, DataType.class)));
    tmpMap.put(_Fields.FREQ_TYPE, new org.apache.thrift.meta_data.FieldMetaData("freq_type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, FreqType.class)));
    tmpMap.put(_Fields.FREQUENCIES, new org.apache.thrift.meta_data.FieldMetaData("frequencies", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.STARTIME, new org.apache.thrift.meta_data.FieldMetaData("startime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ENDTIME, new org.apache.thrift.meta_data.FieldMetaData("endtime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ENUM_VALUES, new org.apache.thrift.meta_data.FieldMetaData("enum_values", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TimeInTimeSeriesChunkMetaData.class, metaDataMap);
  }

  public TimeInTimeSeriesChunkMetaData() {
  }

  public TimeInTimeSeriesChunkMetaData(
    DataType data_type,
    long startime,
    long endtime)
  {
    this();
    this.data_type = data_type;
    this.startime = startime;
    setStartimeIsSet(true);
    this.endtime = endtime;
    setEndtimeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TimeInTimeSeriesChunkMetaData(TimeInTimeSeriesChunkMetaData other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetData_type()) {
      this.data_type = other.data_type;
    }
    if (other.isSetFreq_type()) {
      this.freq_type = other.freq_type;
    }
    if (other.isSetFrequencies()) {
      List<Integer> __this__frequencies = new ArrayList<Integer>(other.frequencies);
      this.frequencies = __this__frequencies;
    }
    this.startime = other.startime;
    this.endtime = other.endtime;
    if (other.isSetEnum_values()) {
      List<String> __this__enum_values = new ArrayList<String>(other.enum_values);
      this.enum_values = __this__enum_values;
    }
  }

  public TimeInTimeSeriesChunkMetaData deepCopy() {
    return new TimeInTimeSeriesChunkMetaData(this);
  }

  @Override
  public void clear() {
    this.data_type = null;
    this.freq_type = null;
    this.frequencies = null;
    setStartimeIsSet(false);
    this.startime = 0;
    setEndtimeIsSet(false);
    this.endtime = 0;
    this.enum_values = null;
  }

  /**
   * 
   * @see DataType
   */
  public DataType getData_type() {
    return this.data_type;
  }

  /**
   * 
   * @see DataType
   */
  public TimeInTimeSeriesChunkMetaData setData_type(DataType data_type) {
    this.data_type = data_type;
    return this;
  }

  public void unsetData_type() {
    this.data_type = null;
  }

  /** Returns true if field data_type is set (has been assigned a value) and false otherwise */
  public boolean isSetData_type() {
    return this.data_type != null;
  }

  public void setData_typeIsSet(boolean value) {
    if (!value) {
      this.data_type = null;
    }
  }

  /**
   * 
   * @see FreqType
   */
  public FreqType getFreq_type() {
    return this.freq_type;
  }

  /**
   * 
   * @see FreqType
   */
  public TimeInTimeSeriesChunkMetaData setFreq_type(FreqType freq_type) {
    this.freq_type = freq_type;
    return this;
  }

  public void unsetFreq_type() {
    this.freq_type = null;
  }

  /** Returns true if field freq_type is set (has been assigned a value) and false otherwise */
  public boolean isSetFreq_type() {
    return this.freq_type != null;
  }

  public void setFreq_typeIsSet(boolean value) {
    if (!value) {
      this.freq_type = null;
    }
  }

  public int getFrequenciesSize() {
    return (this.frequencies == null) ? 0 : this.frequencies.size();
  }

  public java.util.Iterator<Integer> getFrequenciesIterator() {
    return (this.frequencies == null) ? null : this.frequencies.iterator();
  }

  public void addToFrequencies(int elem) {
    if (this.frequencies == null) {
      this.frequencies = new ArrayList<Integer>();
    }
    this.frequencies.add(elem);
  }

  public List<Integer> getFrequencies() {
    return this.frequencies;
  }

  public TimeInTimeSeriesChunkMetaData setFrequencies(List<Integer> frequencies) {
    this.frequencies = frequencies;
    return this;
  }

  public void unsetFrequencies() {
    this.frequencies = null;
  }

  /** Returns true if field frequencies is set (has been assigned a value) and false otherwise */
  public boolean isSetFrequencies() {
    return this.frequencies != null;
  }

  public void setFrequenciesIsSet(boolean value) {
    if (!value) {
      this.frequencies = null;
    }
  }

  public long getStartime() {
    return this.startime;
  }

  public TimeInTimeSeriesChunkMetaData setStartime(long startime) {
    this.startime = startime;
    setStartimeIsSet(true);
    return this;
  }

  public void unsetStartime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STARTIME_ISSET_ID);
  }

  /** Returns true if field startime is set (has been assigned a value) and false otherwise */
  public boolean isSetStartime() {
    return EncodingUtils.testBit(__isset_bitfield, __STARTIME_ISSET_ID);
  }

  public void setStartimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STARTIME_ISSET_ID, value);
  }

  public long getEndtime() {
    return this.endtime;
  }

  public TimeInTimeSeriesChunkMetaData setEndtime(long endtime) {
    this.endtime = endtime;
    setEndtimeIsSet(true);
    return this;
  }

  public void unsetEndtime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ENDTIME_ISSET_ID);
  }

  /** Returns true if field endtime is set (has been assigned a value) and false otherwise */
  public boolean isSetEndtime() {
    return EncodingUtils.testBit(__isset_bitfield, __ENDTIME_ISSET_ID);
  }

  public void setEndtimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ENDTIME_ISSET_ID, value);
  }

  public int getEnum_valuesSize() {
    return (this.enum_values == null) ? 0 : this.enum_values.size();
  }

  public java.util.Iterator<String> getEnum_valuesIterator() {
    return (this.enum_values == null) ? null : this.enum_values.iterator();
  }

  public void addToEnum_values(String elem) {
    if (this.enum_values == null) {
      this.enum_values = new ArrayList<String>();
    }
    this.enum_values.add(elem);
  }

  /**
   * If values of data consist of enum values, metadata will store all possible
   * values in time series
   */
  public List<String> getEnum_values() {
    return this.enum_values;
  }

  /**
   * If values of data consist of enum values, metadata will store all possible
   * values in time series
   */
  public TimeInTimeSeriesChunkMetaData setEnum_values(List<String> enum_values) {
    this.enum_values = enum_values;
    return this;
  }

  public void unsetEnum_values() {
    this.enum_values = null;
  }

  /** Returns true if field enum_values is set (has been assigned a value) and false otherwise */
  public boolean isSetEnum_values() {
    return this.enum_values != null;
  }

  public void setEnum_valuesIsSet(boolean value) {
    if (!value) {
      this.enum_values = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DATA_TYPE:
      if (value == null) {
        unsetData_type();
      } else {
        setData_type((DataType)value);
      }
      break;

    case FREQ_TYPE:
      if (value == null) {
        unsetFreq_type();
      } else {
        setFreq_type((FreqType)value);
      }
      break;

    case FREQUENCIES:
      if (value == null) {
        unsetFrequencies();
      } else {
        setFrequencies((List<Integer>)value);
      }
      break;

    case STARTIME:
      if (value == null) {
        unsetStartime();
      } else {
        setStartime((Long)value);
      }
      break;

    case ENDTIME:
      if (value == null) {
        unsetEndtime();
      } else {
        setEndtime((Long)value);
      }
      break;

    case ENUM_VALUES:
      if (value == null) {
        unsetEnum_values();
      } else {
        setEnum_values((List<String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DATA_TYPE:
      return getData_type();

    case FREQ_TYPE:
      return getFreq_type();

    case FREQUENCIES:
      return getFrequencies();

    case STARTIME:
      return Long.valueOf(getStartime());

    case ENDTIME:
      return Long.valueOf(getEndtime());

    case ENUM_VALUES:
      return getEnum_values();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DATA_TYPE:
      return isSetData_type();
    case FREQ_TYPE:
      return isSetFreq_type();
    case FREQUENCIES:
      return isSetFrequencies();
    case STARTIME:
      return isSetStartime();
    case ENDTIME:
      return isSetEndtime();
    case ENUM_VALUES:
      return isSetEnum_values();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TimeInTimeSeriesChunkMetaData)
      return this.equals((TimeInTimeSeriesChunkMetaData)that);
    return false;
  }

  public boolean equals(TimeInTimeSeriesChunkMetaData that) {
    if (that == null)
      return false;

    boolean this_present_data_type = true && this.isSetData_type();
    boolean that_present_data_type = true && that.isSetData_type();
    if (this_present_data_type || that_present_data_type) {
      if (!(this_present_data_type && that_present_data_type))
        return false;
      if (!this.data_type.equals(that.data_type))
        return false;
    }

    boolean this_present_freq_type = true && this.isSetFreq_type();
    boolean that_present_freq_type = true && that.isSetFreq_type();
    if (this_present_freq_type || that_present_freq_type) {
      if (!(this_present_freq_type && that_present_freq_type))
        return false;
      if (!this.freq_type.equals(that.freq_type))
        return false;
    }

    boolean this_present_frequencies = true && this.isSetFrequencies();
    boolean that_present_frequencies = true && that.isSetFrequencies();
    if (this_present_frequencies || that_present_frequencies) {
      if (!(this_present_frequencies && that_present_frequencies))
        return false;
      if (!this.frequencies.equals(that.frequencies))
        return false;
    }

    boolean this_present_startime = true;
    boolean that_present_startime = true;
    if (this_present_startime || that_present_startime) {
      if (!(this_present_startime && that_present_startime))
        return false;
      if (this.startime != that.startime)
        return false;
    }

    boolean this_present_endtime = true;
    boolean that_present_endtime = true;
    if (this_present_endtime || that_present_endtime) {
      if (!(this_present_endtime && that_present_endtime))
        return false;
      if (this.endtime != that.endtime)
        return false;
    }

    boolean this_present_enum_values = true && this.isSetEnum_values();
    boolean that_present_enum_values = true && that.isSetEnum_values();
    if (this_present_enum_values || that_present_enum_values) {
      if (!(this_present_enum_values && that_present_enum_values))
        return false;
      if (!this.enum_values.equals(that.enum_values))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_data_type = true && (isSetData_type());
    list.add(present_data_type);
    if (present_data_type)
      list.add(data_type.getValue());

    boolean present_freq_type = true && (isSetFreq_type());
    list.add(present_freq_type);
    if (present_freq_type)
      list.add(freq_type.getValue());

    boolean present_frequencies = true && (isSetFrequencies());
    list.add(present_frequencies);
    if (present_frequencies)
      list.add(frequencies);

    boolean present_startime = true;
    list.add(present_startime);
    if (present_startime)
      list.add(startime);

    boolean present_endtime = true;
    list.add(present_endtime);
    if (present_endtime)
      list.add(endtime);

    boolean present_enum_values = true && (isSetEnum_values());
    list.add(present_enum_values);
    if (present_enum_values)
      list.add(enum_values);

    return list.hashCode();
  }

  @Override
  public int compareTo(TimeInTimeSeriesChunkMetaData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetData_type()).compareTo(other.isSetData_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data_type, other.data_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFreq_type()).compareTo(other.isSetFreq_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFreq_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.freq_type, other.freq_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFrequencies()).compareTo(other.isSetFrequencies());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFrequencies()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.frequencies, other.frequencies);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartime()).compareTo(other.isSetStartime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startime, other.startime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEndtime()).compareTo(other.isSetEndtime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndtime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endtime, other.endtime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEnum_values()).compareTo(other.isSetEnum_values());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEnum_values()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.enum_values, other.enum_values);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TimeInTimeSeriesChunkMetaData(");
    boolean first = true;

    sb.append("data_type:");
    if (this.data_type == null) {
      sb.append("null");
    } else {
      sb.append(this.data_type);
    }
    first = false;
    if (isSetFreq_type()) {
      if (!first) sb.append(", ");
      sb.append("freq_type:");
      if (this.freq_type == null) {
        sb.append("null");
      } else {
        sb.append(this.freq_type);
      }
      first = false;
    }
    if (isSetFrequencies()) {
      if (!first) sb.append(", ");
      sb.append("frequencies:");
      if (this.frequencies == null) {
        sb.append("null");
      } else {
        sb.append(this.frequencies);
      }
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("startime:");
    sb.append(this.startime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("endtime:");
    sb.append(this.endtime);
    first = false;
    if (isSetEnum_values()) {
      if (!first) sb.append(", ");
      sb.append("enum_values:");
      if (this.enum_values == null) {
        sb.append("null");
      } else {
        sb.append(this.enum_values);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (data_type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'data_type' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'startime' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'endtime' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TimeInTimeSeriesChunkMetaDataStandardSchemeFactory implements SchemeFactory {
    public TimeInTimeSeriesChunkMetaDataStandardScheme getScheme() {
      return new TimeInTimeSeriesChunkMetaDataStandardScheme();
    }
  }

  private static class TimeInTimeSeriesChunkMetaDataStandardScheme extends StandardScheme<TimeInTimeSeriesChunkMetaData> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TimeInTimeSeriesChunkMetaData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DATA_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.data_type = DataType.findByValue(iprot.readI32());
              struct.setData_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FREQ_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.freq_type = FreqType.findByValue(iprot.readI32());
              struct.setFreq_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FREQUENCIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.frequencies = new ArrayList<Integer>(_list16.size);
                int _elem17;
                for (int _i18 = 0; _i18 < _list16.size; ++_i18)
                {
                  _elem17 = iprot.readI32();
                  struct.frequencies.add(_elem17);
                }
                iprot.readListEnd();
              }
              struct.setFrequenciesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STARTIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.startime = iprot.readI64();
              struct.setStartimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ENDTIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.endtime = iprot.readI64();
              struct.setEndtimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ENUM_VALUES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list19 = iprot.readListBegin();
                struct.enum_values = new ArrayList<String>(_list19.size);
                String _elem20;
                for (int _i21 = 0; _i21 < _list19.size; ++_i21)
                {
                  _elem20 = iprot.readString();
                  struct.enum_values.add(_elem20);
                }
                iprot.readListEnd();
              }
              struct.setEnum_valuesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetStartime()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'startime' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetEndtime()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'endtime' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TimeInTimeSeriesChunkMetaData struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.data_type != null) {
        oprot.writeFieldBegin(DATA_TYPE_FIELD_DESC);
        oprot.writeI32(struct.data_type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.freq_type != null) {
        if (struct.isSetFreq_type()) {
          oprot.writeFieldBegin(FREQ_TYPE_FIELD_DESC);
          oprot.writeI32(struct.freq_type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.frequencies != null) {
        if (struct.isSetFrequencies()) {
          oprot.writeFieldBegin(FREQUENCIES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.frequencies.size()));
            for (int _iter22 : struct.frequencies)
            {
              oprot.writeI32(_iter22);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldBegin(STARTIME_FIELD_DESC);
      oprot.writeI64(struct.startime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ENDTIME_FIELD_DESC);
      oprot.writeI64(struct.endtime);
      oprot.writeFieldEnd();
      if (struct.enum_values != null) {
        if (struct.isSetEnum_values()) {
          oprot.writeFieldBegin(ENUM_VALUES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.enum_values.size()));
            for (String _iter23 : struct.enum_values)
            {
              oprot.writeString(_iter23);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TimeInTimeSeriesChunkMetaDataTupleSchemeFactory implements SchemeFactory {
    public TimeInTimeSeriesChunkMetaDataTupleScheme getScheme() {
      return new TimeInTimeSeriesChunkMetaDataTupleScheme();
    }
  }

  private static class TimeInTimeSeriesChunkMetaDataTupleScheme extends TupleScheme<TimeInTimeSeriesChunkMetaData> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TimeInTimeSeriesChunkMetaData struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.data_type.getValue());
      oprot.writeI64(struct.startime);
      oprot.writeI64(struct.endtime);
      BitSet optionals = new BitSet();
      if (struct.isSetFreq_type()) {
        optionals.set(0);
      }
      if (struct.isSetFrequencies()) {
        optionals.set(1);
      }
      if (struct.isSetEnum_values()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetFreq_type()) {
        oprot.writeI32(struct.freq_type.getValue());
      }
      if (struct.isSetFrequencies()) {
        {
          oprot.writeI32(struct.frequencies.size());
          for (int _iter24 : struct.frequencies)
          {
            oprot.writeI32(_iter24);
          }
        }
      }
      if (struct.isSetEnum_values()) {
        {
          oprot.writeI32(struct.enum_values.size());
          for (String _iter25 : struct.enum_values)
          {
            oprot.writeString(_iter25);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TimeInTimeSeriesChunkMetaData struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.data_type = DataType.findByValue(iprot.readI32());
      struct.setData_typeIsSet(true);
      struct.startime = iprot.readI64();
      struct.setStartimeIsSet(true);
      struct.endtime = iprot.readI64();
      struct.setEndtimeIsSet(true);
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.freq_type = FreqType.findByValue(iprot.readI32());
        struct.setFreq_typeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list26 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.frequencies = new ArrayList<Integer>(_list26.size);
          int _elem27;
          for (int _i28 = 0; _i28 < _list26.size; ++_i28)
          {
            _elem27 = iprot.readI32();
            struct.frequencies.add(_elem27);
          }
        }
        struct.setFrequenciesIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.enum_values = new ArrayList<String>(_list29.size);
          String _elem30;
          for (int _i31 = 0; _i31 < _list29.size; ++_i31)
          {
            _elem30 = iprot.readString();
            struct.enum_values.add(_elem30);
          }
        }
        struct.setEnum_valuesIsSet(true);
      }
    }
  }

}

