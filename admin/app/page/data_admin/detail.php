
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
            $sql = mysql_query("SELECT * FROM data_admin where id_admin = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Admin </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_admin']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Nama Depan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nama_depan']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama Belakang </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nama_belakang']; ?></td>
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
                <td class="clleft" width="25%">Hak Akses </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['hak_akses']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama Sekolah </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama_sekolah","select * from data_sekolah where id_sekolah='$data[id_sekolah]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Status Pekerjaan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['status_pekerjaan']; ?></td>
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
                <td class="clleft" width="25%">Username </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['username']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Password </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['password']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
