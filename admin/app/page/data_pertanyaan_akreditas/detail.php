
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI'); ?>
</a>

<br><br>

<div class="content-box">
    <div class="content-box-content">
        <table <?php tabel_in(100, '%', 0, 'center'); ?>>		
            <tbody>
               
                <?php
                if (!isset($_GET['proses'])) {
                        
                    ?>
                <script>
                    alert("AKSES DITOLAK");
                    location.href = "index.php";
                </script>
                <?php
                die();
            }
            $proses = decrypt(mysql_real_escape_string($_GET['proses']));
            $sql = mysql_query("SELECT * FROM data_pertanyaan_akreditas where id_pertanyaan_akreditas = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Pertanyaan Akreditas </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_pertanyaan_akreditas']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Nama Sekolah </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama_sekolah","select * from data_sekolah where id_sekolah='$data[id_sekolah]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Pertanyaan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['pertanyaan']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
