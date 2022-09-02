
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
            $sql = mysql_query("SELECT * FROM data_akreditas where id_akreditas = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Akreditas </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_akreditas']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Nama Lengkap </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nama_lengkap']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nisn </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nisn']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Kelas </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['kelas']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Tahun Lulus </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['tahun_lulus']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Email </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['email']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Status Pekerjaan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['status_pekerjaan']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
