
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
            $sql = mysql_query("SELECT * FROM data_sekolah where id_sekolah = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Sekolah </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_sekolah']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Nama Sekolah </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nama_sekolah']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Alamat </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['alamat']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Email </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['email']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">No Telepon </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['no_telepon']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Kota </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['kota']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Deskripsi </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['deskripsi']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
