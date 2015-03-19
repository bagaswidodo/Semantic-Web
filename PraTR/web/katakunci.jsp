<%-- 
    Document   : katakunci
    Created on : Mar 19, 2015, 4:24:53 PM
    Author     : BagasWidodo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="formsearch" name="formsearch" method="post"
              action="hasilcari.jsp">
            <div>Masukkan Kata Kunci</div>
            <span>
                <input name="txtcari" style="width: 900px" class="editbox_search"
                       id="editbox_search" maxlength="900" type="text" />
            </span>
            <input class="button_search" type="submit"  value="Cari" style="width:
                   40px;height: 29px"/>
        </form>


    </body>
</html>
