/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)")
@org.apache.hadoop.classification.InterfaceAudience.Public @org.apache.hadoop.classification.InterfaceStability.Stable public class AddNotNullConstraintRequest implements org.apache.thrift.TBase<AddNotNullConstraintRequest, AddNotNullConstraintRequest._Fields>, java.io.Serializable, Cloneable, Comparable<AddNotNullConstraintRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AddNotNullConstraintRequest");

  private static final org.apache.thrift.protocol.TField NOT_NULL_CONSTRAINT_COLS_FIELD_DESC = new org.apache.thrift.protocol.TField("notNullConstraintCols", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AddNotNullConstraintRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AddNotNullConstraintRequestTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.List<SQLNotNullConstraint> notNullConstraintCols; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NOT_NULL_CONSTRAINT_COLS((short)1, "notNullConstraintCols");

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
        case 1: // NOT_NULL_CONSTRAINT_COLS
          return NOT_NULL_CONSTRAINT_COLS;
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
    tmpMap.put(_Fields.NOT_NULL_CONSTRAINT_COLS, new org.apache.thrift.meta_data.FieldMetaData("notNullConstraintCols", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SQLNotNullConstraint.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AddNotNullConstraintRequest.class, metaDataMap);
  }

  public AddNotNullConstraintRequest() {
  }

  public AddNotNullConstraintRequest(
    java.util.List<SQLNotNullConstraint> notNullConstraintCols)
  {
    this();
    this.notNullConstraintCols = notNullConstraintCols;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AddNotNullConstraintRequest(AddNotNullConstraintRequest other) {
    if (other.isSetNotNullConstraintCols()) {
      java.util.List<SQLNotNullConstraint> __this__notNullConstraintCols = new java.util.ArrayList<SQLNotNullConstraint>(other.notNullConstraintCols.size());
      for (SQLNotNullConstraint other_element : other.notNullConstraintCols) {
        __this__notNullConstraintCols.add(new SQLNotNullConstraint(other_element));
      }
      this.notNullConstraintCols = __this__notNullConstraintCols;
    }
  }

  public AddNotNullConstraintRequest deepCopy() {
    return new AddNotNullConstraintRequest(this);
  }

  @Override
  public void clear() {
    this.notNullConstraintCols = null;
  }

  public int getNotNullConstraintColsSize() {
    return (this.notNullConstraintCols == null) ? 0 : this.notNullConstraintCols.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SQLNotNullConstraint> getNotNullConstraintColsIterator() {
    return (this.notNullConstraintCols == null) ? null : this.notNullConstraintCols.iterator();
  }

  public void addToNotNullConstraintCols(SQLNotNullConstraint elem) {
    if (this.notNullConstraintCols == null) {
      this.notNullConstraintCols = new java.util.ArrayList<SQLNotNullConstraint>();
    }
    this.notNullConstraintCols.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SQLNotNullConstraint> getNotNullConstraintCols() {
    return this.notNullConstraintCols;
  }

  public void setNotNullConstraintCols(@org.apache.thrift.annotation.Nullable java.util.List<SQLNotNullConstraint> notNullConstraintCols) {
    this.notNullConstraintCols = notNullConstraintCols;
  }

  public void unsetNotNullConstraintCols() {
    this.notNullConstraintCols = null;
  }

  /** Returns true if field notNullConstraintCols is set (has been assigned a value) and false otherwise */
  public boolean isSetNotNullConstraintCols() {
    return this.notNullConstraintCols != null;
  }

  public void setNotNullConstraintColsIsSet(boolean value) {
    if (!value) {
      this.notNullConstraintCols = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NOT_NULL_CONSTRAINT_COLS:
      if (value == null) {
        unsetNotNullConstraintCols();
      } else {
        setNotNullConstraintCols((java.util.List<SQLNotNullConstraint>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NOT_NULL_CONSTRAINT_COLS:
      return getNotNullConstraintCols();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NOT_NULL_CONSTRAINT_COLS:
      return isSetNotNullConstraintCols();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof AddNotNullConstraintRequest)
      return this.equals((AddNotNullConstraintRequest)that);
    return false;
  }

  public boolean equals(AddNotNullConstraintRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_notNullConstraintCols = true && this.isSetNotNullConstraintCols();
    boolean that_present_notNullConstraintCols = true && that.isSetNotNullConstraintCols();
    if (this_present_notNullConstraintCols || that_present_notNullConstraintCols) {
      if (!(this_present_notNullConstraintCols && that_present_notNullConstraintCols))
        return false;
      if (!this.notNullConstraintCols.equals(that.notNullConstraintCols))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetNotNullConstraintCols()) ? 131071 : 524287);
    if (isSetNotNullConstraintCols())
      hashCode = hashCode * 8191 + notNullConstraintCols.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(AddNotNullConstraintRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetNotNullConstraintCols(), other.isSetNotNullConstraintCols());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNotNullConstraintCols()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.notNullConstraintCols, other.notNullConstraintCols);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("AddNotNullConstraintRequest(");
    boolean first = true;

    sb.append("notNullConstraintCols:");
    if (this.notNullConstraintCols == null) {
      sb.append("null");
    } else {
      sb.append(this.notNullConstraintCols);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetNotNullConstraintCols()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'notNullConstraintCols' is unset! Struct:" + toString());
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

  private static class AddNotNullConstraintRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddNotNullConstraintRequestStandardScheme getScheme() {
      return new AddNotNullConstraintRequestStandardScheme();
    }
  }

  private static class AddNotNullConstraintRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<AddNotNullConstraintRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AddNotNullConstraintRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NOT_NULL_CONSTRAINT_COLS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list562 = iprot.readListBegin();
                struct.notNullConstraintCols = new java.util.ArrayList<SQLNotNullConstraint>(_list562.size);
                @org.apache.thrift.annotation.Nullable SQLNotNullConstraint _elem563;
                for (int _i564 = 0; _i564 < _list562.size; ++_i564)
                {
                  _elem563 = new SQLNotNullConstraint();
                  _elem563.read(iprot);
                  struct.notNullConstraintCols.add(_elem563);
                }
                iprot.readListEnd();
              }
              struct.setNotNullConstraintColsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AddNotNullConstraintRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.notNullConstraintCols != null) {
        oprot.writeFieldBegin(NOT_NULL_CONSTRAINT_COLS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.notNullConstraintCols.size()));
          for (SQLNotNullConstraint _iter565 : struct.notNullConstraintCols)
          {
            _iter565.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AddNotNullConstraintRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AddNotNullConstraintRequestTupleScheme getScheme() {
      return new AddNotNullConstraintRequestTupleScheme();
    }
  }

  private static class AddNotNullConstraintRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<AddNotNullConstraintRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AddNotNullConstraintRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.notNullConstraintCols.size());
        for (SQLNotNullConstraint _iter566 : struct.notNullConstraintCols)
        {
          _iter566.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AddNotNullConstraintRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list567 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        struct.notNullConstraintCols = new java.util.ArrayList<SQLNotNullConstraint>(_list567.size);
        @org.apache.thrift.annotation.Nullable SQLNotNullConstraint _elem568;
        for (int _i569 = 0; _i569 < _list567.size; ++_i569)
        {
          _elem568 = new SQLNotNullConstraint();
          _elem568.read(iprot);
          struct.notNullConstraintCols.add(_elem568);
        }
      }
      struct.setNotNullConstraintColsIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

