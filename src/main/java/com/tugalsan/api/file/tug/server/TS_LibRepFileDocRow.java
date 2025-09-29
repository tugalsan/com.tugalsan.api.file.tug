package com.tugalsan.api.file.tug.server;

import module com.tugalsan.api.list;
import java.util.*;

public class TS_LibRepFileDocRow {

    public List<TS_LibRepFileDocCell> cells;

    public TS_LibRepFileDocRow() {
        cells = TGS_ListUtils.of();
    }

    public TS_LibRepFileDocCell getCurrentCell() {
        if (cells.isEmpty()) {
            cells.add(new TS_LibRepFileDocCell());
        }
        return cells.get(cells.size() - 1);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("<tr>\n");
        cells.stream().forEachOrdered(cell -> sb.append(cell));
        sb.append("</tr>\n");
        return sb.toString();
    }

}
