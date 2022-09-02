<?php

namespace frame\helpers;

function combo_database2($tabel, $field1, $field2, $query, $data_properties = [])
{
    if ($query == '') {
        $sql = mysql_query("SELECT * FROM $tabel");
    } else {
        $sql = mysql_query("$query");
    }
    if (mysql_num_rows($sql) != 0) {
        while ($data = mysql_fetch_assoc($sql)) {
?>
            <option <?= render_data_properties($data_properties, $data) ?> value="<?php echo $data["$field1"] ?>"><?php echo $data["$field1"] . " ( " . $data["$field2"] . ")" ?></option>
<?php
        }
    }
}

function render_data_properties($datas = [], $field)
{
    $result = '';
    foreach ($datas as $value) {
        $result .= "data-$value='$field[$value]' ";
    }
    return $result;
}
?>
