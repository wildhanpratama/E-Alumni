
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
            $sql = mysql_query("SELECT * FROM data_kenangan where id_kenangan = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Kenangan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_kenangan']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Caption </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['caption']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Tanggal </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo format_indo($data['tanggal']); ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Foto </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft">
                  <a href="../../../../admin/upload/<?php echo $data['foto']; ?>"><img onerror="this.src='../../../data/image/error/file.png'" width="100"  src="../../../../admin/upload/<?php echo $data['foto']; ?>"></a>
                    <br>
                  <?php echo $data['foto']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama Depan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama_depan","select * from data_alumni where id_alumni='$data[id_alumni]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Jumlah Like </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['jumlah_like']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Jumlah Komen </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['jumlah_komen']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
