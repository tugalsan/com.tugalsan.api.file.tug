module com.tugalsan.api.file.tug {
    requires java.desktop;
    requires jai.imageio.core;
//    requires net.sf.cssbox.pdf2dom;
    requires com.tugalsan.api.crypto;
    requires com.tugalsan.api.string;
    requires com.tugalsan.api.file.common;
    requires com.tugalsan.api.url;
    
    requires com.tugalsan.api.stream;
    requires com.tugalsan.api.function;
    requires com.tugalsan.api.list;
    requires com.tugalsan.api.charset;
    requires com.tugalsan.api.log;
    requires com.tugalsan.api.shape;
    requires com.tugalsan.api.file;
    requires com.tugalsan.api.file.txt;
    requires com.tugalsan.api.file.html;
    requires com.tugalsan.api.file.img;
    exports com.tugalsan.api.file.tug.server;
}
