package net.eldiosantos.messenger.taglib;


import net.eldiosantos.messenger.taglib.modelelements.Table;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;
import java.util.List;

/**
 * Created by eldio.junior on 05/03/2015.
 */
public class TableCreator implements BodyTag {

    private Table table;
    private List<Object>objects;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public static String createTable() {
        return "<!-- Comentario -->";
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        try {
            bodyContent.getEnclosingWriter().write(createTable().toCharArray());
            bodyContent.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doInitBody() throws JspException {

    }

    @Override
    public int doAfterBody() throws JspException {
        return 0;
    }

    @Override
    public void setPageContext(PageContext pageContext) {

    }

    @Override
    public void setParent(Tag tag) {

    }

    @Override
    public Tag getParent() {
        return null;
    }

    @Override
    public int doStartTag() throws JspException {
        return 0;
    }

    @Override
    public int doEndTag() throws JspException {
        return 0;
    }

    @Override
    public void release() {

    }
}
