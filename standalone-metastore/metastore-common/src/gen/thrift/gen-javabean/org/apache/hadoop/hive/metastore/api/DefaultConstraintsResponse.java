/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class DefaultConstraintsResponse implements org.apache.thrift.TBase<DefaultConstraintsResponse, DefaultConstraintsResponse._Fields>, java.io.Serializable, Cloneable, Comparable<DefaultConstraintsResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("DefaultConstraintsResponse");

  private static final org.apache.thrift.protocol.TField DEFAULT_CONSTRAINTS_FIELD_DESC = new org.apache.thrift.protocol.TField("defaultConstraints", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DefaultConstraintsResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DefaultConstraintsResponseTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.List<SQLDefaultConstraint> defaultConstraints; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEFAULT_CONSTRAINTS((short)1, "defaultConstraints");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEFAULT_CONSTRAINTS
          return DEFAULT_CONSTRAINTS;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEFAULT_CONSTRAINTS, new org.apache.thrift.meta_data.FieldMetaData("defaultConstraints", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SQLDefaultConstraint.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(DefaultConstraintsResponse.class, metaDataMap);
  }

  public DefaultConstraintsResponse() {
  }

  public DefaultConstraintsResponse(
    java.util.List<SQLDefaultConstraint> defaultConstraints)
  {
    this();
    this.defaultConstraints = defaultConstraints;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public DefaultConstraintsResponse(DefaultConstraintsResponse other) {
    if (other.isSetDefaultConstraints()) {
      java.util.List<SQLDefaultConstraint> __this__defaultConstraints = new java.util.ArrayList<SQLDefaultConstraint>(other.defaultConstraints.size());
      for (SQLDefaultConstraint other_element : other.defaultConstraints) {
        __this__defaultConstraints.add(new SQLDefaultConstraint(other_element));
      }
      this.defaultConstraints = __this__defaultConstraints;
    }
  }

  public DefaultConstraintsResponse deepCopy() {
    return new DefaultConstraintsResponse(this);
  }

  @Override
  public void clear() {
    this.defaultConstraints = null;
  }

  public int getDefaultConstraintsSize() {
    return (this.defaultConstraints == null) ? 0 : this.defaultConstraints.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SQLDefaultConstraint> getDefaultConstraintsIterator() {
    return (this.defaultConstraints == null) ? null : this.defaultConstraints.iterator();
  }

  public void addToDefaultConstraints(SQLDefaultConstraint elem) {
    if (this.defaultConstraints == null) {
      this.defaultConstraints = new java.util.ArrayList<SQLDefaultConstraint>();
    }
    this.defaultConstraints.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SQLDefaultConstraint> getDefaultConstraints() {
    return this.defaultConstraints;
  }

  public void setDefaultConstraints(@org.apache.thrift.annotation.Nullable java.util.List<SQLDefaultConstraint> defaultConstraints) {
    this.defaultConstraints = defaultConstraints;
  }

  public void unsetDefaultConstraints() {
    this.defaultConstraints = null;
  }

  /** Returns true if field defaultConstraints is set (has been assigned a value) and false otherwise */
  public boolean isSetDefaultConstraints() {
    return this.defaultConstraints != null;
  }

  public void setDefaultConstraintsIsSet(boolean value) {
    if (!value) {
      this.defaultConstraints = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case DEFAULT_CONSTRAINTS:
      if (value == null) {
        unsetDefaultConstraints();
      } else {
        setDefaultConstraints((java.util.List<SQLDefaultConstraint>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DEFAULT_CONSTRAINTS:
      return getDefaultConstraints();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case DEFAULT_CONSTRAINTS:
      return isSetDefaultConstraints();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof DefaultConstraintsResponse)
      return this.equals((DefaultConstraintsResponse)that);
    return false;
  }

  public boolean equals(DefaultConstraintsResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_defaultConstraints = true && this.isSetDefaultConstraints();
    boolean that_present_defaultConstraints = true && that.isSetDefaultConstraints();
    if (this_present_defaultConstraints || that_present_defaultConstraints) {
      if (!(this_present_defaultConstraints && that_present_defaultConstraints))
        return false;
      if (!this.defaultConstraints.equals(that.defaultConstraints))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDefaultConstraints()) ? 131071 : 524287);
    if (isSetDefaultConstraints())
      hashCode = hashCode * 8191 + defaultConstraints.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(DefaultConstraintsResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetDefaultConstraints(), other.isSetDefaultConstraints());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDefaultConstraints()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.defaultConstraints, other.defaultConstraints);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("DefaultConstraintsResponse(");
    boolean first = true;

    sb.append("defaultConstraints:");
    if (this.defaultConstraints == null) {
      sb.append("null");
    } else {
      sb.append(this.defaultConstraints);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetDefaultConstraints()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'defaultConstraints' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class DefaultConstraintsResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DefaultConstraintsResponseStandardScheme getScheme() {
      return new DefaultConstraintsResponseStandardScheme();
    }
  }

  private static class DefaultConstraintsResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<DefaultConstraintsResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, DefaultConstraintsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEFAULT_CONSTRAINTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list522 = iprot.readListBegin();
                struct.defaultConstraints = new java.util.ArrayList<SQLDefaultConstraint>(_list522.size);
                @org.apache.thrift.annotation.Nullable SQLDefaultConstraint _elem523;
                for (int _i524 = 0; _i524 < _list522.size; ++_i524)
                {
                  _elem523 = new SQLDefaultConstraint();
                  _elem523.read(iprot);
                  struct.defaultConstraints.add(_elem523);
                }
                iprot.readListEnd();
              }
              struct.setDefaultConstraintsIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, DefaultConstraintsResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.defaultConstraints != null) {
        oprot.writeFieldBegin(DEFAULT_CONSTRAINTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.defaultConstraints.size()));
          for (SQLDefaultConstraint _iter525 : struct.defaultConstraints)
          {
            _iter525.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class DefaultConstraintsResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public DefaultConstraintsResponseTupleScheme getScheme() {
      return new DefaultConstraintsResponseTupleScheme();
    }
  }

  private static class DefaultConstraintsResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<DefaultConstraintsResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, DefaultConstraintsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.defaultConstraints.size());
        for (SQLDefaultConstraint _iter526 : struct.defaultConstraints)
        {
          _iter526.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, DefaultConstraintsResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list527 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.defaultConstraints = new java.util.ArrayList<SQLDefaultConstraint>(_list527.size);
        @org.apache.thrift.annotation.Nullable SQLDefaultConstraint _elem528;
        for (int _i529 = 0; _i529 < _list527.size; ++_i529)
        {
          _elem528 = new SQLDefaultConstraint();
          _elem528.read(iprot);
          struct.defaultConstraints.add(_elem528);
        }
      }
      struct.setDefaultConstraintsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

