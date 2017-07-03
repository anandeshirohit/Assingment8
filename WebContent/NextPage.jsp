<jsp:useBean id="book" class="MyPack.Book" scope="session"/>
Book Name: <jsp:getProperty property="bname" name="book"/><br>
Book Numb:<jsp:getProperty property="bno" name="book"/><br>
Book Price:<jsp:getProperty property="bprice" name="book"/><br>

