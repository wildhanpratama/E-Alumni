<?php

/**
 * File              : helpers.php
 * @author           : Haryan DB <haryandb@gmail.com>
 * Date              : 15.08.2022
 * Last Modified Date: 15.08.2022
 * Last Modified By  : Haryan DB <haryandb@gmail.com>
 */


namespace data_akreditas\helpers;

function combo_database2($tabel, $field1, $field2, $field3, $query)
{
    if ($query == '') {
        $sql = mysql_query("SELECT * FROM $tabel");
    } else {
        $sql = mysql_query("$query");
    }
    if (mysql_num_rows($sql) != 0) {
        while ($data = mysql_fetch_assoc($sql)) {
?>
            <option value="<?php echo $data["$field1"] ?>"><?php echo $data["$field1"] . " ( " . $data["$field2"] . " " . $data["$field3"] . ")" ?></option>';
<?php
        }
    }
}

?>
