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

class AbortCompactionRequest
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'compactionIds',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::I64,
            'elem' => array(
                'type' => TType::I64,
                ),
        ),
        2 => array(
            'var' => 'type',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        3 => array(
            'var' => 'poolName',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var int[]
     */
    public $compactionIds = null;
    /**
     * @var string
     */
    public $type = null;
    /**
     * @var string
     */
    public $poolName = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['compactionIds'])) {
                $this->compactionIds = $vals['compactionIds'];
            }
            if (isset($vals['type'])) {
                $this->type = $vals['type'];
            }
            if (isset($vals['poolName'])) {
                $this->poolName = $vals['poolName'];
            }
        }
    }

    public function getName()
    {
        return 'AbortCompactionRequest';
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
                        $this->compactionIds = array();
                        $_size841 = 0;
                        $_etype844 = 0;
                        $xfer += $input->readListBegin($_etype844, $_size841);
                        for ($_i845 = 0; $_i845 < $_size841; ++$_i845) {
                            $elem846 = null;
                            $xfer += $input->readI64($elem846);
                            $this->compactionIds []= $elem846;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->type);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->poolName);
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
        $xfer += $output->writeStructBegin('AbortCompactionRequest');
        if ($this->compactionIds !== null) {
            if (!is_array($this->compactionIds)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('compactionIds', TType::LST, 1);
            $output->writeListBegin(TType::I64, count($this->compactionIds));
            foreach ($this->compactionIds as $iter847) {
                $xfer += $output->writeI64($iter847);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->type !== null) {
            $xfer += $output->writeFieldBegin('type', TType::STRING, 2);
            $xfer += $output->writeString($this->type);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->poolName !== null) {
            $xfer += $output->writeFieldBegin('poolName', TType::STRING, 3);
            $xfer += $output->writeString($this->poolName);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
