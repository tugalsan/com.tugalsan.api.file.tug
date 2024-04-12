package com.tugalsan.api.file.tug.server;

import com.tugalsan.api.crypto.client.TGS_CryptUtils;
import com.tugalsan.api.file.txt.server.TS_FileTxtUtils;
import com.tugalsan.api.string.client.*;
import com.tugalsan.api.union.client.TGS_UnionExcuse;
import com.tugalsan.api.url.client.*;
import com.tugalsan.api.url.server.*;
import java.nio.file.*;

public class TS_LibRepFileDocData {

    public static boolean DEFAULT_ISTEXT() {
        return true;
    }

    public static String LINEBREAK() {
        return "LINEBREAK";
    }

    public boolean isText_notImage;
    public String data;//text or image_loc
    public int imageWith = 200;
    public int imageHeight = 75;
    public String imageBase64 = null;

    public TS_LibRepFileDocData(String data) {
        this(DEFAULT_ISTEXT(), data);
    }

    public TS_LibRepFileDocData(boolean isText_notImage, String data) {
        this.isText_notImage = isText_notImage;
        this.data = data;

        if (!isText_notImage) {
            var url = TGS_Url.of(data);
            TGS_UnionExcuse<String> u_base64;
            if (TGS_UrlUtils.isValidUrl(url)) {
                u_base64 = TS_UrlDownloadUtils.toBase64(url);
                if (imageBase64 == null) {
                    imageBase64 = "null";
                }
            } else {
                var path = Path.of(data);
                var u_read = TS_FileTxtUtils.toString(path);
                u_base64 = u_read.isExcuse() ? u_read.toExcuse() : TGS_CryptUtils.encrypt64(u_read.value());
            }
            imageBase64 = u_base64.isExcuse() ? u_base64.excuse().getMessage() : u_base64.value();
        }
    }

    @Override
    public String toString() {
        if (isText_notImage) {
            return TGS_StringUtils.concat(data, "\n");
        } else {
            return TGS_StringUtils.concat("<img style='display:block; width:", String.valueOf(imageWith), "px;height:", String.valueOf(imageHeight), "px;' src='data:image/jpeg;base64, ", String.valueOf(imageBase64), "' />\n");
        }
    }
}
