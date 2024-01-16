package com.tugalsan.api.file.tug.server;

import com.tugalsan.api.list.client.*;
import java.util.*;

public class TS_LibRepFileDocParag {

    public static int DEFAULT_ALLIGN() {
        return 0;
    }

    public List<TS_LibRepFileDocData> data;
    int allign_Left0_center1_right2_just3;

    public TS_LibRepFileDocParag() {
        this(DEFAULT_ALLIGN());
    }

    public TS_LibRepFileDocParag(int allign_Left0_center1_right2_just3) {
        data = TGS_ListUtils.of();
        this.allign_Left0_center1_right2_just3 = allign_Left0_center1_right2_just3;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("<p>\n");
        data.stream().forEachOrdered(dat -> sb.append(dat));
        sb.append("</p>\n");
        return sb.toString();
    }
}
