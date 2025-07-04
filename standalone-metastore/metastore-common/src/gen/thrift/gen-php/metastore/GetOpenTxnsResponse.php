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

class GetOpenTxnsResponse
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'txn_high_water_mark',
            'isRequired' => true,
            'type' => TType::I64,
        ),
        2 => array(
            'var' => 'open_txns',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::I64,
            'elem' => array(
                'type' => TType::I64,
                ),
        ),
        3 => array(
            'var' => 'min_open_txn',
            'isRequired' => false,
            'type' => TType::I64,
        ),
        4 => array(
            'var' => 'abortedBits',
            'isRequired' => true,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var int
     */
    public $txn_high_water_mark = null;
    /**
     * @var int[]
     */
    public $open_txns = null;
    /**
     * @var int
     */
    public $min_open_txn = null;
    /**
     * @var string
     */
    public $abortedBits = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['txn_high_water_mark'])) {
                $this->txn_high_water_mark = $vals['txn_high_water_mark'];
            }
            if (isset($vals['open_txns'])) {
                $this->open_txns = $vals['open_txns'];
            }
            if (isset($vals['min_open_txn'])) {
                $this->min_open_txn = $vals['min_open_txn'];
            }
            if (isset($vals['abortedBits'])) {
                $this->abortedBits = $vals['abortedBits'];
            }
        }
    }

    public function getName()
    {
        return 'GetOpenTxnsResponse';
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
                    if ($ftype == TType::I64) {
                        $xfer += $input->readI64($this->txn_high_water_mark);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::LST) {
                        $this->open_txns = array();
                        $_size704 = 0;
                        $_etype707 = 0;
                        $xfer += $input->readListBegin($_etype707, $_size704);
                        for ($_i708 = 0; $_i708 < $_size704; ++$_i708) {
                            $elem709 = null;
                            $xfer += $input->readI64($elem709);
                            $this->open_txns []= $elem709;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::I64) {
                        $xfer += $input->readI64($this->min_open_txn);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->abortedBits);
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
        $xfer += $output->writeStructBegin('GetOpenTxnsResponse');
        if ($this->txn_high_water_mark !== null) {
            $xfer += $output->writeFieldBegin('txn_high_water_mark', TType::I64, 1);
            $xfer += $output->writeI64($this->txn_high_water_mark);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->open_txns !== null) {
            if (!is_array($this->open_txns)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('open_txns', TType::LST, 2);
            $output->writeListBegin(TType::I64, count($this->open_txns));
            foreach ($this->open_txns as $iter710) {
                $xfer += $output->writeI64($iter710);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->min_open_txn !== null) {
            $xfer += $output->writeFieldBegin('min_open_txn', TType::I64, 3);
            $xfer += $output->writeI64($this->min_open_txn);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->abortedBits !== null) {
            $xfer += $output->writeFieldBegin('abortedBits', TType::STRING, 4);
            $xfer += $output->writeString($this->abortedBits);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
