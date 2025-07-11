<?php
namespace metastore;

/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class ForeignKeysResponse
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'foreignKeys',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\metastore\SQLForeignKey',
                ),
        ),
    );

    /**
     * @var \metastore\SQLForeignKey[]
     */
    public $foreignKeys = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['foreignKeys'])) {
                $this->foreignKeys = $vals['foreignKeys'];
            }
        }
    }

    public function getName()
    {
        return 'ForeignKeysResponse';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::LST) {
                        $this->foreignKeys = array();
                        $_size441 = 0;
                        $_etype444 = 0;
                        $xfer += $input->readListBegin($_etype444, $_size441);
                        for ($_i445 = 0; $_i445 < $_size441; ++$_i445) {
                            $elem446 = null;
                            $elem446 = new \metastore\SQLForeignKey();
                            $xfer += $elem446->read($input);
                            $this->foreignKeys []= $elem446;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('ForeignKeysResponse');
        if ($this->foreignKeys !== null) {
            if (!is_array($this->foreignKeys)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('foreignKeys', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->foreignKeys));
            foreach ($this->foreignKeys as $iter447) {
                $xfer += $iter447->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
