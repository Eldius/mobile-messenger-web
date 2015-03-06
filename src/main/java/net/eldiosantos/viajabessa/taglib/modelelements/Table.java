package net.eldiosantos.viajabessa.taglib.modelelements;

import java.util.List;

/**
 * Created by eldio.junior on 05/03/2015.
 */
public class Table {
    private List<TableColumn>columns;

    public List<TableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TableColumn> columns) {
        this.columns = columns;
    }
}
