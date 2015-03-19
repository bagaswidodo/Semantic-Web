<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="TambahMedia">
            <table border="0" class="input">  
                <tr>
                    <td>Nama Media</td><td>:</td>
                    <td><input type="text"  name="txtnama_media" style="width: 290px;"></td>
                </tr>
                <tr>
                    <td>Fungsi Media</td><td>:</td>
                    <td><textarea name="txtfungsi" style="width: 580px; height:
                                  100px"></textarea></td>
                </tr>
                <tr>
                    <td>Keterangan</td><td>:</td>
                    <td><textarea name="txtcara_pembuatan" style="width: 580px; height:
                                  100px"></textarea></td>
                </tr>
                <tr>
                    <td>Upload Gambar</td><td>:</td>
                    <td><input name="uploadFile" type="file" value="Cari Gambar"></td>
                </tr>  
                <tr>
                    <td  align="right"> <input type="submit" value="Simpan" class="buton"></td>
                </tr>
            </table>
        </form>

    </body>
</html>
