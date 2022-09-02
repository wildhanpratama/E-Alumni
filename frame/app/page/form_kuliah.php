<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Jenjang</div>
            <div class="item-input-wrap">
                <input type="text" name="jenjang" value="<?= $data['jenjang'] ?>" placeholder="Jenjang" />
            </div>
        </div>
    </div>
</li>
<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Jenis Sekolah</div>
            <div class="item-input-wrap">
                <div>
                    <input type="radio" name="swasta_atau_negeri" id="swasta_atau_negeri_negeri" <?= $data['jenjang'] == "Negeri" ? "checked" : "" ?> value="Negeri" />
                    <label for="swasta_atau_negeri_negeri">Negeri</label><br>
                </div>

                <div>
                    <input type="radio" name="swasta_atau_negeri" id="swasta_atau_negeri_swasta" <?= $data['jenjang'] == "Swasta" ? "checked" : "" ?> value="Swasta"/>
                    <label for="swasta_atau_negeri_swasta">Swasta</label><br>
                </div>
            </div>
        </div>
    </div>
</li>
<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Jalur Penerimaan</div>
            <div class="item-input-wrap">
                <input type="text" name="jalur_penerimaan" value="<?= $data['jalur_penerimaan'] ?>" placeholder="Jalur Penerimaan" />
            </div>
        </div>
    </div>
</li>
<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Jurusan</div>
            <div class="item-input-wrap">
                <input type="text" name="jurusan" value="<?= $data['jurusan'] ?>" placeholder="Jurusan" />
            </div>
        </div>
    </div>
</li>
<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Tahun Masuk</div>
            <div class="item-input-wrap">
                <input type="text" name="tahun_masuk" value="<?= $data['tahun_masuk'] ?>" placeholder="Tahun Masuk" />
            </div>
        </div>
    </div>
</li>
<li>
    <div class="item-content item-input">
        <div class="item-inner">
            <div class="item-title item-label">Tahun Keluar</div>
            <div class="item-input-wrap">
                <input type="text" name="tahun_keluar" value="<?= $data['tahun_keluar'] ?>" placeholder="Tahun Keluar" />
            </div>
        </div>
    </div>
</li>
