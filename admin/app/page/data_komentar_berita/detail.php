
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
            $sql = mysql_query("SELECT * FROM data_komentar_berita where id_komentar_berita = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Komentar Berita </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_komentar_berita']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Caption </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","caption","select * from data_berita where id_berita='$data[id_berita]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama Depan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama_depan","select * from data_alumni where id_alumni='$data[id_alumni]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Tanggal </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo format_indo($data['tanggal']); ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Komentar </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['komentar']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
